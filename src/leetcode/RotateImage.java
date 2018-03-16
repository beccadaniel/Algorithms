

package leetcode;

public class RotateImage {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] array = rotate(arr);
        for (int i=0; i <3; i++) {
            for(int j=0; j < 3; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static int[][] rotate(int[][] matrix) {

        int length = matrix.length;

        for (int i=0; i<(length/2); i++) {       // goes 2 square cycles
            for (int j=i; j<(length-i-1); j++) {
                int temp = matrix[length-j-1][i];
                matrix[length-j-1][i] = matrix[length-i-1][length-1-j];
                matrix[length-1-i][length-1-j] = matrix[j][length-i-1];
                matrix[j][length-i-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }
}
