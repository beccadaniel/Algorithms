package leetcode;

public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] mp = new int[]{1,2,3,10,2147483647,9};
        System.out.println(fmp.firstMissingPositive(mp));
    }

    public int firstMissingPositive(int[] nums) {
        int ans = 0;
        if (nums.length == 0) {
            return 1;
        }
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        if (nums.length > 1) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            if (max < 0) {
                return 1;
            } else if (max >=Integer.MAX_VALUE) {
                max =Integer.MAX_VALUE -1;
            }
            int[] countArray = new int[max+1];
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] > 0) {
                    countArray[nums[j]] += 1;
                }
            }

            for (int k = 1; k < countArray.length; k++) {
                if (countArray[k] == 0) {
                    return k;
                }
            }
            ans = countArray.length;
        }
        return ans;
    }
}
