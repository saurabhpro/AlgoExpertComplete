package interviewq.easy;

import java.util.HashMap;
import java.util.Map;

public class Q7_NthFibonacci {

    public static int getNthFib(int n) {

        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, 0);
        result.put(2, 1);

        // here we consider 0 as first fibo number
        int rv = n == 0 ? 0 : getNthFibMemoized(n, result);

        result.forEach((k, v) -> System.out.println("[" + k + " -> " + v + "]"));
        return rv;
    }

    // O(n) time | O(n) space
    private static int getNthFibMemoized(int n, Map<Integer, Integer> result) {
        if (result.containsKey(n)) {
            return result.get(n);
        } else {
            final int res = getNthFibMemoized(n - 1, result) + getNthFibMemoized(n - 2, result);
            result.put(n, res);
            return res;
        }

    }

}
