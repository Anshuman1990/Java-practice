package  com.practice.java8_17.leetcode;

public class LC905 {
    /*
    * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
Related Topics
Array
Two Pointers
Sorting

👍 5022
👎 139
    *
    * */

    public static void main(String[] args) {
        int nums[] = {0,2};
        LC905 lc905 = new LC905();
        int[] sortArrayByParity = lc905.sortArrayByParity(nums);
        for (int j : sortArrayByParity) {
            System.out.println(j);
        }
    }

    public int[] sortArrayByParity(int[] nums) {
        if(nums != null && nums.length >= 1){
            int totalSize = nums.length;
            if(totalSize == 1){
                return nums;
            } else{
                int[] sortedArray = new int[totalSize];
                int counterEven = 0;
                int counterOdd = totalSize - 1;
                for (int value : nums) {
                    boolean isEven = isEven(value);
                    if (isEven) {
                        sortedArray[counterEven] = value;
                        counterEven++;
                    } else {
                        sortedArray[counterOdd] = value;
                        counterOdd--;
                    }
                }
                return sortedArray;
            }
        }
        return new int[0];
    }
    private boolean isEven(int num){
        return num%2 == 0;
    }

    private int[] merge(int[] a, int[] b) {
        int size = a.length + b.length;
        int[] mergedArr = new int[size];
        System.arraycopy(a, 0, mergedArr, 0, a.length);
        System.arraycopy(b, 0, mergedArr, a.length, b.length);
        return mergedArr;
    }
}
