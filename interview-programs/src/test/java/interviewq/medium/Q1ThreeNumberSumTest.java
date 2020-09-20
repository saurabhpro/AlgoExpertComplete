package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class Q1ThreeNumberSumTest {

    @Test
    void threeNumberSum() {

        final var integers = Q1_ThreeNumberSum.threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);

        List<Integer[]> expected = List.of(
                new Integer[]{-8, 2, 6},
                new Integer[]{-8, 3, 5},
                new Integer[]{-6, 1, 5}
        );

        IntStream.range(0, integers.size())
                .forEachOrdered(
                        i -> Assertions.assertArrayEquals(expected.get(i), integers.get(i))
                );

    }
}