package kickstart;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
//    private static int numberOfTestCases;
//    private static int upperBound;
//    private static int lowerBound;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int event = 0; event < numberOfTestCases; event++) {
            int lowerBound = scanner.nextInt();
            int upperBound = scanner.nextInt();
            int maxGuesses = scanner.nextInt();
            trialLoop:
            for (int trial = 0; trial < maxGuesses; trial++) {
                int ans = guess(upperBound, lowerBound);
                System.out.println("ANS IS " + ans + " " + trial);
                String judgement = scanner.next();
                switch (judgement) {
                    case "CORRECT":
                    case "WRONG_ANSWER":
                        break trialLoop;
                    case "TOO_BIG":
                        upperBound = ans-1;
                        break;
                    case "TOO_SMALL":
                        lowerBound = ans;
                        break;
                }
            }
        }
    }

    private static int guess(int upperBound, int lowerBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound) + 1 + lowerBound;
    }
}
