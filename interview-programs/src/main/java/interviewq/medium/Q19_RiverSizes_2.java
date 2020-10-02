package interviewq.medium;

import java.util.ArrayList;
import java.util.List;

public class Q19_RiverSizes_2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 1}
        };

        final List<Integer> riverSizes = riverSizes(matrix);
        System.out.println(riverSizes);
    }

    private static class Node {
        final int value;

        // links value
        final int left;
        final int right;
        final int up;
        final int down;

        boolean isVisited;

        Node(int[][] arr, int i, int j) {
            this.value = arr[i][j];

            this.up = ((i - 1) < 0) ? 0 : arr[i - 1][j];
            this.down = ((i + 1) > (arr.length - 1)) ? 0 : arr[i + 1][j];
            this.left = ((j - 1) < 0) ? 0 : arr[i][j - 1];
            this.right = ((j + 1) > (arr[i].length - 1)) ? 0 : arr[i][j + 1];
        }
    }

    /**
     * get all sizes
     */
    public static List<Integer> riverSizes(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();

        // get Nodes
        final Node[][] adjacencyMatrix = convertToGraphArray(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (adjacencyMatrix[i][j].value == 1 && !adjacencyMatrix[i][j].isVisited) {
                    int count = dfs(adjacencyMatrix, i, j);
                    result.add(count);
                }
            }
        }

        return result;
    }

    /**
     * Prepare adjacency array
     */
    private static Node[][] convertToGraphArray(int[][] arr) {
        final Node[][] nodes = new Node[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                nodes[i][j] = new Node(arr, i, j);
            }
        }

        return nodes;
    }

    private static int dfs(Node[][] adjacencyMatrix, int i, int j) {
        // base case
        if (i > adjacencyMatrix.length || j > adjacencyMatrix[i].length     // check length
                || adjacencyMatrix[i][j].value == 0) {
            return 0;
        }

        // init local sum
        int sum = 0;

        // since we only visit here if we have seen a 1
        adjacencyMatrix[i][j].isVisited = true;

        //up
        if (adjacencyMatrix[i][j].up == 1 && !adjacencyMatrix[i - 1][j].isVisited) {
            sum += dfs(adjacencyMatrix, i - 1, j);
        }

        //down
        if (adjacencyMatrix[i][j].down == 1 && !adjacencyMatrix[i + 1][j].isVisited) {
            sum += dfs(adjacencyMatrix, i + 1, j);
        }

        //left
        if (adjacencyMatrix[i][j].left == 1 && !adjacencyMatrix[i][j - 1].isVisited) {
            sum += dfs(adjacencyMatrix, i, j - 1);
        }

        //right
        if (adjacencyMatrix[i][j].right == 1 && !adjacencyMatrix[i][j + 1].isVisited) {
            sum += dfs(adjacencyMatrix, i, j + 1);
        }

        return 1 + sum;
    }
}