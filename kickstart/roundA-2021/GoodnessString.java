import java.util.Scanner;

public class GoodnessString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numTestCases; i++) {
            int stringLength = scanner.nextInt();
            int estGoodnessScore = scanner.nextInt();
            String letters = scanner.next();

            System.out.println("Case #" + (i+1) + ": " + performCalculations(letters, getGoodnessScore(letters, stringLength), estGoodnessScore));
        }
    }

    private static int getGoodnessScore(String word, int length) {
        if (length == 0) {
            return 0;
        }
        int j;
        int mid = length/2;
        int goodnessScore = 0;
        for (int i = 0; i < mid; i++) {
            j = length - i - 1;
            if (word.charAt(i) != word.charAt(j)) {
                goodnessScore++;
            }
        }
        return goodnessScore;
    }

    private static int performCalculations(String word, int goodnessScore, int estGoodnessScore) {
        if (goodnessScore == estGoodnessScore) {
            return 0;
        } else if (goodnessScore < estGoodnessScore) {
            int remainingScore = estGoodnessScore - goodnessScore;
            return remainingScore;
        } else {
            int overTheTop = goodnessScore - estGoodnessScore;
            return overTheTop;
        }
    }
}
