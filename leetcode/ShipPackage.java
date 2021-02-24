package leetcode;

public class ShipPackage {

    /*Runtime: 5 ms, faster than 99.88% of Java online submissions for Capacity To Ship Packages Within D Days.
    Memory Usage: 42.8 MB, less than 73.08% of Java online submissions for Capacity To Ship Packages Within D Days.*/

    public int shipWithinDays(int[] weights, int D) {
        int lowerLimit = 0;
        int upperLimit = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > lowerLimit) {
                lowerLimit = weights[i];
            }
            upperLimit += weights[i];
        }
        if (D == 1) {
            return upperLimit;
        }
        if (D >= weights.length) {
            return lowerLimit;
        }

        // using binary search

        while (lowerLimit < upperLimit) {
            int midPoint = lowerLimit + ((upperLimit - lowerLimit)/2);
            int numberOfDaysUsed = daysAvailable(weights, midPoint);

            if (numberOfDaysUsed > D) {
                lowerLimit = midPoint + 1;
            }else {
                upperLimit = midPoint;
            }
        }
        return lowerLimit;
    }

    private int daysAvailable(int[] weights, int point) {
        int sum = 0;
        int noOfDays = 1;
        for (int j = 0; j < weights.length; j++) {
            if(sum + weights[j] > point) {
                noOfDays++;
                sum = weights[j];
            }
            else {
                sum += weights[j];
            }
        }
        return noOfDays;
    }
}
