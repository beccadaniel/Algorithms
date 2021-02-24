package hackerrank;

/*
 * Instead of moving one by one, divide the array in different sets 
 * where number of sets is equal to GCD of n(no of elements in the array) and d(no of rotations to perform) 
 * and move the elements within sets.
If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only, we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.

Here is an example for n =12 and d = 3. GCD is 3 and

Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}

a)	Elements are first moved in first set – (1,2,3)(4,5,6)(7,8,9)(10,11,12)

ArrayRotation

          arr[] after this step --> {4 2 3 7 5 6 10 8 9 1 11 12}

b)	Then in second set.
          arr[] after this step --> {4 5 3 7 8 6 10 11 9 1 2 12}

c)	Finally in third set.
          arr[] after this step --> {4 5 6 7 8 9 10 11 12 1 2 3}

 * 
 */
public class RotateArray {
    int gcd(int a, int b) {
        //using euclid's algorithm

        int ans;

        if (b == 0)
            ans = a;
        else
            ans = gcd(b, a % b);

        return ans;
    }

    void rotate(int arr[], int d, int n) {
        //where n is no of elements and d is no of rotations

        for (int i = 0; i < gcd(d, n); i++) {
            int j, k, temp;
            for (i = 0; i < gcd(d, n); i++) {
                /* move i-th values of blocks */
                temp = arr[i];
                j = i;
                while (1 != 0) {
                    k = j + d;
                    if (k >= n)
                        k = k - n;
                    if (k == i)
                        break;
                    arr[j] = arr[k];
                    j = k;
                }
                arr[j] = temp;

            }
        }
    }

    public static void main(String[] args) {

        RotateArray lrotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        lrotate.rotate(arr, 2, 7);
        lrotate.printArray(arr, 7);

    }

    void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

}

