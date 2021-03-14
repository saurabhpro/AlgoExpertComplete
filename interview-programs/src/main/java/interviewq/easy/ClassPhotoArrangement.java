package interviewq.easy;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ClassPhotoArrangement {

    // o (n log n) |  O(1)
    public static boolean findIfPhotoPossible(List<Integer> red, List<Integer> blue) {
        // among the two list essentially we want to find the tallest person as he will be placed in the second row

        red.sort(Collections.reverseOrder());
        blue.sort(Collections.reverseOrder());

        final String colorInFirstRow = red.get(0) < blue.get(0) ? "RED" : "BLUE";

        for (int i = 0; i < red.size(); i++) {

            int r = red.get(i);
            int b = blue.get(i);


            if ("RED".equals(colorInFirstRow)) {
                // means if red is in first row -> no value in red can be greater than blue row ppl
                if (r >= b) {
                    return false;
                }
            } else {
                if (b >= r) {
                    return false;
                }
            }
        }

        return true;
    }

    // less comparisons
    // O(n log n)  | O(1)
    public boolean classPhotos(List<Integer> red, List<Integer> blue) {

        red.sort(Collections.reverseOrder());
        blue.sort(Collections.reverseOrder());

        final String colorInFirstRow = red.get(0) < blue.get(0) ? "RED" : "BLUE";

        if ("RED".equals(colorInFirstRow)) {
            // means if red is in first row -> no value in red can be greater than blue row ppl
            return IntStream.range(0, red.size())
                    .noneMatch(i -> red.get(i) >= blue.get(i));
        } else {
            return IntStream.range(0, red.size())
                    .noneMatch(i -> blue.get(i) >= red.get(i));
        }
    }
}
