package datastructures;

public class BitManipulation {

    public static void main(String[] args) {
        //insertion
    }

    /**
     * Inserting a binary number into another binary number
     * @param M - The binary number to insert into another one
     * @param N - The binary number where another is inserted
     * @param i - The position where the insertion ends
     * @param j - The position where the insertion starts
     */
    void insertion(int M, int N, int i, int j) {
        // clear the bits in N from position i to j -
        // This needs a binary number where every bit is 1 except the bits in position i to j
        // Those will be 0s
        int maskLeft = (~0) << (j + 1);
        int maskRight = (1 << i) - 1;
        int mask = maskLeft | maskRight;

        System.out.println(maskLeft);
        System.out.println(maskRight);
        System.out.println(mask);

        int updatedN = N & mask;

        // update position i to j in N with M
        N = updatedN | N;



    }
}
