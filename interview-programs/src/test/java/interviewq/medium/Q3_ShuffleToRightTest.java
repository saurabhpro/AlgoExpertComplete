package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Q3_ShuffleToRightTest {

    @Test
    void moveElementToEnd() {
        final List<Integer> input = new ArrayList<>(List.of(2, 1, 2, 2, 2, 3, 4, 2));
        final List<Integer> list = Q3_ShuffleToRight.moveElementToEnd(input, 2);

        Assertions.assertEquals(List.of(4, 1, 3, 2, 2, 2, 2, 2), list);
    }

    @Test
    void moveElementToEnd_2() {
        final List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 5, 5, 5, 5, 5, 5));
        final List<Integer> list = Q3_ShuffleToRight.moveElementToEnd(input, 5);

        Assertions.assertEquals(List.of(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 5, 5, 5, 5, 5, 5), list);
    }
}