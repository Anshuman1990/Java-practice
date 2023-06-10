package com.practice.language.lambda;

public interface DefaultInterface {

    default String test(functionalTest functionalTest){
        return functionalTest.lambda("TESTING");
    }


}
