package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Q1_TwoSumTest {

    @Test
    void twoNumberSum_v1_forLoop() {
        var array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        int[] output = Q1_TwoSum.twoNumberSum_v1_forLoop(array, targetSum);

        Assertions.assertEquals(2, output.length);
        System.out.println(Arrays.toString(output));

    }

    @Test
    void twoNumberSum_v2_hashMap() {
        var array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSum = 17;

        final int[] ints = Q1_TwoSum.twoNumberSum_v2_hashSet(array, targetSum);

        Assertions.assertEquals(2, ints.length);
        System.out.println(Arrays.toString(ints));
    }


    @Test
    void twoNumberSum_v3_pointers() {
        var array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSum = 17;

        final int[] ints = Q1_TwoSum.twoNumberSum_v3_pointers(array, targetSum);

        Assertions.assertEquals(2, ints.length);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * ** staring **
     * [16299, 7380]
     * v1 took 57ms
     * [4779, 18900]
     * v2 took 19ms
     * v3 Sorted in 517ms
     * [1, 23678]
     * v3 took 547ms
     */
    @Test
    void performanceOfAllApproaches() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 1000001; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        int targetSum = 23679;

        final int[] array = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        long time = System.currentTimeMillis();
        System.out.println("** staring **");
        int[] output = Q1_TwoSum.twoNumberSum_v1_forLoop(array, targetSum);
        System.out.println(Arrays.toString(output));
        System.out.println("v1 took " + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        output = Q1_TwoSum.twoNumberSum_v2_hashSet(array, targetSum);
        System.out.println(Arrays.toString(output));
        System.out.println("v2 took " + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        output = Q1_TwoSum.twoNumberSum_v3_pointers(array, targetSum);
        System.out.println(Arrays.toString(output));
        System.out.println("v3 took " + (System.currentTimeMillis() - time) + "ms");
    }
}