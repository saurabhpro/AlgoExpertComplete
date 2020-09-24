package interviewq.easy;

import java.util.Arrays;

public class Q9_BinarySearch {

    public static int binarySearch(int[] array, int target) {
        System.out.println(Arrays.toString(array));

        return doBinarySearch(array, target, 0, array.length - 1);
    }

    private static int doBinarySearch(int[] array, int target, int start, int end) {
        // base case
        // for iterative just reverse and use in while (start <= end){ same }
        if (start > end) {
            return -1;
        }

        // find and check mid
        int mid = (end + start) / 2;
        int potentialMatch = array[mid];

        if (target == potentialMatch) {
            return mid;
        } else if (target < potentialMatch) {
            // search right
            return doBinarySearch(array, target, start, mid - 1);
        } else {
            // search right
            return doBinarySearch(array, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};

        int res = binarySearch(array, 33);
        System.out.println("Expected index of value 33 = " + res);
    }
}
