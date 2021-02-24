package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeightChecker {

    /*public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(heights));
    }

    *//*Runtime: 1 ms, faster than 87.49% of Java online submissions for Height Checker.
    Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Height Checker.*//*

    public static int heightChecker(int[] heights) {
        int[] tempHeights = heights.clone();
        int count = 0;
        Arrays.sort(heights);
        for (int i = 0; i < heights.length; i++) {
            if (tempHeights[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }*/

    /*public static void main(String[] args) {
        int[] numbs = {9,76,64,21};//{3,1,5,8};
        System.out.println(maxCoins(numbs));
    }
    // use dynamic programming
    public static int maxCoins(int[] nums) {
        ArrayList<Integer> numList = new ArrayList<>();
        int left;
        int right;
        int center;
        int coin = 0;

        for (int j = 0; j < nums.length; j++) {
            numList.add(nums[j]);
        }

        for (int i = 0; i < numList.size();) {
            if (numList.size() == 2) {
                coin += (numList.get(0) * numList.get(1));
                if (numList.get(0) > numList.get(1)) {
                    numList.remove(1);
                } else {
                    numList.remove(0);
                }
            } else if (numList.size() == 1) {
                coin += numList.get(0);
                numList.remove(0);
            } else {
                left = numList.get(i);
                center = numList.get(i+1);
                right = numList.get(i+2);
                coin += (left * center * right);
                numList.remove(i+1);
            }
        }
        return coin;
    }*/

    public static void main(String[] args) {
        //int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};
        List<List<Integer>> skyline = getSkyline(buildings);

        for (int i = 0 ; i < skyline.size(); i++) {
            for (int j = 0; j < skyline.get(0).size(); j++) {
                System.out.print(skyline.get(i).get(j) + " ");
            }
            System.out.println("\n");
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyline = new ArrayList<>();
        if (buildings.length < 1) {
            return skyline;
        }
        List<Integer> points = new ArrayList<>(2);
        int farthestRight = buildings[0][1];
        points.add(buildings[0][0]);
        points.add(buildings[0][2]);
        skyline.add(points);
        for (int row = 1; row < buildings.length; row++) {
            List<Integer> point = new ArrayList<>(2);

            if (buildings[row-1][0] == buildings[row][0]) {
                point.add(buildings[row][0]);
                point.add(Math.max(buildings[row][1], buildings[row-1][1]));
                skyline.remove(skyline.size()-1);
                skyline.add(point);
            }else if (buildings[row][0] > farthestRight) {
                point.add(buildings[row-1][1]);
                point.add(0);
                skyline.add(point);
                List<Integer> extraPoint = new ArrayList<>(2);
                extraPoint.add(buildings[row][0]);
                extraPoint.add(buildings[row][2]);
                if (skyline.get(skyline.size()-1).get(1) != extraPoint.get(1)) {
                    skyline.add(extraPoint);
                }
            }else if (buildings[row][2] < buildings[row-1][2]) {
                point.add(buildings[row-1][1]);
                point.add(buildings[row][2]);
                if (skyline.get(skyline.size()-1).get(1) != point.get(1)) {
                    skyline.add(point);
                }
            } else {
                point.add(buildings[row][0]);
                point.add(buildings[row][2]);
                if (skyline.get(skyline.size()-1).get(1) != point.get(1)) {
                    skyline.add(point);
                }
            }

            farthestRight = Math.max(farthestRight, buildings[row][1]);
        }
        List<Integer> point = new ArrayList<>(2);
        point.add(buildings[buildings.length-1][1]);
        point.add(0);
        if (skyline.get(skyline.size()-1).get(1) != point.get(1)) {
            skyline.add(point);
        }
        return skyline;
    }
}
