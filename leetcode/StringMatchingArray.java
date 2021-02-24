package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingArray {

    public static void main(String[] args) {
        String words[] = {"jak","yjakdn","tj","yyjakdn"};
        List<String> ans = getMatch(words);
        ans.forEach(System.out::println);
    }

    public static List<String> getMatch(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String text = words[i].length() > words[j].length() ? words[i] : words[j];
                String pattern = words[i].length() > words[j].length() ? words[j] : words[i];
                if (!ans.contains(pattern) && naiveSearch(text, pattern)) {
                    ans.add(pattern);
                }

            }
        }
        return ans;
    }

    public static boolean naiveSearch(String text, String pattern) {
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
                //System.out.println("Pattern found at index " + j);
                return true;
            }
        }
        return false;
    }
}
