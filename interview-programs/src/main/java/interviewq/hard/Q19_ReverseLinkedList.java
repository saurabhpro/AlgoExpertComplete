package interviewq.hard;

import baseds.MyLinkedList;

public class Q19_ReverseLinkedList {

    // O(n) time | O(1) space
    public static MyLinkedList reverseMyLinkedList(MyLinkedList head) {

        MyLinkedList prev = null;
        MyLinkedList current = head;

        while (current != null) {
            MyLinkedList newCurrent = current.next;

            current.next = prev;
            prev = current;
            current = newCurrent;
        }

        head = prev;
        return head;
    }

    // Tail Recursive function to reverse the given linked list.
    // It reverses the given linked list by fixing the head pointer first and then
    // .next pointers of very node in reverse order
    private static MyLinkedList reverseMyLinkedListRecursiveTail(MyLinkedList curr, MyLinkedList prev, MyLinkedList head) {
        // base case:  If last node mark it head
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;

            return head;
        }

        // Save curr->next node for recursive call
        MyLinkedList currNew = curr.next;
        // fix current node(Nodes following it are already fixed)
        curr.next = prev;

        // recur for next node and pass current node as previous node
        head = reverseMyLinkedListRecursiveTail(currNew, curr, head);

        return head;
    }

    // The function to reverse the given linked list which takes a
    // reference to the head node
    public static MyLinkedList reverseMyLinkedListRecursiveTail(MyLinkedList head) {
        return reverseMyLinkedListRecursiveTail(head, null, head);
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(0);
        list.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        list.print();
        list = reverseMyLinkedList(list);
        list.print();

        list = reverseMyLinkedListRecursiveTail(list);
        list.print();
    }
}