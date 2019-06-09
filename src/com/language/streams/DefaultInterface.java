package com.language.streams;

public interface DefaultInterface {

    default String test(functionalTest functionalTest){
        return functionalTest.lambda("TESTING");
    }


}
