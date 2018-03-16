package codility;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        int[] arr = {1, 2147483647, 0};
        System.out.println(getNoOfIntersections(arr));
        System.out.println(2147483647 == Integer.MAX_VALUE);
    }

    public static int getNoOfIntersections(int[] arr) {
        int n = arr.length;
        long[] addArray = new long[n];
        long[] subArray = new long[n];
        int count = 0;
        int noOfIteration = 0;
        int noOfIntersection = 0;

        for(int i = 0; i < n; i++) {
            int b = i + arr[i];
            if(b>Integer.MAX_VALUE)
                b = Integer.MAX_VALUE;
            addArray[i] = b;
            subArray[i] = i - arr[i];
        }
        Arrays.sort(addArray);
        Arrays.sort(subArray);

        for(int j = 0; j < n; j++) {
            if(addArray[0] >= subArray[j]) {
                count += 1;
            }
            else {
                break;
            }
        }

        for(int k = 0; k < n; k++) {
            for(int s = count; s < n; s++) {
                if(addArray[k] >= subArray[s]) {
                    count += 1;
                }
                else {
                    break;
                }
            }
            noOfIntersection += count - 1 - noOfIteration;
            noOfIteration += 1;
        }

        if(noOfIntersection > 10000000) {
            return -1;
        }
        return noOfIntersection;
    }
}
