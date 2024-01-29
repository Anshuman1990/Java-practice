package com.practice.java8_17.designPattern.Structural.decorator;

public class ChickenFiesta extends Pizza {

    ChickenFiesta(){
        description = "ChickenFiesta";
    }
    @Override
    public int getCost() {
        return 50;
    }
}
