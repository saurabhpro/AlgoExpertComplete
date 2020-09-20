package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q2_MinDifferenceTest {

    @Test
    void smallestDifference() {
        // given
        int[] a = {-1, 5, 10, 20, 28, 3};
        int[] b = {26, 134, 135, 15, 17};

        // when
        final var smallestDifference = Q2_MinDifference.smallestDifference(a, b);

        // then
        Assertions.assertArrayEquals(new int[]{28, 26}, smallestDifference);
    }
}