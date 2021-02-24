package leetcode;

import java.util.HashMap;

public class LongestPalindrome {
    /**
     * To make a palindrome, you should have all even occurring letters or one odd and all others even
     * -- Steps --
     * count the occurrence of each letter in the given string and store in a map
     * count all even occurring letters
     * choose the odd occurring letter that has the highest count
     * subtract 1 from the count of every other odd count
     * This gives the longest palindrome
     *
     */
    public int longestPalindrome(String s) {
        int length = 0;
        int oddLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c: map.keySet()) {
            int size = map.get(c);
            if (size % 2 == 0) {
                length += size;
            } else {
                if (size > oddLength) {
                    int ans = (oddLength - 1) < 0 ? 0 : (oddLength - 1);
                    length = length + ans;
                    oddLength = size;
                } else {
                    length += size-1;
                }
            }
        }
        return length + oddLength;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        //String s = "Hannah";
        //System.out.println(lp.longestPalindrome(s));
        //String ans = ", , , ,        a, eaefa";
        String ans = "";
        /*System.out.println(ans.length);
        int count = 0;
        for ( String a: ans) {
            if (!a.equals("")) {
                count++;
            }
        }*/
        System.out.println(("x " + ans).split(" +").length);
        //System.out.println(count);
    }
}
