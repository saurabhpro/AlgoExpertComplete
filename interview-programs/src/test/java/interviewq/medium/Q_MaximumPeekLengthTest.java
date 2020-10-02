package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q_MaximumPeekLengthTest {

    @Test
    void longestPeak() {
        final int peak = Q_MaximumPeekLength.longestPeak(new int[]{1, 3, 2});
        Assertions.assertEquals(3, peak);
    }
}