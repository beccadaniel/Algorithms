import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LShapedPlot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numTestCases; i++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            int[][] matrix = new int[rows][cols];

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + getLShapes(getGoodSegments(matrix, rows, cols)));
        }
    }

    private static boolean isPerpendicular(Segment A, Segment B) {
        return (A.start.isEqual(B.end) || B.start.isEqual(A.end));
    }

    private static boolean isLShape(Segment A, Segment B) {
        System.out.println("A is: " + A.toString());
        System.out.println("B is: " + B.toString());

        boolean isPerpendicular = isPerpendicular(A, B);
        int aLength = A.getLength();
        int bLength = B.getLength();
        int maxLength, minLength;
        if (aLength > bLength) {
            maxLength = aLength;
            minLength = bLength;
        } else {
            maxLength = bLength;
            minLength = aLength;
        }

        return (isPerpendicular && aLength > 1 && bLength > 1 && (maxLength == (minLength*2)));
    }

    private static int getLShapes(ArrayList<Segment> goodSegments) {

        int count = 0;
        for (int i = 0; i < goodSegments.size()-1; i++) {
            for (int j = i + 1; j < goodSegments.size(); j++) {
                if (isLShape(goodSegments.get(i), goodSegments.get(j))) {
                    count++;
                }
            }
        }
        return count;

    }

    private static ArrayList<Segment> getGoodSegments(int[][] matrix, int row, int col) {
        boolean hasStartedGoodSegment = false;
        int lengthOfGoodSegment = 0;
        Point startPoint;
        Point endPoint;
        Point currentPoint;

        ArrayList<Segment> goodSegmentList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            startPoint = null;
            currentPoint = new Point(i,0);
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    currentPoint = new Point(i, j);
                    hasStartedGoodSegment = true;
                    lengthOfGoodSegment++;
                    if (lengthOfGoodSegment == 1) {
                        startPoint = new Point(i, j);
                    }
                    if (j == col -1) {
                        goodSegmentList.add(goodSegmentList.size(), new Segment(startPoint, currentPoint));
                    }
                } else {
                    endPoint = currentPoint;

                    if (hasStartedGoodSegment) {
                        goodSegmentList.add(goodSegmentList.size(), new Segment(startPoint, endPoint));
                    }
                    lengthOfGoodSegment = 0;
                    hasStartedGoodSegment = false;
                }

            }
            lengthOfGoodSegment = 0;
            hasStartedGoodSegment = false;
        }

        hasStartedGoodSegment = false;
        lengthOfGoodSegment = 0;

        for (int i = 0; i < col; i++) {
            startPoint = null;
            currentPoint = new Point(i,0);
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] == 1) {
                    hasStartedGoodSegment = true;
                    lengthOfGoodSegment++;
                    if (lengthOfGoodSegment == 1) {
                        startPoint = new Point(j, i);
                    }

                    currentPoint = new Point(j, i);
                    if (j == row -1) {
                        endPoint = new Point(j, i);
                        goodSegmentList.add(goodSegmentList.size(), new Segment(startPoint, endPoint));

                    }

                } else {
                    if (hasStartedGoodSegment) {
                        goodSegmentList.add(goodSegmentList.size(), new Segment(startPoint, currentPoint));
                    }
                    lengthOfGoodSegment = 0;
                    hasStartedGoodSegment = false;
                }
            }

            lengthOfGoodSegment = 0;
            hasStartedGoodSegment = false;
        }

        for (Segment seg:goodSegmentList) {
            System.out.println(seg.toString());
        }
        return goodSegmentList;
    }

    static class Segment {
        Point start;
        Point end;

        Segment(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public int getLength() {
            return (end.x - start.x) + (end.y - start.y) + 1;
        }

        @Override
        public String toString() {

            return "Segment{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static class Point {
        int x;
        int y;
        Point(int start, int end) {
            this.x = start;
            this.y = end;
        }

        public boolean isEqual(Point B) {
            return (this.x == B.x) && (this.y == B.y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
