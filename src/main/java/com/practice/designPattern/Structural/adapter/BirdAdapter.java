package com.practice.designPattern.Structural.adapter;

public class BirdAdapter implements ToyDuck {
    Bird bird;

    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void squeak() {
        this.bird.makeSound();
    }
}
