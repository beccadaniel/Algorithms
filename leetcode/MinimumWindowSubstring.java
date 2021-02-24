package leetcode;

import java.util.*;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "aa";
        String t = "aa";
        System.out.println(minWindow(s, t));
    }

    private static boolean isDesirable(HashMap<Character, Integer> tCountMap, HashMap<Character, Integer> sMap) {
        for ( Character key: tCountMap.keySet()) {
            if (sMap.get(key) < tCountMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s, String t) {

        int left = 0;
        int right = 0;

        DesirableWindow window = new DesirableWindow(0,0);

        HashMap<Character, Integer> tcountMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        // put characters in t and it's count into a map
        for (int i = 0; i < t.length(); i++) {
            if (tcountMap.get(t.charAt(i)) == 0) {
                tcountMap.put(t.charAt(i), 1);
            } else {
                tcountMap.put(t.charAt(i), tcountMap.get(t.charAt(i)) + 1);
            }
        }

        // put character in s and its count into a map and check if it's desirable
        for (int j = 0; j < s.length(); j++) {
            if (tcountMap.containsKey(s.charAt(j))) {
                if (sMap.get(s.charAt(j)) == 0) {
                    sMap.put(s.charAt(j), 1);
                } else {
                    sMap.put(s.charAt(j), sMap.get(s.charAt(j)) + 1);
                }
                if (isDesirable(tcountMap, sMap)) {
                    //window = new DesirableWindow()
                }
            }
        }

        /*TreeMap<Integer, Character> map = new TreeMap<>();
        char[] sArray = s.toCharArray();

        if (t.length() > s.length()) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            if (t.contains(String.valueOf(sArray[i]))) {
                map.put(i, sArray[i]);
            }
        }

        ArrayList<Character> seenCharacters = new ArrayList<>(t.length());

        int leftWing = 0;
        int rightWing = 0;
        int minWindow = Integer.MAX_VALUE;
        int newMinWindow = 0;
        int finalLeftWing = -1;
        int finalRightWing = -1;
        Set<Integer> keyset = new HashSet<>();
        keyset.addAll(map.keySet());

        for (int key: map.keySet()) {
            ArrayList<Character> tCharacters = new ArrayList<>(t.length());
            for (int v = 0; v < t.length(); v++) {
                tCharacters.add(t.charAt(v));
            }
            for(int keys : keyset) {
                //if (!seenCharacters.contains(map.get(keys))) {
                if (tCharacters.contains(map.get(keys))) {
                    seenCharacters.add(map.get(keys));
                    tCharacters.remove(map.get(keys));
                    if (seenCharacters.size() == 1) {
                        leftWing = keys;
                        System.out.println(leftWing + "l");
                    }
                    if (seenCharacters.size() == t.length()) {
                        rightWing = keys;
                        newMinWindow = rightWing - leftWing + 1;
                        System.out.println(rightWing + "r");

                        continue;
                    }
                }
            }
            if (minWindow > newMinWindow) {
                minWindow = newMinWindow;
                finalLeftWing = leftWing;
                finalRightWing = rightWing;
            }
            System.out.println(minWindow + "m");

            keyset.remove(key);
            seenCharacters.clear();
        }
        String ans = "";
        if (finalLeftWing > -1 && finalRightWing > -1) {
            for (int r = finalLeftWing; r < finalRightWing + 1; r++) {
                ans = ans + sArray[r];
            }
        }
        return ans;*/
        return "";
    }

    static class DesirableWindow {
        int left;
        int right;
        DesirableWindow(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
