package round1a;

import java.util.Scanner;

public class PascalsWalk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = scanner.nextInt();
        for (int t = 0; t < numOfTestCases; t++) {
            int N = scanner.nextInt();
        }
    }

    public static int getValueInTriangle(int n, int k) {
        int nfactorial = factorial(n);
        int kfactorial = factorial(k);
        int nminuskfactorial = factorial(n-k);
        return (nfactorial / (kfactorial * nminuskfactorial));
    }

    public static int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    public static void satisfyPascalsWalk(int i) {
        int ri1ki1 = getValueInTriangle(i, i);
        int pa = getValueInTriangle(i-2, i-2);
        int pb = getValueInTriangle(i-2, i-1);
        int pc = getValueInTriangle(i-1, i-2);
        int pd = getValueInTriangle(i-1, i);
        int pe = getValueInTriangle(i, i-1);
        int pf = getValueInTriangle(i, i);
    }
}
