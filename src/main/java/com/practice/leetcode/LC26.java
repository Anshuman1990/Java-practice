package com.practice.leetcode;

public class LC26 {
    public static void main(String[] args) {
        LC26 lc26 = new LC26();
        int[] nums = {1,2,3,4,4};
        System.out.println(lc26.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 0;
        int removalCounter = 0;
        int[] duplicates = new int[nums.length];
        int dupIndex = 0;
        for(int i=0;i<nums.length;i++) {
            int val = nums[i];
            int duplicate = duplicates[dupIndex];
            if(i == 0) duplicates[0] = val;
            if(val == duplicate) {
                removalCounter++;
            } else {
                duplicates[dupIndex] = val;
                dupIndex++;
            }
        }
        return removalCounter;
    }
}
