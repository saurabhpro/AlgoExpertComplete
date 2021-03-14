package interviewq.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q_ThreeLargestNumber {
    /**
     * take three values - sort them
     * compare with the first value - if larger - replace the first value and then sort again
     */
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here
        int[] result = {array[0], array[1], array[2]};
        Arrays.sort(result);

        // O(n + m log m) is m log m constant for 3 largest?
        // O(1) space
        for (int i = 3; i < array.length; i++) {
            if (array[i] > result[0]) {
                result[0] = array[i];
            }

            Arrays.sort(result);
        }

        return result;
    }


    public static int[] findThreeLargestNumbers_linear(int[] array) {
        int[] result = new int[3];
        Arrays.fill(result, Integer.MIN_VALUE);

        for (final int currentValue : array) {
            if (currentValue > result[2]) {
                shiftAndUpdate(result, currentValue, 2);
            } else if (currentValue > result[1]) {
                shiftAndUpdate(result, currentValue, 1);
            } else if (currentValue > result[0]) {
                shiftAndUpdate(result, currentValue, 0);
            }
        }

        return result;
    }

    /**
     * The idea is we know that the number we want to put here is known to be larger than {@param atIndex}
     * so replace the first element with next until we get to the atIndex
     * then put the {@param valueToPut} atIndex
     * @param result
     * @param valueToPut
     * @param atIndex
     */
    private static void shiftAndUpdate(int[] result, int valueToPut, int atIndex) {
        if (result[atIndex] != Integer.MIN_VALUE) {
            IntStream.range(0, atIndex)
                    .forEach(i -> result[i] = result[i + 1]);
        }

        result[atIndex] = valueToPut;
    }
}
