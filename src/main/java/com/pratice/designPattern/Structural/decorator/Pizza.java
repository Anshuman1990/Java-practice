package com.designPattern.Structural.decorator;

public abstract class Pizza {
    String description = "Unkknown Pizza";

    public String getDescription() {
        return description;
    }

    public abstract int getCost();
}
