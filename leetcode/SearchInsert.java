package leetcode;

public class SearchInsert {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        System.out.println(searchOrInsert(a, 4));
    }

    static int searchOrInsert(int[] nums, int a) {

        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < a)
                low = mid + 1;
            else
                high = mid;
        }
        return low;

        /*
        // Alternative solution
        int low = 0, high = arr.length-1, index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((arr[mid] == a) || ((mid == 0) && (arr[mid] > a))) {
                index = mid;
                break;
            }
            if (((mid == arr.length-1) && (arr[mid])<a) || ((arr[mid] < a) && (arr[mid+1] > a))) {
                index = mid + 1;
                break;
            }
            else if ((arr[mid] > a) && (arr[mid-1] < a)) {
                index = mid;
                break;
            }
            else if (arr[mid] < a) {
                low = mid + 1;
            }
            else if (arr[mid] > a) {
                high = mid - 1;
            }
        }
        return index;*/
    }
}
