package hackerrank;

public class FormingAMagicSquare {

    public static void main(String[] args) {
        int[][] s = {{4, 8, 2}, {4, 5, 7}, {6, 1, 6}};
        System.out.println(formingMagicSquare(s));
    }

    public static int formingMagicSquare(int[][] s) {

        int[][][] possibleSquares = {{{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}
        };

        int[] cost = new int[8];
        int minimalCost = Integer.MAX_VALUE;

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost[k] += Math.abs(possibleSquares[k][i][j] - s[i][j]);
                }
            }
            minimalCost = Math.min(minimalCost, cost[k]);
        }
        return minimalCost;
    }
}
