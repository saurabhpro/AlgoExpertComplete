package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Q6_DFSTest {
    private Q6_DFS.Node graph;
    private List<String> expected;

    @BeforeEach
    void init() {
        graph = new Q6_DFS.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");

        expected = List.of("A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H");
    }

    @Test
    void dfsRecursive() {

        List<String> str = new ArrayList<>();
        final List<String> strings = graph.depthFirstSearch(str);

        Assertions.assertEquals(expected, strings);
    }

    @Test
    void dfsIterative() {

        List<String> str = new ArrayList<>();
        final List<String> strings = graph.depthFirstSearchIterative(str);

        Assertions.assertEquals(expected, strings);
    }

}