package  com.practice.java8_17.leetcode;
/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
Related Topics
Array
Binary Search

👍 18816
👎 453
* */
public class LC34 {
    public static void main(String[] args) {
        LC34 lc34 = new LC34();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

    }
    public int[] searchRange(int[] nums, int target) {
        int[] notFound = {-1, 1};
        int length = nums.length;

        return notFound;
    }
}
