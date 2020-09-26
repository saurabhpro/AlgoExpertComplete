package interviewq.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://stackabuse.com/graphs-in-java-depth-first-search-dfs/
public class Q6_DFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        // O ( v + e ) time | O (v) space where v is all vertices of graph & e is edges of graph
        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);

            this.children
                    .forEach(node -> node.depthFirstSearch(array));

            return array;
        }

        public List<String> depthFirstSearchIterative(List<String> array) {
            Deque<Node> stack = new LinkedList<>();
            stack.push(this);

            while (!stack.isEmpty()) {
                Node element = stack.pop();
                array.add(element.name);

                List<Node> neighbours = element.children;
                for (int i = neighbours.size() - 1; i >= 0; i--) {
                    Node n = neighbours.get(i);

                    stack.push(n);
                }
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
