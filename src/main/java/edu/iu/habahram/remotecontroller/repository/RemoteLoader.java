package edu.iu.habahram.remotecontroller.repository;

import edu.iu.habahram.remotecontroller.model.DeviceData;
import edu.iu.habahram.remotecontroller.model.Light;
import edu.iu.habahram.remotecontroller.model.RemoteControl;
import edu.iu.habahram.remotecontroller.model.Stereo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoteLoader implements  IRemoteLoader{
    private static RemoteLoader instance;
    HashMap<Integer, RemoteControl> remoteControls = new HashMap<>();
    private HashMap<Integer, Stereo> stereos = new HashMap<>();
    private RemoteLoader() {
    }

    public static RemoteLoader getInstance() {
        if (instance == null) {
            instance = new RemoteLoader();
        }
        return instance;
    }

    @Override
    public void setup(int id, List<DeviceData> devices) {
        RemoteControl remoteControl = new RemoteControl(devices.size());
        Stereo stereo = new Stereo();
        for(DeviceData device : devices) {
            switch (device.type()) {
                case "light":
                    Light light = new Light(device.location());
                    remoteControl.setCommand(device.slot(), light::on, light::off);
                    break;
            }
        }
        remoteControls.put(id, remoteControl);
        stereos.put(id, stereo);
        System.out.println(remoteControl.toString());
        System.out.println(stereo.toString());
    }

    @Override
    public String onButtonWasPushed(int id, int slot) {
         return remoteControls.get(id).onButtonWasPushed(slot);
    }

    @Override
    public String offButtonWasPushed(int id, int slot) {
        return remoteControls.get(id).offButtonWasPushed(slot);
    }

    public String setStereoVolume(int id, int volume) {
        Stereo stereo = stereos.get(id);
        stereo.setVolume(volume);
        return "Stereo volume set to " + volume;
    }
}
