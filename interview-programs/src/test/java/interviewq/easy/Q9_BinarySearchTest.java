package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q9_BinarySearchTest {
    @Test
    void binarySearch() {
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};

        int res = Q9_BinarySearch.binarySearch(array, 33);

        Assertions.assertEquals(3, res);
    }

    @Test
    void binarySearch_notFound() {
        int[] array = {1, 5, 23, 111};

        int res = Q9_BinarySearch.binarySearch(array, 35);

        Assertions.assertEquals(-1, res);
    }
}