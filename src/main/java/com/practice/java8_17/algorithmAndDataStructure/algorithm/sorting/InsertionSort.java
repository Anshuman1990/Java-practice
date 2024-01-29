package com.practice.java8_17.algorithmAndDataStructure.algorithm.sorting;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] data = {5, 2, 4, 6, 1, 3,2,3,46,1,1,12,34,6,3,3432,123,34,56,0};
        insertionSort.print(data);
        System.out.println("---------------------------------AFTER SORTING---------------------");
        Instant start = Instant.now();
        int[] sortedData = insertionSort.sort(data);
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("Time taken: "+ duration.toNanos() +" nanoseconds");
        insertionSort.print(sortedData);
    }

    public int[] sort(int[] data) {
        int size = data.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            while(j>0 && data[j-1] > data[j]){
                int key = data[j];
                data[j] = data[j-1];
                data[j-1] = key;
                j=j-1;
            }
        }
        return data;
    }

    public void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i != data.length - 1) {
                System.out.print(",");
            }
            else{
                System.out.println();
            }
        }
    }
}
