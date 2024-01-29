package com.practice.java8_17.designPattern.Behavioral.command;

public class StereoOffCommand implements Command {
    private Stereo stereo;

    StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        this.stereo.off();
    }
}
