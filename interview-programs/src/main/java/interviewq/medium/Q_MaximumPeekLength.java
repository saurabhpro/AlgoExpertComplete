package interviewq.medium;

public class Q_MaximumPeekLength {
    /**
     * O(n) time | O(1) space
     */
    public static int longestPeak(int[] arr) {
        int result = -1;

        // treat all i's as tip of the hill
        int i = 1;
        while (i < arr.length - 1) {
            int leftIdx = i - 1;
            int rightIdx = i + 1;

            // if isPeak
            if (arr[leftIdx] < arr[i] && arr[i] > arr[rightIdx]) {

                while (leftIdx > 0 && arr[leftIdx - 1] < arr[leftIdx]) {
                    leftIdx--;
                }

                while (rightIdx + 1 < arr.length && arr[rightIdx] > arr[rightIdx + 1]) {
                    rightIdx++;
                }

                int newPeekLength = rightIdx - leftIdx + 1;
                if (newPeekLength > result) {
                    result = newPeekLength;
                }
            }

            // since they were strictly decreasing - assign i = rightIdx
            i = rightIdx;
        }

        return result;
    }

    public static void main(String[] args) {
        final int longestPeak = longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3});
        System.out.println(longestPeak);
    }
}
