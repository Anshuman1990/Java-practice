package com.designPattern.Structural.facade;

public class NonVegRestaurant implements Hotel {
    @Override
    public Menu getMenus() {
        return new NonVegMenu();
    }
}
