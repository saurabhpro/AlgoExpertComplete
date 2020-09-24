package interviewq.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q11_MinCoinsExpectedSum {

    // O(n d) time and O(n) space where n is the expected sum value
    public static int minCoinsAlgoExpertSolution(int expectedSum, int[] coins) {
        System.out.println("Target: " + expectedSum + " from " + Arrays.toString(coins));

        // array to store number of coins required for each index
        // dynamic programming without recursion
        int[] numOfCoinMemoryStore = new int[expectedSum + 1];

        Arrays.fill(numOfCoinMemoryStore, Integer.MAX_VALUE);
        numOfCoinMemoryStore[0] = 0;

        iterativeCoinSolution(coins, numOfCoinMemoryStore);

        // print for all indexes
        IntStream.range(1, numOfCoinMemoryStore.length)
                .mapToObj(i -> "Target " + i + ", minCoins = " + numOfCoinMemoryStore[i])
                .forEach(System.out::println);

        return numOfCoinMemoryStore[expectedSum] == Integer.MAX_VALUE ? -1 : numOfCoinMemoryStore[expectedSum];
    }

    private static void iterativeCoinSolution(int[] coins, int[] numOfCoinMemoryStore) {
        // systematically fill and reuse all remaining amount indexes
        for (int currentCoin : coins) {
            for (int amount = 0; amount < numOfCoinMemoryStore.length; amount++) {

                // only if we can get the current amount with our denomination
                if (amount >= currentCoin) {
                    final int remainingAmount = amount - currentCoin;
                    int newCount = Integer.MAX_VALUE;

                    // update only if we have a viable solution
                    if (numOfCoinMemoryStore[remainingAmount] != Integer.MAX_VALUE) {
                        newCount = numOfCoinMemoryStore[remainingAmount] + 1;
                    }

                    numOfCoinMemoryStore[amount] = Math.min(numOfCoinMemoryStore[amount], newCount);
                }
            }
        }
    }

    public static void main(String[] args) {
        final int minCoins = minNumberOfCoinsForChange(7, new int[]{1, 5, 10});
        System.out.println(minCoins);
    }


    public static int minNumberOfCoinsForChange(int expectedSum, int[] coins) {
        System.out.println("Target: " + expectedSum + " from " + Arrays.toString(coins));

        int[] dp = new int[expectedSum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        final int coins7 = minCoins(expectedSum, coins, dp);

        IntStream.range(1, dp.length)
                .mapToObj(i -> "Target " + i + ", minCoins = " + dp[i])
                .forEach(System.out::println);

        return coins7;
    }

    // gets the correct solution but not for all memory indexes - fails for all indexes where -1 case
    // O(n d) time and O(n) space where n is the expected sum value
    private static int minCoins(int expectedSum, int[] coins, int[] memory) {

        if (expectedSum == 0) return 0;

        // since we want to compare against minimum
        int minimumCoinCount = Integer.MAX_VALUE;

        for (int currentCoin : coins) {
            // find remaining
            final int remainingSum = expectedSum - currentCoin;

            if (remainingSum >= 0) {
                int newCount;
                // already in memory
                if (memory[remainingSum] != Integer.MAX_VALUE) {
                    newCount = memory[remainingSum];
                } else {
                    // recurse
                    newCount = minCoins(remainingSum, coins, memory);
                }

                final boolean resultPossible = newCount != -1;
                // we keep the IntegerMax for this comparison
                if (resultPossible && newCount + 1 < minimumCoinCount) {
                    // increase the count as we had some remaining sum
                    minimumCoinCount = newCount + 1;
                }
            }
        }

        memory[expectedSum] = minimumCoinCount;
        return memory[expectedSum] == Integer.MAX_VALUE ? -1 : memory[expectedSum];
    }

}
