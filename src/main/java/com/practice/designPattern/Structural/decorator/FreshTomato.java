package com.practice.designPattern.Structural.decorator;

public class FreshTomato extends ToppingsDecorator {
    private Pizza pizza;

    FreshTomato(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", Fresh Tomato ";
    }

    @Override
    public int getCost() {
        return this.pizza.getCost() + 40;
    }
}
