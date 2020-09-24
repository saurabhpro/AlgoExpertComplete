package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Q5_SpiralTraversalOf2DArrayTest {

    @Test
    void flatten2DArray() {
    }

    @Test
    void spiralTraverse() {
        final int[][] input = {
                {1}
        };

        // 1
        final var integers = Q5_SpiralTraversalOf2DArray.spiralTraverse(input);

        Assertions.assertEquals(List.of(1), integers);
    }

    @Test
    void spiralTraverse_2() {
        final int[][] input = {
                {4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
                {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}
        };

        // 1
        final var integers = Q5_SpiralTraversalOf2DArray.spiralTraverse(input);

        Assertions.assertEquals(List.of(4, 2, 3, 6, 7, 8, 1, 9, 5, 10, 14, 11, 17, 13, 18, 20, 16, 15, 19, 12), integers);
    }
}