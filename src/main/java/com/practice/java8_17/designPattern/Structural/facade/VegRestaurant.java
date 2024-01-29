package com.practice.java8_17.designPattern.Structural.facade;

public class VegRestaurant  implements  Hotel{
    @Override
    public Menu getMenus() {
        return new VegMenu();
    }
}
