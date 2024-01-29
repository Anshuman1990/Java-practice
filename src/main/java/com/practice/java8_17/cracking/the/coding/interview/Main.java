package com.practice.cracking.the.coding.interview;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isPermute("abcd","cdab"));
    }

    public boolean isPermute(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        if(lenA != lenB) return false;
        int result = 0;
        for(int i=0;i<lenA;i++){
            int chA = A.charAt(i);
            int chB = B.charAt(i);
            result = result+(chA-chB);
        }
        return result == 0;
    }

}
