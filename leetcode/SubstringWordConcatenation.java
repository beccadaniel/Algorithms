package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWordConcatenation {

    public static void main(String[] args) {
        SubstringWordConcatenation swc = new SubstringWordConcatenation();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> ans = swc.findSubstring(s, words);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        System.out.println(ans.size());
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        // words in the array are of the same length
        int wordLength = words[0].length();

        /**
         * Using Sliding Window Approach
         * A sliding window or substring (containing all the words in the array) in this case would be
         * of length: wordLength * length of array
         */

        int windowLength = wordLength * words.length;
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (int a = 0; a < words.length; a++) {
            if (wordMap.containsKey(words[a])) {
                wordMap.put(words[a], wordMap.get(words[a])+1);
            } else {
                wordMap.put(words[a], 1);
            }
        }

        for (int k = 0; k < s.length()-windowLength+1; k++) {

            for (int i = k; i < s.length()-windowLength+1; i+=windowLength) {
                HashMap<String, Integer> slidingWindowMap = new HashMap<>();
                // pick a window
                String subString = s.substring(i, i+windowLength);

                // break the window into words and keep count.
                for (int j = 0; j < windowLength; j+=wordLength) {
                    String sub = subString.substring(j, j+wordLength);

                    if (slidingWindowMap.containsKey(sub)) {
                        slidingWindowMap.put(sub, slidingWindowMap.get(sub)+1);
                    } else {
                        slidingWindowMap.put(sub, 1);
                    }
                }
                int count = 0;

                for ( String key: wordMap.keySet()) {
                    if (wordMap.get(key) == slidingWindowMap.get(key)) {
                        count++;
                    }
                }
                if (count == wordMap.size() && !result.contains(i)) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
