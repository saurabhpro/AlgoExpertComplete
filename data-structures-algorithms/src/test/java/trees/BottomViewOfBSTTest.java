package trees;

import org.junit.jupiter.api.Test;

import static trees.BottomViewOfBST.MyBST;

class BottomViewOfBSTTest {

    @Test
    void bottomViewOfBST() {
        /*
        20
        /  \
       8     22
      / \    /  \
     5  3   4   25
       /     \
       10     14
       */
        var bst = new MyBST();

        var root = new MyBST.BSTNode(20);

        root.setLeft(new MyBST.BSTNode(8));
        root.setRight(new MyBST.BSTNode(22));

        root.getLeft().setLeft(new MyBST.BSTNode(5));
        root.getLeft().setRight(new MyBST.BSTNode(3));

        root.getRight().setLeft(new MyBST.BSTNode(4));
        root.getRight().setRight(new MyBST.BSTNode(25));

        root.getLeft().getRight().setLeft(new MyBST.BSTNode(10));
        root.getRight().getLeft().setRight(new MyBST.BSTNode(14));

        // ascending order inorder
        // bst.inorder(root);
        // System.out.println();
        //bst.printLevelOrder(root);

        BottomViewOfBST.bottomViewOfBST(root);
    }


    @Test
    void bottomViewOfBST_2() {
        var bst = new MyBST();

        var root = new MyBST.BSTNode(10);
        root.setLeft(new MyBST.BSTNode(20));
        root.setRight(new MyBST.BSTNode(30));

        root.getLeft().setLeft(new MyBST.BSTNode(40));
        root.getLeft().setRight(new MyBST.BSTNode(60));

        // ascending order inorder
        // bst.inorder(root);
        // System.out.println();
        //bst.printLevelOrder(root);

        BottomViewOfBST.bottomViewOfBST(root);
    }
}