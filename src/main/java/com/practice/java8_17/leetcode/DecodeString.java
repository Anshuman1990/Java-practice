package com.practice.leetcode;


public class DecodeString {

    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
    }

    public static String decodeString(String s) {
        StringBuilder sbuild = new StringBuilder();
        String[] arr = s.split("^([1-9][0-9][0-9]*)[a-z]*");
        showArray(arr);
        return sbuild.toString();
    }

    static void showArray(String [] a) {
        for (String s : a) {
            System.out.println(s);
        }
    }
}
