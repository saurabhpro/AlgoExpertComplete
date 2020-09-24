package interviewq.easy;

public class Q14_Palindrome {

    // O(n) space solution | O(1) space
    public static boolean isPalindrome(String str) {
        boolean rv = true;

        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                rv = false;
                break;
            }
        }

        return rv;
    }

    /**
     * tail recursion might help in keeping the method stack space to O(1)
     * but that's completely compiler dependent
     */
    // O(n) space solution | O(n) space
    public static boolean isPalindromeRecursive(String str, int start) {
        final int end = (str.length() - 1) - start;
        if (start >= end) {
            return true;
        }

        return str.charAt(start) == str.charAt(end)
                && isPalindromeRecursive(str, start + 1);
    }

}
