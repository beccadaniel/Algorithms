package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SkylineProblem {

    public static void main(String[] args) {
        //int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        //int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};
        //int[][] buildings = {{2,9,10}, {9,12,15}};
        //int[][] buildings = {{3,10,20},{3,9,19},{3,8,18},{3,7,17},{3,6,16},{3,5,15},{3,4,14}};
        //int[][] buildings = {{2,13,10},{10,17,25},{12,20,14}};

        int[][] buildings = {{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
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
        //int farthestRight = buildings[0][1];
        points.add(buildings[0][0]);
        points.add(buildings[0][2]);
        skyline.add(points);

        int currentLeft;
        int currentRight;
        int currentHeight;
        int previousLeft = buildings[0][0];
        int previousRight = buildings[0][1];
        int previousHeight = buildings[0][2];

        for (int i = 0; i < buildings.length; i++) {
            List<Integer> currentPoint = new ArrayList<>(2);
            currentLeft = buildings[i][0];
            currentRight = buildings[i][1];
            currentHeight = buildings[i][2];

            if (currentLeft == previousLeft) {
                if (currentHeight < previousHeight) {
                    if(currentRight > previousRight) {
                        currentPoint.add(previousRight);
                        currentPoint.add(currentHeight);
                        previousRight = Math.max(previousRight, currentRight);
                        skyline.add(currentPoint);

                        System.out.print("1: " + currentPoint.get(0) + " " + currentPoint.get(1));
                        System.out.println("\n");
                    }
                } else if (currentHeight > previousHeight) {
                    skyline.remove(skyline.size()-1);
                    currentPoint.add(currentLeft);
                    currentPoint.add(currentHeight);
                    previousRight = Math.max(previousRight, currentRight);
                    skyline.add(currentPoint);

                    System.out.print("2: " + currentPoint.get(0) + " " + currentPoint.get(1));
                    System.out.println("\n");
                    if (currentRight < previousRight) {
                        List<Integer> newPoint = new ArrayList<>(2);
                        newPoint.add(currentRight);
                        newPoint.add(previousHeight);
                        skyline.add(newPoint);

                        System.out.print("3: " + newPoint.get(0) + " " + newPoint.get(1));
                        System.out.println("\n");
                    }
                }
            } else if (currentLeft == previousRight) {
                if (currentHeight != previousHeight) {
                    currentPoint.add(currentLeft);
                    currentPoint.add(currentHeight);
                    previousRight = Math.max(previousRight, currentRight);
                    skyline.add(currentPoint);

                    System.out.print("4: " + currentPoint.get(0) + " " + currentPoint.get(1));
                    System.out.println("\n");
                } else {
                    previousRight = currentRight;
                }
            } else if (currentLeft > previousRight) {
                List<Integer> currentList = new ArrayList<>(2);
                currentList.add(previousRight);
                currentList.add(0);
                skyline.add(currentList);

                System.out.print("5: " + currentList.get(0) + " " + currentList.get(1));
                System.out.println("\n");

                currentPoint.add(currentLeft);
                currentPoint.add(currentHeight);
                previousRight = Math.max(previousRight, currentRight);
                skyline.add(currentPoint);

                System.out.print("6: " + currentPoint.get(0) + " " + currentPoint.get(1));
                System.out.println("\n");

            } else if (currentLeft < previousRight) {
                if (currentHeight < previousHeight) {
                    if (currentRight > previousRight) {
                        currentPoint.add(previousRight);
                        currentPoint.add(currentHeight);
                        previousRight = Math.max(previousRight, currentRight);
                        skyline.add(currentPoint);

                        System.out.print("7: " + currentPoint.get(0) + " " + currentPoint.get(1));
                        System.out.println("\n");
                    }
                } else if (currentHeight > previousHeight) {
                    if ((currentRight > previousRight) || (currentRight == previousRight)) {
                        if ((i == 1) && (currentLeft < previousRight)) {
                            currentPoint.add(currentLeft);
                        } else {
                            currentPoint.add(buildings[i-1][1]);
                        }
                        currentPoint.add(currentHeight);
                        previousRight = Math.max(previousRight, currentRight);
                        skyline.add(currentPoint);

                        System.out.print("8: " + currentPoint.get(0) + " " + currentPoint.get(1));
                        System.out.println("\n");

                    } else if (currentRight < previousRight) {
                        currentPoint.add(currentLeft);
                        currentPoint.add(currentHeight);
                        previousRight = Math.max(previousRight, currentRight);
                        skyline.add(currentPoint);

                        System.out.print("9: " + currentPoint.get(0) + " " + currentPoint.get(1));
                        System.out.println("\n");

                    }
                }

                else if ((currentLeft == previousLeft) && (i==buildings.length-1)) {
                    currentPoint.add(previousRight);
                    currentPoint.add(0);
                    skyline.add(currentPoint);

                    System.out.print("10: " + currentPoint.get(0) + " " + currentPoint.get(1));
                    System.out.println("\n");
                }
                else {
                    previousRight = Math.max(previousRight, currentRight);
                }
            }
        }

        List<Integer> point = new ArrayList<>(2);
        point.add(previousRight);//buildings[buildings.length-1][1]);
        point.add(0);
        if (skyline.get(skyline.size()-1).get(1) != point.get(1)) {
            skyline.add(point);

            System.out.print("11: " + point.get(0) + " " + point.get(1));
            System.out.println("\n");
        }

        return skyline;
    }
}
