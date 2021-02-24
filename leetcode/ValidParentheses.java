package leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()"));
    }

    private boolean isValid(String s)  {
        if (s.isEmpty()) {
            return true;
        }

        Stack parenthesesStack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                parenthesesStack.push(s.charAt(i));
            }
            else if (parenthesesStack.isEmpty() || (getOpenParentheses(s.charAt(i)) != parenthesesStack.pop())) {
                return false;
            }
        }
        return parenthesesStack.isEmpty();
    }

    private Character getOpenParentheses(char c) {
        if (c == ')')
            return '(';
        else if (c == ']')
            return '[';
        else
            return '{';
    }
}/*{
        if (s.isEmpty()) {
            return true;
        }
        ArrayList<Character> openParentheses = new ArrayList<>();
        HashMap<Character, Character> keyPair = new HashMap<>();

        openParentheses.add('(');
        openParentheses.add('[');
        openParentheses.add('{');

        keyPair.put(')', '(');
        keyPair.put(']', '[');
        keyPair.put('}', '{');

        Stack parenthesesStack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (openParentheses.contains(s.charAt(i))) {
                parenthesesStack.push(s.charAt(i));
            } else {
                if (parenthesesStack.isEmpty()) {
                    return false;
                } else {
                    if (keyPair.get(s.charAt(i)) != parenthesesStack.pop()) {
                        return false;
                    }
                }
            }
        }
        return parenthesesStack.isEmpty();
    }
}*/
