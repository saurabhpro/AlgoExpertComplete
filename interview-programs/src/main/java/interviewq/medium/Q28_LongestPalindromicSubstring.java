package interviewq.medium;

public class Q28_LongestPalindromicSubstring {

    // O(n^3) time | O (1) space
    public static String longestPalindromicSubstringBruteForce(String str) {
        String longestSubstring = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length() - 1; j >= i; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    String s = str.substring(i, j + 1 > str.length() ? j : j + 1);
                    if (isPalindrome(s) && longestSubstring.length() < s.length()) {
                        longestSubstring = s;
                    }
                }
            }
        }

        return longestSubstring;
    }

    // this is an O(n) operation itself
    static boolean isPalindrome(String str) {
        StringBuilder s = new StringBuilder(str);
        return str.equals(s.reverse().toString());
    }

    // O(n^2) time | O (n) space for longest substring
    public static String longestPalindromicSubstring(String str) {
        int[] currentLong = new int[]{0, 1};

        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestSubstring(str, i - 1, i + 1);
            int[] even = getLongestSubstring(str, i - 1, i);

            int[] newLongest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;

            currentLong = currentLong[1] - currentLong[0] > newLongest[1] - newLongest[0]
                    ? currentLong
                    : newLongest;
        }

        return str.substring(currentLong[0], currentLong[1]);
    }

    private static int[] getLongestSubstring(String str, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                break;
            }
            leftIndex--;
            rightIndex++;
        }
        return new int[]{leftIndex + 1, rightIndex};
    }
}
