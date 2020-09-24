package interviewq.easy;

import java.util.Arrays;

// the biggest element is always at end after each pass
public class Q11_BubbleSort {
    /**
     * fixing maximum version
     */
    public static int[] bubbleSort(int[] array) {
        boolean isSorted = false;

        // this starts fixing the last value of the array
        int counter = 0;
        while (!isSorted) {
            // check if all are sorted - then exit
            isSorted = true;

            for (int i = 0; i < array.length - 1 - counter; i++) {

                // loop till the end and move the max value to the end
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }

            counter++;
        }
        return array;
    }

    /**
     * fixing minimum version -- same optimization
     */
    public static int[] bubbleSortForLoop(int[] array) {
        boolean isSorted = false;

        // this starts fixing the last value of the array
        // assumption -> by some time isSorted will be true <= size of array
        for (int counter = 0; !isSorted; counter++) {
            isSorted = true;

            for (int j = 0; j < array.length - counter - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
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
        int[] sort = bubbleSort(new int[]{1, 3, 2});
        System.out.println(Arrays.toString(sort));

        sort = bubbleSortForLoop(new int[]{1, 3, 2});
        System.out.println(Arrays.toString(sort));
    }
}
