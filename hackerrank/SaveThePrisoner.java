package hackerrank;

public class SaveThePrisoner {

    public static void main(String[] args) {
        System.out.println(saveThePrisoner(3, 6, 3));
    }

    /**
     * m - number of sweets
     * n - number of prisoners
     * s - chair number to start sharing sweets from
     */

    public static int saveThePrisoner(int n, int m, int s) {
        int remains = m % n;
        int lastPrisoner = (s + remains - 1) % n;
        return lastPrisoner == 0 ? n : lastPrisoner;
    }

}
