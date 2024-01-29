package com.practice.java8_17.designPattern.Behavioral.command;

public class StereoOnWithCDCommand implements Command {
    private Stereo stereo;

    StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        this.stereo.on();
        this.stereo.setCD();
        this.stereo.setVolume(11);
    }
}
