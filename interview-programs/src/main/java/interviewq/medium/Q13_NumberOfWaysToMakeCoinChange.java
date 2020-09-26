package interviewq.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q13_NumberOfWaysToMakeCoinChange {

    // O(n d) time | O(n) space where d is number of coins and n is expected sum
    public static int numberOfWaysToMakeChange(int expectedSum, int[] coins) {
        int[] ways = new int[expectedSum + 1];
        ways[0] = 1;    // basically the way where we don't use any coin - we will count that as 1

        Arrays.stream(coins)
                .forEach(
                        coin -> IntStream.rangeClosed(1, expectedSum)
                                .filter(amount -> amount >= coin)
                                .forEachOrdered(amount -> ways[amount] += ways[amount - coin])
                );

        return ways[expectedSum];
    }
}
