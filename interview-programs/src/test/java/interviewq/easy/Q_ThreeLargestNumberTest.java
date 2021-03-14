package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q_ThreeLargestNumberTest {

    @Test
    void findThreeLargestNumbers() {

        int[] input = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        final var numbers = Q_ThreeLargestNumber.findThreeLargestNumbers(input);
        Assertions.assertArrayEquals(new int[]{18, 141, 541}, numbers);
    }

    @Test
    void findThreeLargestNumbers_linear() {

        int[] input = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        final var numbers = Q_ThreeLargestNumber.findThreeLargestNumbers_linear(input);
        Assertions.assertArrayEquals(new int[]{18, 141, 541}, numbers);
    }
}