package datastructures;

import java.util.ArrayList;

public class SeiveOfErasthoses {

    public static void main(String[] args) {
        ArrayList primes = new ArrayList();

        primes = primesIn(50);
        System.out.println(primes);
    }

    public static ArrayList<Integer> primesIn(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] flags = new boolean[n+1];
        flags = setFlags(flags);
        int currentPrime = 2;

        while(currentPrime <= Math.sqrt(n)) {
            flags = removeNonPrimes(flags, currentPrime);

            // get next prime
            currentPrime = getNextPrime(flags, currentPrime);
        }

        for (int j = 0; j < flags.length; j++) {
            if (flags[j]) {
                result.add(j);
            }
        }
        return result;
    }

    public static int getNextPrime(boolean[] flag, int prime) {
        int next = prime + 1;
        while (next < flag.length && !flag[next]) {
            next = next + 1;
        }
        return next;
    }

    public static boolean[] removeNonPrimes(boolean[] flag, int prime) {
        for (int i = prime * prime; i < flag.length; i+=prime) {
            flag[i] = false;
        }
        return flag;
    }

    public static boolean[] setFlags(boolean[] flag) {
        for(int i = 2; i < flag.length; i++) {
            flag[i] = true;
        }
        return flag;
    }

}
