package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q4_MonotonicTest {

    @Test
    void isMonotonic() {
        int[] input = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        Assertions.assertTrue(Q4_Monotonic.isMonotonic(input));
    }

    @Test
    void isMonotonic_2() {
        int[] input = {-1, -1, -10, -1100, -1100, -1101, -1102, -9001};
        Assertions.assertTrue(Q4_Monotonic.isMonotonic(input));
    }

    @Test
    void isMonotonic_3() {
        int[] input = {-1, -10, -9};
        Assertions.assertFalse(Q4_Monotonic.isMonotonic(input));
    }
}