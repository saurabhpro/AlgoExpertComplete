package interviewq.medium;

import java.util.Arrays;

public class Q2_MinDifference {
    /**
     * O (n log (n) + O(m log (m)) time | O(1) space
     * <p>
     * where n = arrayOne.length
     * where m = arrayTwo.length
     */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int firstCounter = 0;
        int secondCounter = 0;

        int[] res = {arrayOne[0], arrayTwo[0]};
        int currentDiff;
        int smallestDiff = Integer.MAX_VALUE;

        while (firstCounter < arrayOne.length && secondCounter < arrayTwo.length) {

            final var firstArrVal = arrayOne[firstCounter];
            final var secondArrVal = arrayTwo[secondCounter];

            if (firstArrVal < secondArrVal) {
                currentDiff = secondArrVal - firstArrVal;
                firstCounter++;

            } else if (secondArrVal < firstArrVal) {
                currentDiff = firstArrVal - secondArrVal;
                secondCounter++;

            } else {
                return new int[]{firstArrVal, secondArrVal};
            }

            // if new diff is smaller - change our result
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                res = new int[]{firstArrVal, secondArrVal};
            }
        }

        return res;
    }

}
