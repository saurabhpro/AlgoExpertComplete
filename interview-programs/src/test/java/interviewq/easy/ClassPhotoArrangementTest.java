package interviewq.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassPhotoArrangementTest {

    @Test
    void isPossible() {

        boolean actual = ClassPhotoArrangement.findIfPhotoPossible(
                Arrays.asList(5, 8, 1, 3, 4),
                Arrays.asList(6, 9, 2, 4, 5)
        );

        assertTrue(actual);
    }

    @Test
    void isNotPossible() {

        //"blueShirtHeights": [6, 9, 2, 4, 5],
        //"redShirtHeights": [5, 8, 1, 3, 4]

        boolean actual = ClassPhotoArrangement.findIfPhotoPossible(
                Arrays.asList(5, 8, 1, 3, 4),
                Arrays.asList(6, 9, 2, 4, 5)
        );

        assertTrue(actual);
    }

}