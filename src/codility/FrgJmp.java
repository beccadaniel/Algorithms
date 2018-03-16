package codility;

public class FrgJmp {

    public static void main(String[] args) {
        System.out.println(getDistance(10, 85, 30));
    }

    private static int getDistance(int start, int end, int step) {
        int ans = (end - start)/step;
        if ((ans*step) < (end-start))
            return ans+1;
        return ans;
    }
}
