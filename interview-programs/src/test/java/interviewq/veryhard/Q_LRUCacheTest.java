package interviewq.veryhard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q_LRUCacheTest {

    private static final int NOT_FOUND = -1;

    @Test
    void main() {
        var cache = new Q_LRUCache.LRUCache<String>(3);
        cache.insertKeyValuePair("b", 2);
        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("c", 3);

        // c3 a1 b2
        var mostRecentKey = cache.getMostRecentKey();
        assertEquals("c", mostRecentKey);

        //a1
        var value = cache.getValueFromKey("a");
        assertEquals(1, value.value);

        //a1 -> a1 c3 b2
        mostRecentKey = cache.getMostRecentKey();
        assertEquals("a", mostRecentKey);

        // eject b2 as least recently used -> d4 a1 c3
        cache.insertKeyValuePair("d", 4);
        mostRecentKey = cache.getMostRecentKey();
        assertEquals("d", mostRecentKey);

        value = cache.getValueFromKey("b"); // already ejected
        Assertions.assertFalse(value.found);

        // reinsert a ->  a5 d4 c3
        cache.insertKeyValuePair("a", 5);

        mostRecentKey = cache.getMostRecentKey();
        assertEquals("a", mostRecentKey);

        value = cache.getValueFromKey("a");
        assertEquals(5, value.value);

        // check if c3 is still there
        value = cache.getValueFromKey("c");
        assertEquals(3, value.value);
    }

    @Test
    void test2() {
        var cache = new Q_LRUCache.LRUCache<String>(4);
        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("b", 2);
        cache.insertKeyValuePair("c", 3);
        cache.insertKeyValuePair("d", 4);

        //a1
        var value = cache.getValueFromKey("a");
        assertEquals(1, value.value);

        cache.insertKeyValuePair("e", 5);

        value = cache.getValueFromKey("a");
        assertEquals(1, value.value);

        value = cache.getValueFromKey("b");
        assertEquals(NOT_FOUND, value.value);

        value = cache.getValueFromKey("c");
        assertEquals(3, value.value);

        cache.insertKeyValuePair("f", 5);

        value = cache.getValueFromKey("c");
        assertEquals(3, value.value);

        value = cache.getValueFromKey("d");
        assertEquals(NOT_FOUND, value.value);

        cache.insertKeyValuePair("g", 5);

        value = cache.getValueFromKey("e");
        assertEquals(NOT_FOUND, value.value);

        value = cache.getValueFromKey("a");
        assertEquals(1, value.value);

        value = cache.getValueFromKey("c");
        assertEquals(3, value.value);

        value = cache.getValueFromKey("f");
        assertEquals(5, value.value);

        value = cache.getValueFromKey("g");
        assertEquals(5, value.value);

    }
}