package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q27_BalancedBracketsTest {

    @Test
    void balancedBrackets() {
        String input = "([])(){}(())()()";
        Assertions.assertTrue(Q27_BalancedBrackets.balancedBrackets(input));
    }

    @Test
    void balancedBrackets_2() {
        String input = "[((([])([]){}){}){}([])[]((())";
        Assertions.assertFalse(Q27_BalancedBrackets.balancedBrackets(input));
    }

    @Test
    void balancedBrackets_3() {
        String input = ")[]}";
        Assertions.assertFalse(Q27_BalancedBrackets.balancedBrackets(input));
    }
}