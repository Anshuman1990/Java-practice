package com.designPattern.Behavioral.command;

public class SimpleRemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        this.command.execute();
    }
}
