package round1a;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int noOfTestCase = scanner.nextInt();
        for (int t = 0; t < noOfTestCase; t++) {
            int numberOfPatterns = scanner.nextInt();
            String[] patterns = new String[numberOfPatterns];
            for (int p = 0; p < numberOfPatterns; p++) {
                patterns[p] = scanner.next();
            }
        }*/

        Pattern p = Pattern.compile("HE(.*)");
        Matcher m = p.matcher("HELLOHELLO");
        boolean b = m.matches();

        System.out.println(b);

        System.out.println(getPattern("HELLO*"));
    }

    public static void getName(String[] patterns) {

        StringBuilder startPattern = new StringBuilder();
        StringBuilder endPattern = new StringBuilder();
        for (int i = 0; i < patterns.length; i++) {
        }

    }

    private static String getPattern(String pattern1) {
        StringBuilder patternbuilder = new StringBuilder();

        for (int i = 0; i < pattern1.length(); i++) {
            if (pattern1.charAt(i) == '*') {
                patternbuilder.append('(');
                patternbuilder.append(".*");
                patternbuilder.append(')');
            } else {
                patternbuilder.append(pattern1.charAt(i));
            }
        }
        return patternbuilder.toString();
    }
}
