package com.practice.java8_17.designPattern.Structural.decorator;

public class PeppyPaneer extends Pizza {
    PeppyPaneer() {
        description = "PeppyPaneer";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
