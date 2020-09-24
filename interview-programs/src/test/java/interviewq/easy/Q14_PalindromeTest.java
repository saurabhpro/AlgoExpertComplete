package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q14_PalindromeTest {

    @Test
    void isPalindrome() {
        final var res = Q14_Palindrome.isPalindrome("abcdcba");
        Assertions.assertTrue(res);
    }

    @Test
    void isPalindromeRecursive() {
        final var res = Q14_Palindrome.isPalindromeRecursive("abcdcba", 0);
        Assertions.assertTrue(res);
    }
}