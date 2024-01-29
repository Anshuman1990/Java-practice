package com.practice.leetcode;

import java.util.Scanner;

public class PickupDelivery {
    public static void main(String[] args) {
        PickupDelivery pickupDelivery = new PickupDelivery();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(pickupDelivery.countOrders(n));
    }

    public int countOrders(int n) {
        int totalCombination = n * 2;
        int[][] pickDeli = new int[n][2];
        int[] p = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            d[i] = i;
        }

        return 0;
    }
}
