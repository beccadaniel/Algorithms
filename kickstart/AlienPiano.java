package kickstart;

import java.util.Scanner;

public class AlienPiano {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numTestCase = scanner.nextInt();

        for (int i = 0; i < numTestCase; i++) {
            int k = scanner.nextInt();
            int[] ar = new int[k];
            for (int j = 0; j < k; j++) {
                ar[j] = scanner.nextInt();
            }

            char[] pitch = {'A', 'B', 'C', 'D'};
            char currentPitch;
            int index = 0;
            int prevIndex = 0;
            int count = 0;
            for (int r = 0; r < k-1; r++) {

                if (r == 0 && (ar[r] < ar[r+1])) {
                    currentPitch = pitch[r];
                    index = r;
                } else if (ar[r] < ar[r+1]) {
                    if (ar[r] > ar[r-1]) {
                        currentPitch = pitch[(index + 1) % 4];
                        index = (index + 1) % 4;
                        if (index < prevIndex) {
                            count++;
                        }
                        prevIndex = index;
                    } else if (ar[r] == ar[r-1]) {
                        currentPitch = pitch[index];
                    } else {
                        currentPitch = pitch[(index - 1) % 4];
                        index = (index - 1) % 4;
                        if (index > prevIndex) {
                            count++;
                        }
                        prevIndex = index;
                    }
                } else if (ar[r] > ar[r+1]) {
                    if (ar[r] > ar[r-1]) {
                        currentPitch = pitch[(index + 2) % 4];
                        index = (index + 2) % 4;
                        if (index < prevIndex) {
                            count++;
                        }
                        prevIndex = index;
                    } else if (ar[r] == ar[r-1]) {
                        currentPitch = pitch[index];
                    }  else {
                        currentPitch = pitch[(index - 1) % 4];
                        index = (index - 1) % 4;
                        if (index > prevIndex) {
                            count++;
                        }
                        prevIndex = index;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + count);
        }
    }
}
