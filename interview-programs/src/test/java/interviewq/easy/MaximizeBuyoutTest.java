package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximizeBuyoutTest {

    @Test
    void getMoneySpent() {
        int[] keyboards = {3, 1};
        int[] drives = {5, 3, 8};
        int budget = 10;
        int moneySpent = MaximizeBuyout.getMoneySpent(keyboards, drives, budget);

        Assertions.assertEquals(9, moneySpent);
    }

    @Test
    void getMoneySpentButNoProductPurchased() {
        int[] keyboards = {5};
        int[] drives = {4};
        int budget = 7;
        int moneySpent = MaximizeBuyout.getMoneySpent(keyboards, drives, budget);

        Assertions.assertEquals(-1, moneySpent);
    }
}