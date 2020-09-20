package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q13_PalindromeTest {

    @Test
    void isPalindrome() {
        final var res = Q13_Palindrome.isPalindrome("abcdcba");
        Assertions.assertTrue(res);
    }

    @Test
    void isPalindromeRecursive() {
        final var res = Q13_Palindrome.isPalindromeRecursive("abcdcba", 0);
        Assertions.assertTrue(res);
    }
}