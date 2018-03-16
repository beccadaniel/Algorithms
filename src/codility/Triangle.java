package codility;

import java.util.Arrays;

public class Triangle {
    /*
    * 1. sort the given array
    * 2. loop through the array, add two consecutive elements
    * 3. check if the addition is greater than the next element.
    */

    public static void main(String[] args) {
        int[] arr = {10,50,5,1};
        System.out.println(isTripletTriangle(arr));
    }

    private static int isTripletTriangle(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < (arr.length-2); i++) {
            if((arr[i] == Integer.MAX_VALUE)||(arr[i] + arr[i+1]) > arr[i+2])
                return 1;
        }
        return 0;
    }
}
