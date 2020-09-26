package interviewq.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q18_BFS {

    static class Node {
        final String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        // O ( v + e ) time | O (v) space where v is all vertices of graph & e is edges of graph
        public List<String> breadthFirstSearch(List<String> resultArray) {

            final Queue<Node> queue = new LinkedList<>();
            queue.add(this);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                resultArray.add(current.name);

                queue.addAll(current.children);
            }

            return resultArray;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
