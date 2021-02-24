package leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sumToN = (length * (length + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        return (sumToN - sum);
    }
}
