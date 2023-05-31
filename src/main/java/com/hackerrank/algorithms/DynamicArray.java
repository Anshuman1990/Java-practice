package com.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DynamicArray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] firstMultipleInput = scanner.nextLine().split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            queries.add(
                    Stream.of(scanner.nextLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(toList())
            );
        });

        List<Integer> result = dynamicArray(n, queries);

        result.forEach(integer -> System.out.println(integer));
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        scanner.close();
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> seqList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        List<Integer> integerList = new ArrayList<>();
        int lA = 0;
        for (List<Integer> query : queries) {
            lA = queries(query, seqList, n, lA);
            if (query.get(0) == 2) {
                integerList.add(lA);
            }
        }
        return integerList;
    }


    public static int queries(List<Integer> arr, List<List<Integer>> seqList, int n, int lA) {
        int index = 0;
        int queryType = arr.get(0);
        int x = arr.get(1);
        int y = arr.get(2);
        if (queryType == 1) {
            index = formula(x, lA, n);
            seqList.get(index).add(y);
        } else if (queryType == 2) {
            index = formula(x, lA, n);
            int size = seqList.get(index).size() - 1;
            lA = seqList.get(index).get(size);
        }
        return lA;
    }

    public static int formula(int x, int lA, int n) {
        return (x ^ lA) % n;
    }
}
