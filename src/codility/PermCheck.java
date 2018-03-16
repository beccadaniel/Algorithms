package codility;

public class PermCheck {

    public static void main(String[] args) {
        int[] arr = {1,3,4};
        System.out.println(isPerm(arr));
    }

    private static int isPerm(int[] arr) {
        int[] counterArr = new int[arr.length];

        for (int i=0; i<arr.length; i++) {

            if ((1 > arr[i])||(arr.length < arr[i] ))
                return 0;
            else if (counterArr[arr[i]-1] == 1)
                return 0;       // seen more than once
            else {
                counterArr[arr[i]-1] = 1;   // seen once
            }
        }
        return 1;
    }
}
