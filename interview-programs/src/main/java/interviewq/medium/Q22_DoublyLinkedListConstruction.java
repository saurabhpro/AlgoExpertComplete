package interviewq.medium;

// assuming we have an existing doubly link list
public class Q22_DoublyLinkedListConstruction {
    public Node head;
    public Node tail;

    /**
     * addFirst
     */
    public void setHead(Node node) {
        if (head == null) {
            tail = node;
            head = node;
            return;
        }

        insertBefore(head, node);
    }

    public void setTail(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
        }

        insertAfter(tail, node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        nodeToInsert.next = node;
        nodeToInsert.prev = node.prev;

        if (node.prev != null) {
            node.prev.next = nodeToInsert;
        }

        if (node == head) {
            head = nodeToInsert;
        }
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        nodeToInsert.next = node.next;
        nodeToInsert.prev = node;
        node.next = nodeToInsert;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
        int counter = 0;
        Node current = head;
        while (counter < position - 1 && current != null) {
            current = current.next;
            counter++;
        }

        if (current != null) {
            nodeToInsert.next = current.next;
            nodeToInsert.prev = current;

            current.next = nodeToInsert;
        }
    }

    public void removeNodesWithValue(int value) {
        Node current = head;
        while (current != null) {

            if (current.value == value) {
                remove(current);
            }

            current = current.next;
        }
    }

    public void remove(Node node) {
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
    }

    public boolean containsNodeWithValue(int value) {
        Node current = head;
        Node reverse = tail;

        while (current != null
                && current.value != value &&
                reverse.value != value) {
            current = current.next;
            reverse = reverse.prev;
        }

        return (current != null && reverse.value == value)
                || (reverse != null && reverse.value == value);
    }

    public Node getNodeWithValue(int value) {
        Node current = head;

        while (current != null && current.value != value) {
            current = current.next;
        }

        return current;
    }


    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }

    }

    public static void main(String[] args) {
        var dll = new Q22_DoublyLinkedListConstruction();
        System.out.print("Set 5 as head: ");
        dll.setHead(new Node(5));
        print(dll.head);

        System.out.print("Set 4 as head: ");
        dll.setHead(new Node(4));
        print(dll.head);

        System.out.print("Set 3 as head: ");
        dll.setHead(new Node(3));
        print(dll.head);

        System.out.print("Set 2 as head: ");
        dll.setHead(new Node(2));
        print(dll.head);

        System.out.print("Set 1 as head: ");
        dll.setHead(new Node(1));
        print(dll.head);

        System.out.print("Set 4 as head: ");
        dll.setHead(new Node(4));
        print(dll.head);

        System.out.print("Set 6 as tail: ");
        dll.setTail(new Node(6));
        print(dll.head);

        System.out.print("Insert 3 before 6: ");
        Node sex = dll.getNodeWithValue(6);
        dll.insertBefore(sex, new Node(3));
        print(dll.head);

        System.out.print("Insert 3 after 6: ");
        dll.insertAfter(sex, new Node(3));
        print(dll.head);

        System.out.print("Insert 3 at position 1: ");
        dll.insertAtPosition(1, new Node(3));
        print(dll.head);

        System.out.print("Remove all 3: ");
        dll.removeNodesWithValue(3);
        print(dll.head);

        System.out.print("Remove 2: ");
        Node two = dll.getNodeWithValue(2);
        dll.remove(two);
        print(dll.head);

        System.out.print("List contains 5: ");
        final boolean value = dll.containsNodeWithValue(5);
        System.out.println(value);
    }

    private static void print(Node node) {
        Node curr = node;

        while (curr.next != null) {
            System.out.print(curr + "->");
            curr = curr.next;
        }

        System.out.println(curr);

    }
}
