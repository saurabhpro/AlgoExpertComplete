package interviewq.easy;

import baseds.MyBST;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Q2_BSTMinDifferenceNodeTest {

    private static MyBST.BSTNode root;

    @BeforeAll
    static void setup() {
        var bst = new MyBST();

        root = new MyBST.BSTNode(10);
        bst.insert(root, 5);
        bst.insert(root, 15);
        bst.insert(root, 2);
        bst.insert(root, 5);
        bst.insert(root, 13);
        bst.insert(root, 22);
        bst.insert(root, 1);
        bst.insert(root, 14);
    }

    @Test
    void findClosestValueInBst() {
        final var actual = Q2_BSTMinDifferenceNode.findClosestValueInBst(root, 11);

        Assertions.assertEquals(10, actual);
    }

    @Test
    void findClosestValueInBstRecursive() {
        final var actual = Q2_BSTMinDifferenceNode.findClosestValueInBstRecursive(root, 11);

        Assertions.assertEquals(10, actual);
    }
}