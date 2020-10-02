package interviewq.medium;

import java.util.*;

/**
 * TODO find better or clearer solution maybe ?
 */
public class Q19_RiverSizes {

    // O(n m) time | O(n m) space  where n and m are matrix dimensions
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]) {
                    continue;
                }

                traverseNode(i, j, matrix, visited, sizes);
            }
        }

        sizes.sort(Comparator.comparingInt(Integer::intValue));

        return sizes;
    }

    private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        final Deque<int[]> nodesToExploreStack = new LinkedList<>();
        nodesToExploreStack.push(new int[]{i, j});

        int currentRiverSize = 0;

        while (!nodesToExploreStack.isEmpty()) {
            final int[] current = nodesToExploreStack.pop();

            i = current[0];
            j = current[1];

            // already visited
            if (!visited[i][j]) {
                visited[i][j] = true;

                // ignore if 0
                if (matrix[i][j] != 0) {
                    currentRiverSize++;

                    var unvisitedNeighbours = getUnvisitedNeighbours(i, j, matrix, visited);
                    unvisitedNeighbours.forEach(nodesToExploreStack::push);
                }
            }
        }

        if (currentRiverSize > 0) {
            sizes.add(currentRiverSize);
        }
    }

    private static List<int[]> getUnvisitedNeighbours(int i, int j, int[][] matrix, boolean[][] visited) {
        final List<int[]> unvisitedNodes = new ArrayList<>();

        // left
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            unvisitedNodes.add(new int[]{i - 1, j});
        }

        //right
        if (i + 1 < matrix[i].length && !visited[i + 1][j]) {
            unvisitedNodes.add(new int[]{i + 1, j});
        }

        //top
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            unvisitedNodes.add(new int[]{i, j - 1});
        }

        //bottom
        if (j + 1 < matrix.length && !visited[i][j + 1]) {
            unvisitedNodes.add(new int[]{i, j + 1});
        }

        return unvisitedNodes;
    }
}


