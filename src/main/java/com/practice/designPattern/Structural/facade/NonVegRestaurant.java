package com.practice.designPattern.Structural.facade;

public class NonVegRestaurant implements Hotel {
    @Override
    public Menu getMenus() {
        return new NonVegMenu();
    }
}
