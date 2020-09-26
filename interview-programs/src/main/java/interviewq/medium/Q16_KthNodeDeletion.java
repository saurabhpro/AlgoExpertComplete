package interviewq.medium;

import java.util.ArrayList;
import java.util.List;

public class Q16_KthNodeDeletion {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList fast = head;
        LinkedList slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
    }

   public static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

        public void addMany(int[] values) {
            LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int val : values) {
                current.next = new LinkedList(val);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }

    public static void main(String[] args) {
        LinkedList test = new LinkedList(0);
        test.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        removeKthNodeFromEnd(test, 10);

        final var nodesInArray = test.getNodesInArray();
        System.out.println(nodesInArray);
    }

}
