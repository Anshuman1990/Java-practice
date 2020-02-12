package com.hackerrank.algorithms;

import java.util.Scanner;

/**
 * @author asaha
 */

public class MagicSquare {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);


        scanner.close();
    }

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int result = 0;
        int sum = 15;
        row(s);
        column(s);
        diagonal(s);
        return result;
    }

    static void row(int[][] s) {
        System.out.println("-----------------------------------ROW--------------------------------");
        for (int i = 0; i < s.length; i++) {
            int sum = sum(s[i]);
            if (sum != 15) {
                int diff = 15 - sum;
                System.out.println(sum + ">>>>>>>>>" + diff + ">>>>>>>>>" + i);
            }
        }
    }

    static void column(int[][] s) {
        System.out.println("-----------------------------------COLUMN--------------------------------");
        for (int i = 0; i < s.length; i++) {
            int[] cols = new int[3];
            for (int j = 0; j < s.length; j++) {
                cols[j] = s[j][i];
            }
            int sum = sum(cols);
            if (sum != 15) {
                int diff = 15 - sum;
                System.out.println(sum + ">>>>>>>>>" + diff + ">>>>>>>>>" + i);
            }
        }
    }

    static void diagonal(int[][] s) {
        System.out.println("-----------------------------------DIAGONAL--------------------------------");
        int[] d1 = new int[3];
        int[] d2 = new int[3];
        int j = s.length - 1;
        int diff = 0;
        for (int i = 0; i < s.length; i++) {
            d1[i] = s[i][i];
            d2[i] = s[i][j];
            j--;
        }
        int sumD1 = sum(d1);
        int sumD2 = sum(d2);
        if (sumD1 != 15) {
            diff = 15 - sumD1;
            System.out.println(sumD1 + ">>>>>>>>>>>>>" + diff + ">>>>>>>>>>>>>D1");
        }
        if (sumD2 != 15) {
            diff = 15 - sumD2;
            System.out.println(sumD2 + ">>>>>>>>>>>>>>" + diff + ">>>>>>>>>>>>>D2");
        }
    }

    static int sum(int... a) {
        return a[0] + a[1] + a[2];
    }

}
