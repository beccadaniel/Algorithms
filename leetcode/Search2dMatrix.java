package leetcode;

public class Search2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        System.out.println(searchMatrix(matrix, 1));
    }

    /*Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
    Memory Usage: 41.8 MB, less than 6.06% of Java online submissions for Search a 2D Matrix.*/

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;

        if (rowSize == 0) {
            return false;
        }
        int colSize = matrix[0].length;
        if (colSize == 0) {
            return false;
        }
        for (int row = 0; row < rowSize; row++) {
            if (matrix[row][colSize - 1] == target) {
                return true;
            }
            if (matrix[row][colSize - 1] > target) {
                //search current row;
                for (int col = 0; col < colSize; col++) {
                    if (matrix[row][col] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}


/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;

        if (rowSize == 0) {
            return false;
        }
        int colSize = matrix[0].length;
        if (colSize == 0) {
            return false;
        }
        for (int row = 0; row < rowSize; row++) {
            if (matrix[row][colSize - 1] == target) {
                return true;
            }
            if (matrix[row][0] == target) {
                return true;
            }

            // binary search
            int leftLimit = 0;
            int rightLimit = colSize - 1;
            while (leftLimit < rightLimit) {
                int midPoint = leftLimit + ((rightLimit - leftLimit)/2);
                if (matrix[row][midPoint] == target) {
                    return true;
                }
                if (matrix[row][midPoint] < target) {
                    leftLimit = midPoint + 1;
                } else {
                    rightLimit = midPoint;
                }
            }
        }
        return false;
    }
}*/
