package codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxCounter {

    public static void main(String[] args) {
        int[] a = {3,4,4,6,1,4,4};
        getMaxCounter(a, 5);
    }

    static int[] getMaxCounter(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] array = new int[n];
        int[] array2 = new int[n];
        int[] maxes = new int[n];
        int t = -1;
        int check = 0;
        int temp = 0;
        int max = 0;
        int count = 0;
        // loop through all elements and get how many times n+1 occurred;
        /*for (int i= 0; i<arr.length; i++) {
            if (arr[i] == n+1) {
                array2[i] = 1;
            }
        }*/

        // create your map
        for (int j=1; j<=n; j++) {
            map.put(j, 0);
        }

        for (int k=0; k<arr.length;k++) {
            if (arr[k] == n+1) {
                map = maxCounter(map, max);
                continue;
            }

            map.put(arr[k], map.get(arr[k])+1+max);
            if(max < map.get(arr[k])+1)
                max = map.get(arr[k])+1;
        }

        return array;
    }

    public static Map maxCounter(Map<Integer, Integer> map, int max){
        for(int i=0; i<map.size(); i++) {
            map.put((i+1), max);
        }
        return map;
    }
}
