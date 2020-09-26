package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q13_NumberOfWaysToMakeCoinChangeTest {

    @Test
    void numberOfWaysToMakeChange() {

        final int waysToMakeChange = Q13_NumberOfWaysToMakeCoinChange.numberOfWaysToMakeChange(5, new int[]{4, 1});
        Assertions.assertEquals(2, waysToMakeChange);
    }

    @Test
    void numberOfWaysToMakeChange_9() {

        final int waysToMakeChange = Q13_NumberOfWaysToMakeCoinChange.numberOfWaysToMakeChange(9, new int[]{5, 10, 25});
        Assertions.assertEquals(0, waysToMakeChange);
    }

    @Test
    void numberOfWaysToMakeChange_10() {

        final int waysToMakeChange = Q13_NumberOfWaysToMakeCoinChange.numberOfWaysToMakeChange(
                10,
                new int[]{1, 5, 10, 25}
        );

        /*
        1 * 10

        5 * 2
        5 * 1 + 1 * 5

        10 * 1
         */

        Assertions.assertEquals(4, waysToMakeChange);
    }

    @Test
    void numberOfWaysToMakeChange_25() {

        final int waysToMakeChange = Q13_NumberOfWaysToMakeCoinChange.numberOfWaysToMakeChange(
                25,
                new int[]{1, 5, 10, 25}
        );

        /*
        1 * 25

        5 * 5
        5 * 1 + 10 * 2
        5 * 1 + 10 * 1 + 1 * 10
        5 * 1 + 1 * 20
        5 * 2 + 10 * 1 + 1 * 5
        5 * 2 + 1 * 15
        5 * 3 + 10 * 1
        5 * 3 + 1 * 10
        5 * 4 + 1 * 5

        10 * 1 + 1 * 15
        10 * 2 + 1 * 5

        25 * 1
         */

        Assertions.assertEquals(13, waysToMakeChange);
    }
}