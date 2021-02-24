package datastructures.dynamicprogramming;

public class Fibonacci {

    // recursive method
    public static int getFibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        }

        return getFibonacci(i-1) + getFibonacci(i-2);
    }

    // dp method
    public static int getFibonacci(int i, int[] memo) {
        if (i == 0 || i == 1) {
            return i;
        }

        if (memo[i] == 0) {
            memo[i] = getFibonacci(i-1, memo) + getFibonacci(i-2, memo);
        }
        return memo[i];
    }

    // bottom-up dp
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for (int j = 2; j < n+1; j++) {
            memo[j] = memo[j-1] + memo[j-2];
        }
        return memo[n];
    }

    // bottom-up dp, less space usage
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;

        for (int j = 0; j < n; j++) {
            int currentFib = a + b;
            a = b;
            b = currentFib;
        }
        return a + b;
    }
}
