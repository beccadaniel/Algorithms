package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class HappyNumber {
    /**
     * A happy number is a number defined by the following process:
     * Starting with any positive integer, replace the number by the sum of the squares of its digits,
     * and repeat the process until the number equals 1 (where it will stay),
     * or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy numbers.
     */
     // TODO: Check out Floyd's cycle detection

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(50));
    }

    private Pair<Integer, ArrayList> getSquareSum(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        int sumSquare = 0;
        while (n > 0) {
            int digit = n % 10;

            array.add(digit);
            sumSquare += (digit * digit);
            n /= 10;
        }
        Collections.sort(array);
        return new Pair<>(sumSquare, array);
    }

    public boolean isHappy(int n) {
        ArrayList<ArrayList<Integer>> listOfDigits = new ArrayList<>();
        Pair<Integer, ArrayList> squaresum = getSquareSum(n);
        int currentSum = squaresum.fst;
        if (currentSum == 1) {
            return true;
        }
        ArrayList<Integer> currentDigitList = squaresum.snd;
        while (!checkIfDigitsExistInList(listOfDigits, currentDigitList)) {
            listOfDigits.add(currentDigitList);
            Pair<Integer, ArrayList> sum  = getSquareSum(currentSum);
            currentSum = sum.fst;
            currentDigitList = sum.snd;
            if (currentSum == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfDigitsExistInList(ArrayList<ArrayList<Integer>> digitList, ArrayList<Integer> digit) {

        for (ArrayList<Integer> list: digitList) {
            if (list.equals(digit)) {
                return true;
            }
        }
        return false;
    }

    static class Pair<T, K> {
        T fst;
        K snd;
        Pair(T first, K second) {
            this.fst = first;
            this.snd = second;
        }
    }
}
