package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Q7_ProductSumTest {

    @Test
    void productSum() {
        // 5 + 2 + 2 * (7-1) + 2 * (3 + 3 * (6-4) + 1))
        // 7 + 12 + 2 * 10
        // 39
        final var productSum = Q7_ProductSum.productSum(List.of(5, 2, List.of(7, -1), List.of(3, List.of(6, -4), 1)));
        Assertions.assertEquals(39, productSum);
    }

    @Test
    void productSum2() {
        // 5 + 2 + (2 * (7 + -1)) + 3 + (2 * (6 + 3 * (-13 + 8) + 4))
        // 7 + 12 + 3 + 2 * (10 + -15)
        // 22 + -10
        // 12

        // the length of m = 12 (the multipliers are counted as well)
        // so O(n) = O(12) and not 5 first level values
        List<Object> m = List.of(5, 2, List.of(7, -1), 3, List.of(6, List.of(-13, 8), 4));
        final var productSum = Q7_ProductSum.productSum(m);
        Assertions.assertEquals(12, productSum);
    }
}