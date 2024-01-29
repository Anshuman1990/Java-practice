package com.practice.java8_17.language.exception;


class Base extends Exception {}
class Derived extends Base  {}

public class Main {
    public static void main(String args[]) {
        // some other stuff
        try {
            // Some monitored code
            throw new Derived();
        }
        catch(Derived b)     {
            System.out.println("Caught base class exception");
        }
        catch(Base d)  {
            System.out.println("Caught derived class exception");
        }
    }
}
