package interviewq.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q12_MaximumNonAdjacentSumTest {

    @Test
    void maxSubsetSumNoAdjacent() {

        final int maxSubsetSumNoAdjacent = Q12_MaximumNonAdjacentSum.maxSubsetSumNoAdjacent(new int[]{7, 10, 12, 7, 9, 14, 15, 16, 25, 20, 4});
        assertEquals(72, maxSubsetSumNoAdjacent);
    }
}