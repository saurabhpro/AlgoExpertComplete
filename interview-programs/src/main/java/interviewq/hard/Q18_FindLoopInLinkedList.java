package interviewq.hard;

import baseds.MyLinkedList;

public class Q18_FindLoopInLinkedList {
    // floyd algo hare-tortoise
    public static boolean hasLoop(MyLinkedList head) {
        boolean hasLoop = false;
        MyLinkedList hare = head.next.next;
        MyLinkedList tortoise = head.next;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (hare == tortoise) {
                break;
            }
        }

        if (hare != null && hare.next != null) {
            hasLoop = true;
        }

        return hasLoop;
    }


    /**
     * assume that we have a loop for sure
     * <p>
     * O(n) time | O(1) space
     */
    public static MyLinkedList findStartOfLoop(MyLinkedList head) {
        MyLinkedList hare = head.next;
        MyLinkedList tortoise = head.next.next;

        while (tortoise != hare) {
            hare = hare.next;
            tortoise = tortoise.next.next;
        }

        // has loop

        tortoise = head;

        while (hare != tortoise) {
            tortoise = tortoise.next;
            hare = hare.next;
        }

        return tortoise;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        list.getNthNode(10).next = list.getNthNode(5);

        boolean hasLoop = hasLoop(list);
        System.out.println(hasLoop);
        final MyLinkedList start = findStartOfLoop(list);
        System.out.println(start);

        list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        list.print();
        hasLoop = hasLoop(list);
        System.out.println(hasLoop);
    }
}
