package interviewq.medium;

import org.junit.jupiter.api.Test;

class Q7_BSTConstructionTest {

    @Test
    void case1() {

        var tree = new Q7_BSTConstruction.BST(10);
        tree.insert(5);
        tree.insert(15);

        // print the tree
        tree.inorder();


        // op 3 - remove 5 15 10
        tree.remove(5);
        tree.inorder();

        tree.remove(15);
        tree.inorder();

        tree.remove(10);
        tree.inorder();
    }

    @Test
    void case2_parentNullButChildIsNot() {

        var tree = new Q7_BSTConstruction.BST(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        // print the tree
        tree.inorder();

        // op 3 - remove 1
        tree.remove(1);
        tree.inorder();
    }
}