package com.practice.java8_17.designPattern.Structural.decorator;

public class SimplePizza extends Pizza {
    SimplePizza() {
        description = "SimplePizza";
    }

    @Override
    public int getCost() {
        return 25;
    }
}
