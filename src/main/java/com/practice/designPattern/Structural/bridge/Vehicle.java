package com.practice.designPattern.Structural.bridge;

public abstract class Vehicle {
    protected Workshop[] workshops;
    Vehicle(Workshop[] currentWorkshops){
        this.workshops = currentWorkshops;
    }
    public abstract void manufacture();
}
