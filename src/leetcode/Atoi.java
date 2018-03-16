package leetcode;

/* String to Integer*/
public class Atoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("    -160987777654444"));
    }

    public static long myAtoi(String str) {
        int sign = +1;
        int i;
        Long result;
        String ans = "";

        str = str.trim();
        char firstChar = str.charAt(0);
        if (!((firstChar == '+') || (firstChar == '-'))) {
            return 0;
        }

        else {
            if(firstChar == '+') {
                sign = +1;
                i = str.indexOf(firstChar);
                i++;
            } else {
                sign = -1;
                i = str.indexOf(firstChar);
                i++;
            }

            for (int j=i; j < str.length(); j++) {
                if(Character.isDigit(str.charAt(j))) {
                    ans = ans + str.charAt(j);
                } else {
                    break;
                }
            }
            result = Long.valueOf(ans)*sign;
            if(result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return result;
        }
    }
}
