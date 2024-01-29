package com.practice.java8_17.designPattern.Structural.bridge;

public abstract class Vehicle {
    protected Workshop[] workshops;
    Vehicle(Workshop[] currentWorkshops){
        this.workshops = currentWorkshops;
    }
    public abstract void manufacture();
}
