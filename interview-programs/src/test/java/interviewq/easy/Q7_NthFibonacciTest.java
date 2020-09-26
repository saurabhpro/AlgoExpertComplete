package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q7_NthFibonacciTest {

    @Test
    void get5thFib() {
        // 0, 1, 1, 2, 3
        final var nthFib = Q7_NthFibonacci.getNthFib(5);
        Assertions.assertEquals(3, nthFib);
    }

    @Test
    void get6thFib() {
        // 0, 1, 1, 2, 3, 5
        final var nthFib = Q7_NthFibonacci.getNthFib(6);
        Assertions.assertEquals(5, nthFib);
    }

    @Test
    void get0thFib() {
        // 0 default
        final var nthFib = Q7_NthFibonacci.getNthFib(0);
        Assertions.assertEquals(0, nthFib);
    }

    @Test
    void get1thFib() {
        // 0, 1
        final var nthFib = Q7_NthFibonacci.getNthFib(1);
        Assertions.assertEquals(0, nthFib);
    }

    @Test
    void get8thFib() {
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        final var nthFib = Q7_NthFibonacci.getNthFib(8);
        Assertions.assertEquals(13, nthFib);
    }

    @Test
    void get15thFib() {
        final var nthFib = Q7_NthFibonacci.getNthFib(15);
        Assertions.assertEquals(377, nthFib);
    }

}