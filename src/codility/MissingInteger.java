package codility;

public class MissingInteger {
    // did this in python

    public static void main(String[] args) {
        int[] arr = {-1,-3};
        System.out.println(findMissingInteger(arr));
    }

    private static int findMissingInteger(int[] arr) {
        int[] counter = new int[arr.length];
        int max = 0;
        int ans = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i]<0) {
                continue;
            } else {
                counter[arr[i]-1] =1;
            }
        }
        for (int j=0; j<counter.length; j++) {
            if (counter[j] == 0) {
                ans = j+1;
                break;
            }
        }
        if (ans == 0)
            return max + 1;
        return ans;
    }
}
