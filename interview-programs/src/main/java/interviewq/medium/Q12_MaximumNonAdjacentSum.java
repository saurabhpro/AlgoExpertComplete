package interviewq.medium;

import java.util.*;

/**
 * This question was asked in first Paytm interview and I was rejected
 * its a DP problem -> the result can be interpolated by previously calculated results
 */
public class Q12_MaximumNonAdjacentSum {

    public static void main(String[] args) {
        int maxSubsetSumNoAdjacent = maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 90, 135});
        System.out.println(maxSubsetSumNoAdjacent);

        maxSubsetSumNoAdjacent = maxSubsetSumNoAdjacentAllIndexSum(new int[]{75, 105, 120, 75, 90, 135});
        System.out.println(maxSubsetSumNoAdjacent);
    }

    /**
     * Also saves indexes
     */
    // O(n) time | O(n) space
    public static int maxSubsetSumNoAdjacentAllIndexSum(int[] array) {
        final Map<Integer, List<Integer>> in = new HashMap<>();

        // base cases
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }

        // our all input length result store    // O(n) space
        int[] maxSums = new int[array.length];

        // fill init dp
        maxSums[0] = array[0];
        in.put(0, List.of(0));

        maxSums[1] = Math.max(array[0], array[1]);  // if we only hv two numbers - the greater of two is the answer
        in.put(1, List.of(maxSums[1] == array[0] ? 0 : 1));

        // for new sum - add non adjacent predecessor result (i-2) + current value
        // check if previous sum is still maximum then the new sum
        for (int pointer = 2; pointer < array.length; pointer++) {

            int newMaxSum = maxSums[pointer - 2] + array[pointer];
            maxSums[pointer] = Math.max(maxSums[pointer - 1], newMaxSum);

            saveIndicesForCurrentIteration(in, pointer, maxSums[pointer] == newMaxSum);
        }

        System.out.println(Arrays.toString(maxSums));
        System.out.println(in);
        return maxSums[array.length - 1];
    }

    private static void saveIndicesForCurrentIteration(Map<Integer, List<Integer>> in,
                                                       int pointer,
                                                       boolean isMaxValueChanged) {
        final List<Integer> maxSumIndices = new ArrayList<>();

        if (isMaxValueChanged) {
            maxSumIndices.addAll(in.get(pointer - 2));
            maxSumIndices.add(pointer);
        } else {
            maxSumIndices.addAll(in.get(pointer - 1));
        }

        in.put(pointer, maxSumIndices);
    }

    // O(n) time | O(1) space
    // since we only need the i-1 and i-2 sums
    public static int maxSubsetSumNoAdjacent(int[] array) {
        final Map<Integer, List<Integer>> in = new HashMap<>();

        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }

        int secondPredecessorMaxSum = array[0];
        in.put(0, List.of(0));

        int firstPredecessorMaxSum = Math.max(array[0], array[1]); // if we only hv two numbers - the greater of two is the answer
        in.put(1, List.of(firstPredecessorMaxSum == array[0] ? 0 : 1));

        // for new sum - add non adjacent predecessor result = secondPredecessorMaxSum + current value
        // check if previous sum is still maximum then the new sum
        for (int pointer = 2; pointer < array.length; pointer++) {
            int currentMaxSum = Math.max(firstPredecessorMaxSum, secondPredecessorMaxSum + array[pointer]);

            saveIndicesForCurrentIteration(in, pointer, firstPredecessorMaxSum != currentMaxSum);

            // update values for next iteration
            secondPredecessorMaxSum = firstPredecessorMaxSum;
            firstPredecessorMaxSum = currentMaxSum;
        }

        System.out.println(in);
        return firstPredecessorMaxSum;
    }

}
