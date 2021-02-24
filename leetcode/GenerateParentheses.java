package leetcode;

import java.util.*;

public class GenerateParentheses {
    Set<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        List<String> ans = solution.generateParens(5);
        System.out.println(ans.size());
        for (String value: ans) {
            System.out.println(value);
        }
    }

    public List<String> generateParentheses(int n) {
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans += "()";
        }
        permute(ans, 0, ans.length() - 1);
        List<String> validCombination = new ArrayList<>();

        for (String permutation : hashSet) {
            if (isValidCombination(permutation)) {
                validCombination.add(permutation);
            }
        }
        return validCombination;
    }

    private void permute(String word, int l, int r) {
        if (l == r) {
            hashSet.add(word);
        } else {
            for (int i = l; i <= r; i++) {
                word = swap(word, l, i);
                permute(word, l+1, r);
                word = swap(word, l, i);
            }
        }
    }

    private String swap(String word, int i, int j) {
        char[] wordArray = word.toCharArray();
        char temp = wordArray[i];
        wordArray[i] = wordArray[j];
        wordArray[j] = temp;
        return String.valueOf(wordArray);
    }

    private boolean isValidCombination(String combination) {
        Stack parenthesesStack = new Stack();
        for (int i = 0; i < combination.length(); i++) {
            if (combination.charAt(i) == '(') {
                parenthesesStack.push(combination.charAt(i));
            } else {
                if (parenthesesStack.isEmpty()) {
                    return false;
                }
                parenthesesStack.pop();
            }
        }
        return parenthesesStack.isEmpty();
    }

    /**
     * Recursive Solution - Does not exceed time limit
     */
    public Set<String> generateParenthesis(int n) {
        Set<String> hashSet = new HashSet<String>();
        if (n == 0) {
            hashSet.add("");
        } else {
            Set<String> prev = generateParenthesis(n-1);
            for (String combination: prev) {
                for (int j = 0; j < combination.length(); j++) {
                    if (combination.charAt(j) == '(') {
                        String newCombo = insertParenthesesInside(combination, j);
                        hashSet.add(newCombo);
                    }
                }
                hashSet.add("()" + combination);
                hashSet.add(combination + "()");
            }
        }
        return hashSet;
    }

    public String insertParenthesesInside(String combination, int index) {
        String left = combination.substring(0, index + 1);
        String right = combination.substring(index + 1, combination.length());
        return left + "()" + right;
    }

    /**
     * Recursive solution - No duplicate elements found
     */

    public ArrayList<String> generateParens(int n) {
        char[] str = new char[n*2];
        ArrayList<String> list = new ArrayList<>();
        buildParenthesis(list, n, n, str, 0);
        return list;
    }

    public void buildParenthesis(ArrayList<String> list,
                                              int remainingLeft,
                                              int remainingRight,
                                              char[] str,
                                              int index) {
        if (remainingLeft < 0 || remainingRight < remainingLeft) {
            return;
        }
        if (remainingLeft == 0 && remainingRight == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            buildParenthesis(list, remainingLeft - 1, remainingRight, str, index + 1);

            str[index] = ')';
            buildParenthesis(list, remainingLeft, remainingRight - 1, str, index + 1);
        }
    }
}
