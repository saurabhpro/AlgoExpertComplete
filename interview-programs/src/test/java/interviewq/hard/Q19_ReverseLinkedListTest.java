package interviewq.hard;

import baseds.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Q19_ReverseLinkedListTest {

    @Test
    void reverseMyLinkedList() {
        MyLinkedList list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        list = Q19_ReverseLinkedList.reverseMyLinkedList(list);

        Assertions.assertEquals(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), list.getNodesInArray());
    }

    @Test
    void reverseMyLinkedListRecursiveTail() {
        MyLinkedList list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        list = Q19_ReverseLinkedList.reverseMyLinkedListRecursiveTail(list);

        Assertions.assertEquals(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0), list.getNodesInArray());
    }
}