package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q_StringReverseTest {

    @Test
    void reverseWordsInString() {
        String actual = Q_StringReverse.reverseWordsInString("AlgoExpert is the best!");

        Assertions.assertEquals("best! the is AlgoExpert", actual);
    }

    @Test
    void reverseWordsInStringWithSpaces() {
        String actual = Q_StringReverse.reverseWordsInString("test        ");

        Assertions.assertEquals("        test", actual);
    }
}