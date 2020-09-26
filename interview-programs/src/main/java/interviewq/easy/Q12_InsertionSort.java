package interviewq.easy;

import java.util.Arrays;

// with every pass the pre-subarray is always sorted
// https://www.geeksforgeeks.org/binary-insertion-sort/ to reduce worse case comparison to O(n log n)
public class Q12_InsertionSort {

    // O(n^2) time | O(1) space
    public static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] sort = insertionSort(new int[]{1, 3, 2});
        System.out.println(Arrays.toString(sort));

    }

    // O(n log n) time
    public void binaryInsertionSort(int[] array) {
        for (int counter = 1; counter < array.length; counter++) {
            final int key = array[counter];

            // Find location to insert using binary search
            final int j = Math.abs(Arrays.binarySearch(array, 0, counter, key) + 1);

            // Shifting array to one location right
            // src srcPos dest destPos length
            System.arraycopy(array, j, array, j + 1, counter - j);

            // Placing element at its correct location
            array[j] = key;
        }
    }

}
