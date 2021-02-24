package leetcode;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {-2, 1};
        System.out.println(maxSubArray(nums));
    }

    /**
     * Given an integer array nums, find the contiguous subarray
     * (containing at least one number) which has the largest sum and return its sum.
     * @param nums
     * @return
     */

    public static int maxSubArray(int[] nums) {
        //using kadane's Algorithm

        int max_so_far = nums[0];
        int current_max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current_max += nums[i];

            if (current_max < nums[i]) {
                current_max = nums[i];
            }

            if (max_so_far < current_max) {
                max_so_far = current_max;
            }
        }
        return max_so_far;
    }
}
