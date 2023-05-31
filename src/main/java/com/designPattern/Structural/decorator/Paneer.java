package com.designPattern.Structural.decorator;

public class Paneer extends ToppingsDecorator {
    private Pizza pizza;

    Paneer(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", Paneer ";
    }

    @Override
    public int getCost() {
        return 70 + pizza.getCost();
    }
}
