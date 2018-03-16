package codility;

public class FrogRiverOne {

    public static void main(String[] args) {
        int[] arr = {1,3,1,4,2,3,5,4};
        System.out.println(earliestTime(arr, 5));
    }

    private static int earliestTime(int[] arr, int x) {
        int[] counter = new int[x];
        int countcheck = 0;
        int ans = 0;
        for (int i=0; i<arr.length; i++) {
            if(counter[arr[i]-1] == 0) {
                counter[arr[i]-1] = 1;
                countcheck++;
                ans = -1;
            }
            if(countcheck == x){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
