package basic.ds;

import java.util.Arrays;

public class AsymptoticDemo {

    public long testConstantTime(long[] arr) {
        long ms = System.currentTimeMillis();

        System.out.println("Constant Time Result: " + (1 + arr[0]));

        return System.currentTimeMillis() - ms;
    }

    public long testLinearTime(long[] arr) {
        long ms = System.currentTimeMillis();

        System.out.println("Linear Time Result: " + Arrays.stream(arr).sum());

        return System.currentTimeMillis() - ms;
    }

    public long testExponentialTime(long[] arr) {
        long ms = System.currentTimeMillis();
        String[] outputArr = new String[arr.length * arr.length];

        for (int i = 0; i < arr.length; i++) {
            outputArr[i] = ""; //init
            for (long l : arr) {
                outputArr[i] += "[" + arr[i] + "," + l + "]";
            }
            outputArr[i] += "\n";
        }
        //System.out.println("Exponential Time Result: "+ Arrays.toString(outputArr));

        return System.currentTimeMillis() - ms;
    }
}
