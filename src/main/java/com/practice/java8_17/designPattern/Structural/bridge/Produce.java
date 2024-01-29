package com.practice.java8_17.designPattern.Structural.bridge;

public class Produce implements Workshop {
    @Override
    public void work() {
        System.out.print("Produced ");
    }
}
