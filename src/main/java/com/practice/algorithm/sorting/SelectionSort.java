package com.practice.algorithm.sorting;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] data = {5, 2, 4, 6, 1, 3,2,3,46,1,1,12,34,6,3,3432,123,34,56,0};
        selectionSort.print(data);
        System.out.println("---------------------------------AFTER SORTING---------------------");
        Instant start = Instant.now();
        int[] sortedData = selectionSort.sort(data);
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("Time taken: "+ duration.toNanos() +" nanoseconds");
        selectionSort.print(sortedData);
    }

    public int[] sort(int data[]){
        for(int i=0;i<data.length;i++){
            int min = i;
            for(int j=i+1;j< data.length;j++){
                if(data[j] < data[min]){
                    min = j;
                }
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
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
