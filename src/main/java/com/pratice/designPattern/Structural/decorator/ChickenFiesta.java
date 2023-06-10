package com.designPattern.Structural.decorator;

public class ChickenFiesta extends Pizza {

    ChickenFiesta(){
        description = "ChickenFiesta";
    }
    @Override
    public int getCost() {
        return 50;
    }
}
