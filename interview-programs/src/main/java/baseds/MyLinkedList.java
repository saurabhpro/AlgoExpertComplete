package baseds;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    public int value;
    public MyLinkedList next;

    public MyLinkedList(int value) {
        this.value = value;
    }

    public void addMany(int[] values) {
        MyLinkedList current = this;
        while (current.next != null) {
            current = current.next;
        }
        for (int val : values) {
            current.next = new MyLinkedList(val);
            current = current.next;
        }
    }

    public List<Integer> getNodesInArray() {
        List<Integer> nodes = new ArrayList<>();
        MyLinkedList current = this;

        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }

        return nodes;
    }

    public MyLinkedList getNthNode(int n) {
        int counter = 1;
        MyLinkedList current = this;

        while (counter < n) {
            current = current.next;
            counter++;
        }

        return current;
    }

    public void print() {
        MyLinkedList root = this;

        while (root.next != null) {
            System.out.print(root.value + "->");
            root = root.next;
        }
        System.out.println(root.value);
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "value=" + value +
                '}';
    }
}