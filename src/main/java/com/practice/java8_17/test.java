package com.practice.java8_17;

public class test {

    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;


        test(99.9);

        int num1 = 0;
        int num2 = 0;
        for (int var = 0; var < 5; var++) {
            if ((++num1 > 2) && (++num2 > 2)) {
                num1++;
            }
        }
        System.out.println(num1 + " and " + num2);
        System.out.println(5 / (float)18 * 300);
    }

    static void test(float x){
        System.out.println("Float");
    }

    static void test(double x){
        System.out.println("Doublse");
    }
}
