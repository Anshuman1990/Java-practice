package  com.practice.java8_17.leetcode;

public class LC26 {
    public static void main(String[] args) {
        LC26 lc26 = new LC26();
        int[] nums = {1,2,3,4,4};
        System.out.println(lc26.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        int i=0;
        int j=0;
        while(j < nums.length){
            while(j + 1 < nums.length && nums[j] == nums[j+1]){
                j++;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        return i;
    }
}
