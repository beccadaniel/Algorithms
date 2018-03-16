package codility;

import java.util.Arrays;

public class Distinct {
    public int numberOfDistinct(int[] arr) {
        Arrays.sort(arr);
        int distinctCounter = 1;

        if(arr.length == 0)
            return 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                distinctCounter += 1;
            }
        }
        return distinctCounter;
    }
}
