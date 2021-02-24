package leetcode;

import java.util.HashMap;

public class LongestSubstringNoCharRepetition {

    /*Runtime: 9 ms, faster than 52.39% of Java online submissions for
    Longest Substring Without Repeating Characters.
    Memory Usage: 36.9 MB, less than 99.76% of Java online submissions for
    Longest Substring Without Repeating Characters.
    */

    public static void main(String[] args) {
        LongestSubstringNoCharRepetition lsncr  = new LongestSubstringNoCharRepetition();
        System.out.println(lsncr.lengthOfLongestSubstring("bbbbb"));
    }

    public int lengthOfLongestSubstring(String s) {

        /**
         * Using sliding Window
         * A sliding window is a length of character without repetition of characters.
         */
        HashMap<Character, Integer> map = new HashMap<>();
        int longestCount = 0;
        int currentCount = 0;
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > index) {
                if (longestCount < currentCount) {
                    longestCount = currentCount;
                }
                // if a duplicate character is found, subtract the position you are currently from the position of the
                // duplicate's previous character to get current count and update the position of that character, also do
                // not take note of all characters occurring before that character

                currentCount = i - map.get(s.charAt(i));
                index = map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            } else {
                currentCount++;
                map.put(s.charAt(i), i);
            }
        }
        return Math.max(longestCount, currentCount);
    }
}
