package com.hackerrank.algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MigratoryBirds {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfBirds = scanner.nextInt();
        List<Integer> arr = Stream.of(scanner.next().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(migratoryBirds(arr));
        scanner.close();
    }

    static int migratoryBirds(List<Integer> arr) {
        int result = 0;
        SortedMap<Integer, Integer> sortedMap = new TreeMap(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        arr.forEach(integer -> {
            if (sortedMap.containsKey(integer)) {
                int count = sortedMap.get(integer) + 1;
                sortedMap.put(integer, count);
            } else {
                sortedMap.put(integer, 1);
            }
        });
        System.out.println(sortedMap);
        return result;
    }
}
