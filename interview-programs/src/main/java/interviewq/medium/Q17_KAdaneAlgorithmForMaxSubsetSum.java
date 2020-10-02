package interviewq.medium;

public class Q17_KAdaneAlgorithmForMaxSubsetSum {

    // O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] array) {

        int currentMax = 0;
        int result = Integer.MIN_VALUE;

        for (int currentVal : array) {
            currentMax = Math.max(currentMax + currentVal, currentVal);

            result = Math.max(result, currentMax);
        }

        return result;
    }

    public static void main(String[] args) {
        final int maxSubsetSum = kadanesAlgorithm(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4});
        System.out.println(maxSubsetSum);
    }
}