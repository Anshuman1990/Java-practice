package com.designPattern.Structural.decorator;

public class Margherita extends Pizza {
    Margherita(){
        description = "Margherita";
    }
    @Override
    public int getCost() {
        return 150;
    }
}
