package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q28_LongestPalindromicSubstringTest {

    @Test
    void longestPalindromicSubstring() {
        final String palindromicSubstring = Q28_LongestPalindromicSubstring.longestPalindromicSubstringBruteForce("abaxyzzyxf");
        Assertions.assertEquals("xyzzyx", palindromicSubstring);
    }

    @Test
    void longestPalindromicSubstringFast() {
        final String palindromicSubstring = Q28_LongestPalindromicSubstring.longestPalindromicSubstring("abaxyzzyxf");
        Assertions.assertEquals("xyzzyx", palindromicSubstring);
    }

    @Test
    void longestPalindromicSubstring_2() {
        final String palindromicSubstring = Q28_LongestPalindromicSubstring.longestPalindromicSubstringBruteForce("a");
        Assertions.assertEquals("a", palindromicSubstring);
    }

    @Test
    void longestPalindromicSubstringFast_2() {
        final String palindromicSubstring = Q28_LongestPalindromicSubstring.longestPalindromicSubstring("a");
        Assertions.assertEquals("a", palindromicSubstring);
    }

    @Test
    void longestPalindromicSubstringFast_3() {
        final String palindromicSubstring = Q28_LongestPalindromicSubstring.longestPalindromicSubstring("z234a5abbba54a32z");
        Assertions.assertEquals("5abbba5", palindromicSubstring);
    }
}