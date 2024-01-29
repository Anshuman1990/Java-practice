package com.practice.techgig.open;

import java.io.*;
import java.util.*;

public class CandidateCode {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String virusComposition = scanner.next();
        int numberOfPeople = scanner.nextInt();
        List<String> bloodCompositions = new ArrayList(numberOfPeople);
        for (int i = 0; i < numberOfPeople; i++) {
            bloodCompositions.add(scanner.next());
        }
        bloodCompositions.forEach(s -> System.out.println(Status(virusComposition, s)));
    }

    public static String Status(String virusComposition, String bloodComposition) {
        String result = "NEGATIVE";
        int startIndex = 0;
        int endIndex = virusComposition.length();
        int count = 0;
        boolean checker = false;
        for (int i = 0; i < bloodComposition.length(); i++) {
            char c = bloodComposition.charAt(i);
            CharSequence charSequence = virusComposition.subSequence(startIndex, endIndex);
            checker = false;
            for (int j = 0; j < charSequence.length(); j++) {
                if (c == charSequence.charAt(j)) {
                    count++;
                    checker = true;
                    startIndex = j + 1;
                    break;
                }
            }
            if (!checker) {
                break;
            }
        }
        if (count == bloodComposition.length()) {
            result = "POSITIVE";
        }
        return result;
    }
}
