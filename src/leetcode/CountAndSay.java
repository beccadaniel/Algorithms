package leetcode;

public class CountAndSay {

    public static void main(String[] args) {
        //System.out.println(countSay(5));
        //System.out.println("shade".charAt(0));
    }

    /*private static String countSay(int n) {
        if (n == 1) {
            return n+"";
        }
        String s = "1";
        String ans = "";
        for (int i = 0; i < n-1; i++) {
            int count = 1;
            char currentElement = s.charAt(0);
            for(int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == currentElement) {
                    count++;
                }
                else {
                    ans +=count;
                    ans += currentElement;
                    currentElement = s.charAt(j);
                    count = 1;
                }
            }
            ans += count;
            ans += currentElement;
            s = ans;
        }
        return ans;
    }*/

    private static String getIndex(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
            else {
                sb.append(count);
                sb.append(c);
                c= s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
