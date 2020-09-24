package interviewq.medium;

/**
 * if either increasing or decreasing
 * (note there can be duplicates in between - hence not the word strictly increasing/decreasing)
 */
public class Q4_Monotonic {

    // O(n) time | O(1) space - where n is length of array
    public static boolean isMonotonic(int[] array) {
        if (array.length < 2) {
            return true;
        }

        boolean rv = true;
        boolean isIncreasing = false;

        int first = array[0];

        // case: if the beginning values cannot give you clear idea
        // eg. 2, 2, 2, 5
        int start = 1;
        int second = array[start];
        while (start < array.length - 1 && first == second) {
            start++;
            second = array[start];
        }

        // decide on the direction
        if (first < second) {
            isIncreasing = true;
        }

        // check if the assumption is not broken
        for (int i = start; i < array.length - 1; i++) {
            if (!compare(array[i], array[i + 1], isIncreasing)) {
                rv = false;
                break;
            }
        }

        return rv;
    }

    private static boolean compare(int i, int j, boolean isIncreasing) {
        if (isIncreasing) {
            return i <= j;
        } else {
            return i >= j;
        }
    }

    public static void main(String[] args) {
        int[] input = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(input));
    }
}
