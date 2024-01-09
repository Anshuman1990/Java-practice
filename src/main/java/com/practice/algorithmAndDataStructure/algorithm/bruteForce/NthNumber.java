package com.practice.algorithmAndDataStructure.algorithm.bruteForce;

public class NthNumber {
    public static void main(String[] args) {
        System.out.println(get(15));
    }

    static long get(long n){
        int counter = 1;
        while(n>0){
            n = n-counter;
            counter++;
        }
        return (counter-1)+n;
    }
}
