package com.practice.java8_17.designPattern.Structural.bridge;

public class Car extends Vehicle{

    Car(Workshop[] currentWorkshops) {
        super(currentWorkshops);
    }

    @Override
    public void manufacture() {
        System.out.print("Car... ");
        for (Workshop workshop : workshops) {
            workshop.work();
        }
    }
}
