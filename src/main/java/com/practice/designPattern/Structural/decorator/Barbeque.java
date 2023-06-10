package com.practice.designPattern.Structural.decorator;

public class Barbeque extends ToppingsDecorator {
    private Pizza pizza;

    Barbeque(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", Fresh Tomato ";
    }

    @Override
    public int getCost() {
        return 90 + pizza.getCost();
    }
}
