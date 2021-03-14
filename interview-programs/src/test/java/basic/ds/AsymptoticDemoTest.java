package basic.ds;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class AsymptoticDemoTest {

    private final long[] arr = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final long[] arrBig;

    AsymptoticDemoTest() {
        Random random = new Random();
        arrBig = random.longs(1000).toArray(); // Creates 1000-element array.
    }

    @Test
    void testConstantO10() {
        AsymptoticDemo ad = new AsymptoticDemo();
        long runtime = ad.testConstantTime(arr);
        System.out.println("Constant Time for " + arr.length + " length = " + runtime);
    }

    @Test
    void testConstantO1000() {
        AsymptoticDemo ad = new AsymptoticDemo();
        long runtime = ad.testConstantTime(arrBig);
        System.out.println("Constant Time for " + arrBig.length + " length = " + runtime);
    }

    @Test
    void testLinearO10() {
        AsymptoticDemo ad = new AsymptoticDemo();
        long runtime = ad.testLinearTime(arr);
        System.out.println("Linear Time for " + arr.length + " length = " + runtime);
    }

    @Test
    void testLinearO1000() {
        AsymptoticDemo ad = new AsymptoticDemo();
        long runtime = ad.testLinearTime(arrBig);
        System.out.println("Linear Time for " + arrBig.length + " length = " + runtime);
    }

    @Test
    void testExponentialO10() {
        AsymptoticDemo ad = new AsymptoticDemo();
        long runtime = ad.testExponentialTime(arr);
        System.out.println("Exponential Time for " + arr.length + " length = " + runtime);
    }

    @Test
    void testExponentialO1000() {
        AsymptoticDemo ad = new AsymptoticDemo();
        long runtime = ad.testExponentialTime(arrBig);
        System.out.println("Exponential Time for " + arrBig.length + " length = " + runtime);
    }
}
