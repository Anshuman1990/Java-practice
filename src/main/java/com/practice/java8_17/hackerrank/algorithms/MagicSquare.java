package com.practice.hackerrank.algorithms;

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

    static int formingMagicSquare(int[][] s) {
        int cost = 0;
        int costRow = row(s);
        int costCol = column(s);
        cost = costRow;
        return cost;

    }

    private static int sum(int... arg) {
        return arg[0] + arg[1] + arg[2];
    }

    public static int row(int[][] array) {
        int cost = 0;
        System.out.println("-----------------------------------------ROW------------------------");
        for (int i = 0; i < array.length; i++) {
            int sum = sum(array[i]);
            if (sum != 15) {
                int diff = Math.abs(15 - sum);
                cost = cost+diff;
                System.out.println(i + ">>>>>>>>>>>>" + sum + ">>>>>>>>>>>>>>>>>>>>>>>>>" + diff);
            }
        }
        return cost;
    }

    public static int column(int[][] array) {
        int cost = 0;
        System.out.println("-----------------------------------------COLUMN------------------------");
        for (int i = 0; i < array.length; i++) {
            int[] cols = new int[3];
            for (int j = 0; j < array.length; j++) {
                cols[j] = array[j][i];
            }
            int sum = sum(cols);
            if (sum != 15) {
                int diff = Math.abs(15 - sum);
                cost = cost+diff;
                System.out.println(i + ">>>>>>>>>>>>>>>>>>>" + sum + ">>>>>>>>>>>>>>>>>>>>>>>>>" + diff);
            }
        }
        return cost;
    }

    public void diagonal(int[][] array) {
        System.out.println("-----------------------------------------DIAGONAL------------------------");
        int[] d1 = new int[3];
        int[] d2 = new int[3];
        int j = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            d1[i] = array[i][i];
            d2[i] = array[i][j];
            j--;
        }
        int sumD1 = sum(d1);
        int sumD2 = sum(d2);
        int diff = 0;
        if (sumD1 != 15) {
            diff = 15 - sumD1;
            System.out.println(d1+">>>>>>>>>>>>>>>>>>>>>>>>>>>"+sumD1 + ">>>>>>>>>>>>>D1>>>>>>>>>>>>>>>>>" + diff);
        }
        if (sumD2 != 15) {
            diff = 15 - sumD2;
            System.out.println(d2+">>>>>>>>>>>>>>>>>>>>>>>"+sumD2 + ">>>>>>>>>>>>>D2>>>>>>>>>>>>>>>" + diff);
        }
    }

}
