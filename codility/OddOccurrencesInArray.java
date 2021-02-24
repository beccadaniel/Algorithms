package codility;

public class OddOccurrencesInArray {
    /*
    https://app.codility.com/demo/results/trainingJ8SG3T-PZB/
     */

    public int solution(int[] A) {
        // write your code in Java SE 8
        int xorVal = A[0];
        for (int i = 1; i < A.length; i++) {
            xorVal = xorVal ^ A[i];
        }
        return xorVal;
    }
}
