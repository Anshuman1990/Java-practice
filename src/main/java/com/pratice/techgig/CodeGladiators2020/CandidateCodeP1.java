package com.techgig.CodeGladiators2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CandidateCodeP1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<Long> ingredientRequired = Stream.of(scanner.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        List<Long> ingredientPresent = Stream.of(scanner.nextLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        System.out.println(maximumNumber(N, ingredientRequired, ingredientPresent));
    }

    static long maximumNumber(int N, List<Long> ingredientRequired, List<Long> ingredientPresent) {
        long num = 0;
        for (int i = 0; i < N; i++) {
            long temp = ingredientPresent.get(i) / ingredientRequired.get(i);
            if (i != 0) {
                num = (num < temp) ? num : temp;
            } else {
                num = temp;
            }
        }
        return num;
    }
}
