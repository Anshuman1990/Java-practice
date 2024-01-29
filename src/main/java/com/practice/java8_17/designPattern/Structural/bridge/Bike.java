package com.practice.java8_17.designPattern.Structural.bridge;

public class Bike extends Vehicle {
    Bike(Workshop[] currentWorkshops) {
        super(currentWorkshops);
    }

    @Override
    public void manufacture() {
        System.out.print("Bike... ");
        for (Workshop workshop : workshops) {
            workshop.work();
        }
    }
}
