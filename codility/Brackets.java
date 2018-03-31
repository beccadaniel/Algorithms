package codility;

import java.util.HashMap;
import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        String test = "{{{{}}}}";
        System.out.println(isWellNested(test));
    }

    private static boolean isWellNested(String S) {
        char[] arr = S.toCharArray();

        if (arr.length == 0)
            return true;

        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> bracketMap = new HashMap<>();

        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        for (char bracket : arr) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if (!stack.empty()) {
                    char current = stack.pop();
                    if (!(bracketMap.get(bracket) == current)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
