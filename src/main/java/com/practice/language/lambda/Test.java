package com.practice.language.lambda;

public class Test {

    interface Funct1{
        int operation(int a, int b);
    }

    interface  Funct2{
        void sayMessage(String message);
    }

    private int operate(int a, int b, Funct1 fobj)
    {
        return fobj.operation(a, b);
    }

    public static void main(String[] args) {
        Funct1 funct1_add = (a, b) -> a+b;

        Funct1 funct1_mul = (a, b) -> a*b;

        Test test = new Test();

        System.out.println(funct1_add.operation(3,4));

        System.out.println(funct1_mul.operation(4,5));
    }
}
