package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoStrings {

    /*
    https://www.hackerrank.com/challenges/two-strings/problem
     */
    // accepted -> key lookup in map is O(1)
    static String twoStrings(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 1));
        }

        for (char s: s2.toCharArray()) {
            if (map.containsKey(s)) {
                return "YES";
            }
        }
        return "NO";
    }

    // Timeout, limit exceeded -> arraylist search is O(n)
    static String twoString(String s1, String s2) {

        ArrayList<Character> list = new ArrayList<>();
        for (char c: s1.toCharArray()) {
            list.add(c);
        }

        for (char s: s2.toCharArray()) {
            if (list.contains(s)) {
                return "YES";
            }
        }
        return "NO";
    }
}
