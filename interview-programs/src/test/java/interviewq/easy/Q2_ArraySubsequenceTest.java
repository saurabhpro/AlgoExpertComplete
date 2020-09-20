package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static interviewq.easy.Q2_ArraySubsequence.isValidSubsequenceForLoop;
import static interviewq.easy.Q2_ArraySubsequence.isValidSubsequenceWhileLoop;

class Q2_ArraySubsequenceTest {

    @Test
    void isValidSubsequence_one() {
        int a = 1;
        List<Integer> integerList = List.of(4, 3, 9, 66, -1, 1, 5);

        final boolean isValid = isValidSubsequenceForLoop(integerList, List.of(a));
        Assertions.assertTrue(isValid);
    }

    @Test
    void isValidSubsequence_same() {

        List<Integer> integerList = List.of(4, 3, 9, 66, -1, 1, 5);

        final boolean isValid = isValidSubsequenceForLoop(integerList, integerList);
        Assertions.assertTrue(isValid);
    }

    @Test
    void isValidSubsequence_containsAll() {

        List<Integer> integerList = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = List.of(1, 6, -1, 10, 22);

        boolean isValid = isValidSubsequenceForLoop(integerList, sequence);
        Assertions.assertFalse(isValid);

        integerList = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        sequence = List.of(5, 1, 22, 22, 25, 6, -1, 8, 10);
        isValid = isValidSubsequenceForLoop(integerList, sequence);
        Assertions.assertFalse(isValid);    // because subsequence order is wrong has 2 22's
    }


    @Test
    void isValidSubsequence_1() {

        List<Integer> array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = List.of(1, 6, -1, -1, 10);

        boolean validSubsequence = isValidSubsequenceWhileLoop(array, sequence);
        Assertions.assertFalse(validSubsequence);
    }
}