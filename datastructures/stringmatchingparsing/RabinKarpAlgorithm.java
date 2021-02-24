package datastructures.stringmatchingparsing;

public class RabinKarpAlgorithm {

    /**
     * q - any prime number - constant
     * n - length of pattern - constant
     * m - length of text
     * p - pattern's hash value
     * t - text's hash value
     * h - d^(n-1)
     * d - number of characters in the alphabet - constant
     *
     */

    public final static int d = 256;

    public static void search(String pattern, String text, int q) {
        int n = pattern.length();
        int m = text.length();

        // default values
        int p = 0;
        int t = 0;
        int h = 1;

        int i, j; // counters

        // setting values - this is essentially the formula for h
        for (i = 0; i < n-1; i++) {
            h = (h * d) % q;
        }

        // calculate the hash value of pattern and first substring in text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // shifting the pattern over the text one by one
        for (i = 0;  i <= m-n; i++) {

            // compare hash values
            if (p == t) {
                // compare characters one at a time
                for (j = 0; j < m; j++) {
                    if (text.charAt(i+j) != pattern.charAt(j))
                        break;
                }

                if (j == m) {
                    System.out.println("Pattern found at index " + j);
                }
            }

            // calculate hash for next shift: Remove leading character and add trailing character
            if (i < m-n) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i+m))%q;

                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }
}
