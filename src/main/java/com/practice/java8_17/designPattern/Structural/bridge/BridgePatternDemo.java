package com.practice.java8_17.designPattern.Structural.bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Workshop[] workshops = {new Assemble(),new Produce()};
        Vehicle v1 = new Car(workshops);
        v1.manufacture();
        System.out.println();
        Vehicle v2 = new Bike(workshops);
        v2.manufacture();
    }
}
