package leetcode;

public class SingleNumber {
    /** Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     *
     * Solution
     * Take xor on every number in the array. The answer is the element that appears once.
     * This is because y xor y = 0, and 0 xor z = z
     */

    public int singleNumber(int[] nums) {

        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ans = nums[i] ^ ans;
        }

        return ans;
    }
}
