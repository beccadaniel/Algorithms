package datastructures;

import java.util.Arrays;

public class PermutationString {

//    public static void main(String[] args) {
//        System.out.println(isPermutation("vile", "live"));
//    }

    // check permutation by sorting and comparing.
    public static boolean isPermutation(String word, String permute) {
        if (permute.length() != word.length())
            return false;

        return sort(permute).equals(sort(word));
    }

    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // another method to check permutation is to check if the two strings have the same character counts.
    public static boolean isAPermutation(String word, String permute) {
        if (permute.length() != word.length())
            return false;

        // assume ASCII characters of 7 bit encoding
        int[] chars = new int[128];
        for (int i = 0; i < permute.length(); i++) {
            chars[permute.charAt(i)]++;
        }

        for (int j = 0; j < word.length(); j++) {
            chars[word.charAt(j)]--;
            if (chars[word.charAt(j)] < 0)
                return false;
        }
        return true;
    }
}
