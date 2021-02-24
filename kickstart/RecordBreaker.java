package kickstart;

import java.util.Scanner;

public class RecordBreaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCase = scanner.nextInt();

        for (int i = 0; i < numTestCase; i++) {
            int n = scanner.nextInt();
            int count = 0;
            int max = 0;
            int[] ar = new int[n];
            for (int j = 0; j < n; j++) {
                ar[j] = scanner.nextInt();
            }

            if (n == 1) {
                count++;
            } else {
                for (int k = 0; k < n; k++) {
                    if (ar[k] > max) {
                        if (k == n-1) {
                            count++;
                            max = Math.max(max, ar[k]);
                        } else {
                            if (ar[k] > ar[k+1]) {
                                count++;
                            }
                            max = Math.max(max, ar[k]);
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + count);
        }
    }
}
