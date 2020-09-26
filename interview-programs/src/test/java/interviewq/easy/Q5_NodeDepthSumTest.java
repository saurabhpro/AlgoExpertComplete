package interviewq.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Q5_NodeDepthSumTest {
    Q5_NodeDepthSum.BinaryTree binaryTree;

    @BeforeEach
    void setup() {
        /*
         *               1
         *              /  \
         *             2    3
         *            / \   / \
         *          4   5  6   7
         *         / \
         *        8  9
         */

        binaryTree = new Q5_NodeDepthSum.BinaryTree(1);

        binaryTree.left = new Q5_NodeDepthSum.BinaryTree(2);
        binaryTree.right = new Q5_NodeDepthSum.BinaryTree(3);

        binaryTree.left.left = new Q5_NodeDepthSum.BinaryTree(4);
        binaryTree.left.right = new Q5_NodeDepthSum.BinaryTree(5);
        binaryTree.right.left = new Q5_NodeDepthSum.BinaryTree(6);
        binaryTree.right.right = new Q5_NodeDepthSum.BinaryTree(7);

        binaryTree.left.left.left = new Q5_NodeDepthSum.BinaryTree(8);
        binaryTree.left.left.right = new Q5_NodeDepthSum.BinaryTree(9);

    }

    @Test
    void nodeDepths() {

        final var depths = Q5_NodeDepthSum.nodeDepths(binaryTree);
        System.out.println(depths);
    }

    @Test
    void getLevelNodeCount() {
    }

    @Test
    void height() {
        final var height = Q5_NodeDepthSum.height(binaryTree);
        System.out.println(height);
        // height can be the number of edges or no of nodes
        Assertions.assertEquals(3, height);
    }

    @Test
    void getLevelNodes() {
    }
}