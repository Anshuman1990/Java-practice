package com.hackerrank.Interview_Preparation_Kit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        path = path+ File.separator+"hackerrank"+File.separator+"result";
        System.setProperty("OUTPUT_PATH",path);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int totalMountain = 0;
        int totalValley = 0;

        int D_count = 0;
        int C_count = 0;
        boolean isMountain = false;
        boolean isValley = false;
    for(int i=0;i<n;i++){
        String ch = s.valueOf(i);

        if(D_count == C_count && D_count != 0 && C_count != 0) {
            D_count = 0;
            C_count = 0;
            isMountain = false;
            isValley = false;
            switch (ch.toUpperCase()) {
                case "U":
                    isMountain = true;
                    ++C_count;
                    break;

                case "D":
                    isValley = true;
                    ++D_count;
                    break;
            }
        }
        else{
            switch (ch.toUpperCase()) {
                case "U":
                    ++C_count;
                    break;

                case "D":
                    ++D_count;
                    break;
            }
        }
    }
return 0;
    }
}
