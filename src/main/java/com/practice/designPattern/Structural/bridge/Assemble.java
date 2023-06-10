package com.practice.designPattern.Structural.bridge;

public class Assemble implements  Workshop {
    @Override
    public void work() {
        System.out.print("Assembled ");
    }
}
