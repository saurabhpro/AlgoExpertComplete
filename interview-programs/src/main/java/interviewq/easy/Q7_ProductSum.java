package interviewq.easy;

import java.util.List;

public class Q7_ProductSum {

    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> array) {
        int depth = 1;
        return productSum(array, depth);
    }

    /**
     * O(n) time | O(d) space
     * where n = total elements in array including sub-elements
     * d = is the greatest depth of special arrays
     */
    private static int productSum(List<?> array, int depth) {
        int res = 0;

        for (Object ob : array) {
            if (ob instanceof List) {
                final int depthLevel = depth + 1;
                res += depthLevel * productSum((List<?>) ob, depthLevel);
            }

            if (ob instanceof Integer) {
                res += (Integer) ob;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // 5 + 2 + (2 * (7 + -1)) + 3 + (2 * (6 + 3 * (-13 + 8) + 4))
        // 7 + 12 + 3 + 2 * (10 + -15)
        // 22 + -10
        // 12

        List<Object> m = List.of(5, 2, List.of(7, -1), 3, List.of(6, List.of(-13, 8), 4));
        final var productSum = productSum(m);
        System.out.println(productSum);
    }
}
