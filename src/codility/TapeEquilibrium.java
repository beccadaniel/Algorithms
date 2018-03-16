package codility;

public class TapeEquilibrium {

    public static void main(String[] args) {
        int[] arr = {-10, -20, -30, -40, 100};
        System.out.println(getMinDiff(arr));
    }
    private static int getMinDiff(int[] arr) {
        int leftSide = 0, min = Integer.MAX_VALUE, totalSum = 0;
        for (int element:arr) {
            totalSum +=element;
        }
        for( int j= 0; j<arr.length-1; j++) {
            leftSide+=arr[j];
            int rightSide = Math.abs((2*leftSide) - (totalSum));
            System.out.println(rightSide);
            if (rightSide < min) min = rightSide;
        }
        return min;
    }

}