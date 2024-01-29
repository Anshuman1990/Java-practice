package com.practice.java8_17.language.lambda;

public class Lambdamain {

    public static void main(String[] args) {

        final String name = "Anshuman Saha";
        lambdaTest lambdaTest = () -> {
            System.out.println(name);
        };
        lambdaTest.print();
        lambdaTest.test();
    }
}
