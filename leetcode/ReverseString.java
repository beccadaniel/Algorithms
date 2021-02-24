package leetcode;

public class ReverseString {

    /**
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * You may assume all the characters consist of printable ascii characters.
     */

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] g = {'h', 'e', 'l', 'l', 'o'};
        rs.reverseString(g);
        for (int i =0; i<g.length; i++) {
            System.out.print(g[i] + " ");
        }
    }

    public void reverseString(char[] s) {
        helper(0, s);
    }

    private void helper(int index, char[] s) {
        if (s == null || index >= s.length) {
            return;
        }
        helper(index + 1, s);
        int newIndex = Math.abs(index - (s.length-1));

        s[newIndex] = s[index];
    }
}
