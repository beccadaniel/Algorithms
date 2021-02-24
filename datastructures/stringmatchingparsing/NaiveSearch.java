package datastructures.stringmatchingparsing;

public class NaiveSearch {

    public static void search(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();

        for (int j = 0; j <= (m-n); j++) {
            // check for pattern match at this current index
            int k;
            for (k = 0; k < n; k++) {
                if (text.charAt(j+k) != pattern.charAt(k)) {
                    break;
                }
            }
            if (k == n) {
                System.out.println("Pattern found at index " + j);
            }
        }
    }
}
