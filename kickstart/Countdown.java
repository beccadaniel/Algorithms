package kickstart;

import java.util.Scanner;

public class Countdown {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCase = scanner.nextInt();

        for (int i = 0; i < numTestCase; i++) {
            int numElement = scanner.nextInt();
            int countDown = scanner.nextInt();

            int[] elements = new int[numElement];

            for (int j =0; j < numElement; j++) {
                elements[j] = scanner.nextInt();
            }

            int countDownAmount = 0;
            int nextExpectedNum = countDown;

            for (int k = 0; k < numElement; k++) {
                while((nextExpectedNum != 0) && (elements[k] == nextExpectedNum)) {
                    if (elements[k] == 1) {
                        countDownAmount += 1;
                    }
                    nextExpectedNum -= 1;
                    k++;
                }
                nextExpectedNum = countDown;
            }
            System.out.println("Case #" + (i + 1) + ": " + countDownAmount);
        }
    }

}
