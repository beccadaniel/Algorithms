package codility;

public class PermMissingElement {

    public static void main(String[] args) {
        int[] arr = {3,1};
        System.out.println(findMissingElement(arr));
    }

    private static int findMissingElement(int[] arr) {
        int missingElement = 0;
        for (int i=0; i<arr.length; i++) {
            missingElement = (i+1) ^ arr[i] ^ missingElement;
            System.out.println(missingElement);
        }
        return missingElement ^ (arr.length+1);
    }
}
