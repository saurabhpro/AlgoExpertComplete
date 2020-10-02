package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q15_LevenshteinDistanceTest {

    @Test
    void levenshteinDistance() {
        final int levenshteinDistance = Q15_LevenshteinDistance.levenshteinDistance("abc", "yabd");

        Assertions.assertEquals(2, levenshteinDistance);
    }

    @Test
    void levenshteinDistanceFast() {
        final int levenshteinDistance = Q15_LevenshteinDistance.levenshteinDistanceFast("abc", "yabd");

        Assertions.assertEquals(2, levenshteinDistance);
    }
}