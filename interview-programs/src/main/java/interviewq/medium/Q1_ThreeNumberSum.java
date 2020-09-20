package interviewq.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1_ThreeNumberSum {

    // the worse method is running three for loop

    // complexity => time = O(n ^ 2) | space = O(n) (if every single number is used in return list)
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        final List<Integer[]> rv = new ArrayList<>();
        final int size = array.length;

        // sort O(n log n)
        Arrays.sort(array);

        // O(n ^ 2)
        for (int i = 0; i < size - 2; i++) {
            int a = array[i];

            int left = i + 1;
            int right = size - 1;

            while (left < right) {
                int currentSum = a + array[left] + array[right];

                if (currentSum == targetSum) {
                    Integer[] validGroup = {a, array[left], array[right]};
                    rv.add(validGroup);

                    // move ahead and we know that the current right value is ok
                    // since if its sorted , the moving left means we need <= right value
                    left++;
                } else if (currentSum > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return rv;
    }

    public static List<Integer[]> threeNumberSumList(int[] array, int targetSum) {

        final List<Integer[]> rv = new ArrayList<>();
        final int size = array.length;

        final List<Integer> integers = Arrays.stream(array)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(integers);

        for (int i = 0; i < size - 2; i++) {
            int a = integers.get(i);

            int left = i + 1;
            int right = size - 1;

            while (left < right) {
                int b = integers.get(left);
                int c = integers.get(right);

                if (a + b + c == targetSum) {
                    Integer[] validGroup = {a, b, c};
                    rv.add(validGroup);
                    left++;
                } else if (a + b + c > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return rv;
    }
}