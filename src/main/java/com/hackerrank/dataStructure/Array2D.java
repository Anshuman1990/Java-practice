package com.hackerrank.dataStructure;

import java.util.Scanner;

public class Array2D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
    }

    static int hourglassSum(int[][] arr) {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = getSum(i, j, arr);
                if (i == 0 && j == 0) {
                    total = temp;
                }
                if (temp > total) {
                    total = temp;
                }
            }
        }

        System.out.println(total);
        return total;
    }

    static int getSum(int i, int j, int[][] arr) {
        int sum = 0;
        int counter = 0;
        while (counter < 3) {
            sum += arr[i][j + counter];
            sum += arr[i + 2][j + counter];
            counter++;
        }
        sum += arr[i + 1][j + 1];
        return sum;
    }


}
