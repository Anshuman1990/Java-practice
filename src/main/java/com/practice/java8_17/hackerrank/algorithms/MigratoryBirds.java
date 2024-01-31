package  com.practice.java8_17.hackerrank.algorithms;

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
        Map<Integer, Integer> sortedMap = new HashMap<>();
        arr.forEach(integer -> {
            if (sortedMap.containsKey(integer)) {
                int count = sortedMap.get(integer) + 1;
                sortedMap.put(integer, count);
            } else {
                sortedMap.put(integer, 1);
            }
        });
        Map.Entry<Integer, Integer> entry = sortedMap.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).findFirst().get();
        return entry.getKey();
    }
}
