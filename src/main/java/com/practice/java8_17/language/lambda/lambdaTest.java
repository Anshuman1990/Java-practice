package com.practice.java8_17.language.lambda;

@FunctionalInterface
public interface lambdaTest {

    public void print();

    public default void test() {
        System.out.println("default");
    }

}
