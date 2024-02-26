package edu.iu.habahram.remotecontroller.model;

public class Stereo {
    private boolean isOn;
    private boolean isPlayingCD;
    private boolean isPlayingDVD;
    private boolean isPlayingRadio;
    private int volume;

    public void on() {
        isOn = true;
        playCD();
        setVolume(8);
    }

    public void off() {
        isOn = false;
        isPlayingCD = false;
        isPlayingDVD = false;
        isPlayingRadio = false;
        volume = 0;
    }

    public void playCD() {
        isPlayingCD = true;
        isPlayingDVD = false;
        isPlayingRadio = false;
    }

    public void playDVD() {
        isPlayingCD = false;
        isPlayingDVD = true;
        isPlayingRadio = false;
    }

    public void playRadio() {
        isPlayingCD = false;
        isPlayingDVD = false;
        isPlayingRadio = true;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String toString() {
        return "Stereo { isOn: " + isOn +
                ", isPlayingCD: " + isPlayingCD +
                ", isPlayingDVD: " + isPlayingDVD +
                ", isPlayingRadio: " + isPlayingRadio +
                ", volume: " + volume + " }";
    }
}
