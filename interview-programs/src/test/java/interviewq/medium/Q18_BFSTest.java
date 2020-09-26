package interviewq.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Q18_BFSTest {
    private Q18_BFS.Node graph;
    private List<String> expected;

    @BeforeEach
    void init() {
        graph = new Q18_BFS.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");

        expected = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
    }

    @Test
    void bfsRecursive() {

        List<String> str = new ArrayList<>();
        final List<String> strings = graph.breadthFirstSearch(str);

        Assertions.assertEquals(expected, strings);
    }

}