package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Q19_RiverSizes2Test {

    @Test
    void dfs() {
        int[][] matrix = {{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}};
        final List<Integer> integers = Q19_RiverSizes_2.riverSizes(matrix);

        System.out.println(integers);
        Assertions.assertEquals(List.of(3, 2, 1), integers);
    }
}