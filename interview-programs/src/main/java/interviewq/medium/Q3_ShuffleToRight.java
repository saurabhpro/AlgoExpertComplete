package interviewq.medium;

import java.util.List;

/**
 * from a list of values - we move all values equal to desired value to the right
 */
public class Q3_ShuffleToRight {

    // O(n) time | O(1) space for tmp vars
    public static List<Integer> moveElementToEnd(List<Integer> array,
                                                 int toMove) {
        int left = 0;
        int right = array.size() - 1;

        System.out.println(array);

        // overall O(n) as both while will do n loops
        while (left < right) {
            int first = array.get(left);
            int last = array.get(right);

            // keep decrementing if already found the required value
            while (left < right && last == toMove) {
                right--;
                last = array.get(right);
            }

            // check the current first value to see if swapping is required
            if (first == toMove) {
                swap(array, left, right);
            }

            // increment left
            left++;
        }

        return array;
    }

    private static void swap(List<Integer> arr, int left, int right) {
        int tmp = arr.get(left);
        arr.set(left, arr.get(right));
        arr.set(right, tmp);
    }
}
