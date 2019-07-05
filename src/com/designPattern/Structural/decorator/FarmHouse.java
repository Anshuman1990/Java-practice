package com.designPattern.Structural.decorator;

public class FarmHouse extends Pizza {

    FarmHouse() {
        description = "FarmHouse";
    }

    @Override
    public int getCost() {
        return 200;
    }
}
