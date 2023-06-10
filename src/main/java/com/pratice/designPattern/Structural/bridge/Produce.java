package com.designPattern.Structural.bridge;

public class Produce implements Workshop {
    @Override
    public void work() {
        System.out.print("Produced ");
    }
}
