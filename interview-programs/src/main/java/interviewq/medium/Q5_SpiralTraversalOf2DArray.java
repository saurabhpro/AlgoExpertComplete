package interviewq.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5_SpiralTraversalOf2DArray {

    public static List<Integer> flatten2DArray(int[][] arrays) {

        // Create an empty list to collect the stream
        List<Integer> list = new ArrayList<>();

        // Using forEach loop
        // convert the array into stream
        // and add the stream into list
        Arrays.stream(arrays)
                .forEach(array ->
                        Arrays.stream(array)
                                .forEach(list::add)
                );

        return list;
    }

    // O (n) time | O (n) space (list) where n is total number of elements in the 2D state
    public static List<Integer> spiralTraverse(int[][] arrays) {

        // Create an empty list to collect the stream
        List<Integer> list = new ArrayList<>();

        // the idea is make single loops - multiple times
        // define boundaries
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = arrays.length - 1;
        int endingCol = arrays[startingRow].length - 1;

        while (startingRow <= endingRow && startingCol <= endingCol) {
            for (int col = startingCol; col <= endingCol; col++) {
                list.add(arrays[startingRow][col]);
            }

            for (int row = startingRow + 1; row <= endingRow; row++) {
                list.add(arrays[row][endingCol]);
            }

            for (int col = endingCol - 1; col >= startingCol; col--) {
                if (startingRow == endingRow) {
                    break;
                }
                list.add(arrays[endingRow][col]);
            }

            for (int row = endingRow - 1; row > startingRow; row--) {
                if (startingCol == endingCol) {
                    break;
                }
                list.add(arrays[row][startingCol]);
            }

            startingRow++;
            startingCol++;
            endingRow--;
            endingCol--;
        }

        return list;
    }

    // O (n) time | O (n) space (list) where n is total number of elements in the 2D state
    public static List<Integer> spiralTraverseRecursive(int[][] arrays) {

        // Create an empty list to collect the stream
        List<Integer> list = new ArrayList<>();

        // define boundaries
        int startingRow = 0;
        int startingCol = 0;
        int endingRow = arrays.length - 1;
        int endingCol = arrays[startingRow].length - 1;

        doSpiralTraverse(arrays, list, startingRow, startingCol, endingRow, endingCol);

        return list;
    }

    /**
     * the idea is make single loops - multiple times
     */
    private static void doSpiralTraverse(int[][] arrays,
                                         List<Integer> list,
                                         int startingRow,
                                         int startingCol,
                                         int endingRow,
                                         int endingCol) {
        if (startingRow > endingRow || startingCol > endingCol) {
            return;
        }

        for (int col = startingCol; col <= endingCol; col++) {
            list.add(arrays[startingRow][col]);
        }

        for (int row = startingRow + 1; row <= endingRow; row++) {
            list.add(arrays[row][endingCol]);
        }

        for (int col = endingCol - 1; col >= startingCol; col--) {
            if (startingRow == endingRow) {
                break;
            }
            list.add(arrays[endingRow][col]);
        }

        for (int row = endingRow - 1; row > startingRow; row--) {
            if (startingCol == endingCol) {
                break;
            }
            list.add(arrays[row][startingCol]);
        }

        doSpiralTraverse(arrays, list,
                startingRow + 1,
                startingCol + 1,
                endingRow - 1,
                endingCol - 1);
    }

    public static void main(String[] args) {
        final int[][] input = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        // expected : 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        final var integers = spiralTraverseRecursive(input);

        System.out.println(integers);
    }
}