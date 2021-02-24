package hackerrank;

import java.util.*;

public class SherlockAndTheValidString {

    /*
    https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
     */

    static String isValid(String s) {

        Map<Character, Integer> charMap = new HashMap<>();
        Map<Integer, Integer> intMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (int a: charMap.values()) {
            intMap.put(a, intMap.getOrDefault(a, 0)+1);
        }

        if (intMap.size() <= 1) {
            return "YES";
        } else if (intMap.size() > 2) {
            return "NO";
        } else {
            Iterator<Integer> intKeys = intMap.keySet().iterator();
            int key1 = intKeys.next();
            int key2 = intKeys.next();

            int val1 = intMap.get(key1);
            int val2 = intMap.get(key2);

            if (val1 == 1) {
                if (key1-1 == 0 || Math.abs(key1 - 1) == key2 ) {
                    return "YES";
                }
            } else if (val2 == 1) {
                if (key2 -1 == 0 || Math.abs(key2 - 1) == key1) {
                    return "YES";
                }
            }
            return "NO";
        }
    }
}
