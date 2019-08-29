package com.language.lambda;

@FunctionalInterface
public interface lambdaTest {

    public void print();

    public default void test() {
        System.out.println("default");
    }

}
