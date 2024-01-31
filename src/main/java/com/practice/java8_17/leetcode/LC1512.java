package  com.practice.java8_17.leetcode;

public class LC1512 {
    /*
* Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
Related Topics
Array
Hash Table
Math
Counting
👍 4550
👎 210
    * */

    public static void main(String[] args) {
        LC1512 lc1512 = new LC1512();
        int[] nums = {1,2,3};
        System.out.println(lc1512.numIdenticalPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {
        if(null == nums || nums.length < 1) return 0;
        int goodPairCount = 0;
        for(int i=0;i<nums.length;i++){
            int pivot = nums[i];
            for(int j=i+1; j<nums.length;j++){
                int val = nums[j];
                if(j>i && pivot == val){
                    goodPairCount++;
                }
            }
        }
        return goodPairCount;
    }
}
