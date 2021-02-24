package kickstart;

import java.util.Scanner;

public class NoNine {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            int firstNum = in.nextInt();
            int lastNum = in.nextInt();
            System.out.println("Case #" + (i+1) + ": " + countNoNiner(firstNum, lastNum));
        }
    }

    public static boolean isNoNiner(int num) {
        return (num>0) && (num%9 != 0) && !String.valueOf(num).contains("9");
    }

    public static int countNoNiner(int first, int last) {
        int count = 0;
        for (int i = first; i <= last; i++) {
            count = isNoNiner(i) ? ++count : count;
        }
        return count;
    }
}
