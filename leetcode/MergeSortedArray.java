package leetcode;

public class MergeSortedArray {

    public static void main(String[] args) {
        int num1[] = {0};
        int num2[] = {1};
        merge(num1, 0, num2, 1);
        for(int i = 0; i < num1.length; i++) {
            System.out.print(num1[i] + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int leftPointer = m - 1;
        int rightPointer = n-1;
        int total = nums1.length;

        while (rightPointer >= 0) {

            if (leftPointer < 0 || nums2[rightPointer] >= nums1[leftPointer]) {
                nums1[total - 1] = nums2[rightPointer];
                rightPointer--;
            } else {
                nums1[total - 1] = nums1[leftPointer];
                leftPointer--;
            }
            total--;
        }
    }

}
