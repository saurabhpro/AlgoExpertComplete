package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Q19_RiverSizesTest {

    @Test
    void riverSizes() {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };

        List<Integer> expected = List.of(1, 2, 2, 2, 5);

        final var riverSizes = Q19_RiverSizes.riverSizes(input);
        Assertions.assertEquals(expected, riverSizes);
    }
}