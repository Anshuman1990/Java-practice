package com.practice.leetcode.company.adobe;

public class TwoSum {
    public static void main(String[] args) {

    }
    public int[] solution(int[] arr, int target) {
        int[] result = new int[5];
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n;j++) {
                if((arr[i] + arr[j]) == target) {

                }
            }
        }
        return result;
    }
}
