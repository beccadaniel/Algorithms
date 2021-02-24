package leetcode;

public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int middle = (totalLength/2) + 1;

        int[] newArray = new int[middle];
        int array1 = 0;
        int array2 = 0;

        for (int i = 0; i < middle; i++) {

            if (array1 >= nums1.length) {
                newArray[i] = nums2[array2];
                array2++;
            } else if (array2 >= nums2.length) {
                newArray[i] = nums1[array1];
                array1++;
            } else {
                if (nums1[array1] <= nums2[array2]) {
                    newArray[i] = nums1[array1];
                    array1++;
                } else if (nums1[array1] > nums2[array2]) {
                    newArray[i] = nums2[array2];
                    array2++;
                }
            }
        }
        if (totalLength % 2 == 0) {
            return (newArray[middle-2] + newArray[middle-1])/2.0;
        } else {
            return newArray[middle-1];
        }
    }

}
