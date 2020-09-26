package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Q14_MinCoinsExpectedSumTest {

    @Test
    @DisplayName("Solution - 7")
    void minNumberOfCoinsForChange() {
        final int minCoins = Q14_MinCoinsExpectedSum.minNumberOfCoinsForChange(7, new int[]{1, 5, 10});
        Assertions.assertEquals(3, minCoins);
    }

    @Test
    @DisplayName("No Solution")
    void minNumberOfCoinsForChange_2() {
        final int minCoins = Q14_MinCoinsExpectedSum.minNumberOfCoinsForChange(14, new int[]{5, 6, 10});
        System.out.println(minCoins);
    }

    @Test
    @DisplayName("No Solution - AlgoExpert")
    void minNumberOfCoinsForChange_2AlgoExpert() {
        final int minCoins = Q14_MinCoinsExpectedSum.minCoinsAlgoExpertSolution(14, new int[]{5, 6, 10});
        System.out.println(minCoins);
    }

    @Test
    @DisplayName("Solution - 15")
    void minNumberOfCoinsForChange_3() {
        final int minCoins = Q14_MinCoinsExpectedSum.minNumberOfCoinsForChange(15, new int[]{5, 6, 10});
        Assertions.assertEquals(2, minCoins);
    }

    @Test
    @DisplayName("Solution - 15 - AlgoExpert")
    void minNumberOfCoinsForChange_3AlgoExpert() {
        final int minCoins = Q14_MinCoinsExpectedSum.minCoinsAlgoExpertSolution(15, new int[]{5, 4, 10});
        Assertions.assertEquals(2, minCoins);
    }
}