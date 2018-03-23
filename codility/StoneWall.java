package codility;

import java.util.Stack;

public class StoneWall {

    public static void main(String[] args) {
        int[] arr = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println(stoneWallMin(arr));
    }

    public static int stoneWallMin(int[] arr) {
        Stack stoneBlock = new Stack();
        int count = 1;
        stoneBlock.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if ((int) stoneBlock.peek() == arr[i]) {
                continue;
            } else if (arr[i] > (int) stoneBlock.peek()) {
                stoneBlock.push(arr[i]);
                count++;
            } else if (arr[i] < (int) stoneBlock.peek()) {
                stoneBlock.pop();
                while (stoneBlock.size() > 0 && arr[i] < (int) stoneBlock.peek()) {
                    stoneBlock.pop();
                }
                if (stoneBlock.size() == 0 || arr[i] > (int) stoneBlock.peek()) {
                    stoneBlock.push(arr[i]);
                    count++;
                }
            }
        }
        return count;
    }
}