package com.practice.java8_17.designPattern.Structural.adapter;

public class PlasticToyDuck implements ToyDuck {
    @Override
    public void squeak() {
        System.out.println("Squeak");
    }
}
