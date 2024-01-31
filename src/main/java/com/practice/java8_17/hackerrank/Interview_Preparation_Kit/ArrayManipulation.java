package  com.practice.java8_17.hackerrank.Interview_Preparation_Kit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ArrayManipulation {


    private static final Scanner scanner = new Scanner(System.in);

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long maxValue = 0;

        Map<Integer, Long> data = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            data.put(i, 0L);
        }
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            long value = queries[i][2];
            for (int j = startIndex-1; j < endIndex; j++) {
            long val = data.get(j);
            val = val+value;
            data.put(j,val);
            }
        }

        System.out.println(data);

        return maxValue;
    }



    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        path = path + File.separator + "hackerrank" + File.separator + "result";
        System.setProperty("OUTPUT_PATH", path);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
