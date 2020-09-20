package interviewq.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1_TwoSum {


    /**
     * O (n^2) time | O(1) space complexity
     */
    public static int[] twoNumberSum_v1_forLoop(int[] array, int targetSum) {
        // Write your code here.
        int[] rv = new int[0];

        for (int i = 0; i < array.length; i++) {
            int a = array[i];

            for (int j = i + 1; j < array.length; j++) {
                int b = array[j];
                if (a + b == targetSum) {
                    return new int[]{a, b};
                }
            }
        }
        return rv;
    }

    /**
     * O(n) space | O(n) time
     */
    public static int[] twoNumberSum_v2_hashSet(int[] array, int targetSum) {
        // Write your code here.
        int[] rv = new int[0];
        Set<Integer> req = new HashSet<>(array.length);

        int reqValue;

        for (int value : array) {
            reqValue = targetSum - value;
            if (req.contains(reqValue)) {
                rv = new int[]{value, reqValue};
                break;
            } else {
                req.add(value);
            }
        }

        return rv;
    }

    /**
     * O(n log n) time | O(1) space
     */
    public static int[] twoNumberSum_v3_pointers(int[] array, int targetSum) {
        // Write your code here.
        int[] rv = new int[0];

        // O (n log(n)) for sorting
        long time = System.currentTimeMillis();
        Arrays.sort(array);
        System.out.println("v3 Sorted in " + (System.currentTimeMillis() - time) + "ms");

        // space for these values
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int potentialMatch = array[left] + array[right];

            if (potentialMatch == targetSum) {
                rv = new int[]{array[left], array[right]};
                break;
            } else if (potentialMatch < targetSum) {
                // since we know sum is smaller
                left++;
            } else if (potentialMatch > targetSum) {
                right--;
            }
        }

        return rv;
    }


}
