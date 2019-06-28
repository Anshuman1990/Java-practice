package com.designPattern.Behavioral.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.buttonWasPressed();

        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.buttonWasPressed();

        remoteControl.setCommand(new StereoOnWithCDCommand(stereo));
        remoteControl.buttonWasPressed();

        remoteControl.setCommand(new StereoOffCommand(stereo));
        remoteControl.buttonWasPressed();
    }
}
