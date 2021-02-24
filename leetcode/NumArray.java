package leetcode;

public class NumArray {
    /**
     * https://leetcode.com/problems/range-sum-query-immutable/
     */

    int[] dpList;

    public NumArray(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        dpList = nums;
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dpList[j] : dpList[j] - dpList[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */