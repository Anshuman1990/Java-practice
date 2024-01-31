package com.practice.java8_17.cracking.the.coding.interview;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndStrings {
    public static void main(String[] args) {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        System.out.println(arraysAndStrings.URLify("Mr Anshuman Saha                   ", 16));
        System.out.println(1%2);
        arraysAndStrings.palindromePermutation("tactcoa");
    }

    // 1.3
    public char[] URLify(String str, int trueLength) {
        char[] chArray = str.toCharArray();
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (chArray[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length()) chArray[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (chArray[i] == ' ') {
                chArray[index - 1] = '0';
                chArray[index - 2] = '2';
                chArray[index - 3] = '%';
                index = index - 3;
            } else {
                chArray[index - 1] = chArray[i];
                index--;
            }
        }
        return chArray;
    }

    // 1.4
    public boolean palindromePermutation(String str) {
        Map<Character, Integer> characterCount = new HashMap<>();
        int length = str.length();
        if (length == 0 || length == 2) {
            return false;
        }
        boolean isLenOdd = length % 2 != 0;
        for (int i = 0; i < str.length(); i++) {
            if (characterCount.containsKey(str.charAt(i))) {
                characterCount.put(str.charAt(i), characterCount.get(str.charAt(i)) + 1);
            } else {
                characterCount.put(str.charAt(i), 1);
            }
        }
        System.out.println(characterCount);

        return false;
    }

}
