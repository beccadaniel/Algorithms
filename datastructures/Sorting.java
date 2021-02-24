package datastructures;

public class Sorting {

    public int[] selectionsort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimalElementPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minimalElementPosition]) {
                    minimalElementPosition = j;
                }
            }
            int temp = array[i];
            array[i] = array[minimalElementPosition];
            array[minimalElementPosition] = temp;
        }
        return array;
    }
}
