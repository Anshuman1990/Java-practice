package com.practice.java8_17.language.lambda;

public interface DefaultInterface {

    default String test(com.practice.java8_17.language.lambda.functionalTest functionalTest){
        return functionalTest.lambda("TESTING");
    }


}
