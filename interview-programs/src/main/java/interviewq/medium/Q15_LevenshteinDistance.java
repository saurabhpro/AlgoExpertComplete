package interviewq.medium;

import java.util.stream.IntStream;

public class Q15_LevenshteinDistance {

    /**
     * Three ops
     * - insert a new char
     * - modify an existing char
     * - delete an existing char from first string to make it to second string
     * O(nm) time | O(nm) space
     */
    public static int levenshteinDistance(String str1, String str2) {
        // to accommodate first row and col as ""
        int[][] edits = new int[str2.length() + 1][str1.length() + 1];

        // first row = ""
        IntStream.range(0, str1.length() + 1)
                .forEach(j -> edits[0][j] = j);

        // first column = ""
        IntStream.range(1, str2.length() + 1)
                .forEach(i -> edits[i][0] = i);

        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {

                // since str are still bound to 0 index
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + //minimumOfAllNeighbours
                            Math.min(edits[i - 1][j - 1],//diagonal
                                    Math.min(edits[i - 1][j], edits[i][j - 1]));  //top-left
                }
            }
        }

        return edits[str2.length()][str1.length()];
    }

    /**
     * Three ops
     * - insert a new char
     * - modify an existing char
     * - delete an existing char from first string to make it to second string
     * O(nm) time | O(min(n, m)) space
     * - whichever is the smaller string will be on the y axis to minimize the cols and row is fixed 2
     */
    public static int levenshteinDistanceFast(String str1, String str2) {
        String small;
        String big;

        if (str1.length() > str2.length()) {
            big = str1;
            small = str2;
        } else {
            big = str2;
            small = str1;
        }

        // we want to store only two rows - obviously one out of the two would be even index
        // and other on odd index at any given time

        int[] evenRowEdits = new int[small.length() + 1];
        int[] oddRowEdits = new int[small.length() + 1];

        // since our first row = 0 => start with initializing evenRowEdits
        IntStream.range(0, evenRowEdits.length).forEach(i -> evenRowEdits[i] = i);

        // get two more temporary arrays for keeping track and swap operations
        int[] currentEdits;
        int[] previousEdits;

        for (int i = 1; i < big.length() + 1; i++) {
            // if the current index is odd -
            if ((i & 1) == 1) {
                currentEdits = oddRowEdits;
                previousEdits = evenRowEdits;
            } else {
                currentEdits = evenRowEdits;
                previousEdits = oddRowEdits;
            }

            // manually set the first column value
            currentEdits[0] = i;

            for (int j = 1; j < small.length() + 1; j++) {
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    currentEdits[j] = previousEdits[j - 1]; // diagonal
                } else {
                    currentEdits[j] = 1 + Math.min(previousEdits[j - 1],// diagonal
                            Math.min(previousEdits[j],  // top
                                    currentEdits[j - 1] //left
                            )
                    );
                }
            }

        }

        // is last row odd of even - based on that we pick the last column cell of our result row
        return big.length() % 2 == 0
                ? evenRowEdits[small.length()]
                : oddRowEdits[small.length()];
    }

}