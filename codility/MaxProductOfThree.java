package codility;

import java.util.Arrays;

public class MaxProductOfThree {

    public static void main(String[] args) {
        int[] arr = {-3,1,-2,2,5,6,4};
        System.out.println(maximumProduct(arr));
    }

    private static int maximumProduct(int[] arr) {
        Arrays.sort(arr);
        int maxproduct = 0;
        int n = arr.length;
        if((arr[0]*arr[1]*arr[n-1]) > (arr[n-1]*arr[n-2]*arr[n-3])){
            maxproduct = (arr[0]*arr[1]*arr[n-1]);
        }
        else{
            maxproduct = (arr[n-1]*arr[n-2]*arr[n-3]);
        }
        return maxproduct;
    }
}
