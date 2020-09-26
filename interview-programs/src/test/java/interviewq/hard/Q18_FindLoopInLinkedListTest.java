package interviewq.hard;

import baseds.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q18_FindLoopInLinkedListTest {

    @Test
    void hasLoopTrue() {
        MyLinkedList list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        list.getNthNode(10).next = list.getNthNode(5);

        boolean hasLoop = Q18_FindLoopInLinkedList.hasLoop(list);
        Assertions.assertTrue(hasLoop);
    }

    @Test
    void hasLoopFalse() {
        MyLinkedList list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        boolean hasLoop = Q18_FindLoopInLinkedList.hasLoop(list);
        Assertions.assertFalse(hasLoop);
    }

    @Test
    void findStartOfLoop() {
        MyLinkedList list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        list.getNthNode(10).next = list.getNthNode(5);

        final MyLinkedList start = Q18_FindLoopInLinkedList.findStartOfLoop(list);

        Assertions.assertEquals(4, list.getNthNode(5).value);
    }
}