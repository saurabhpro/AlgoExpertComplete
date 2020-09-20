package baseds;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MyBST {

    public MyBST() {
    }

    // Recursive function to insert a key into BST
    public MyBST.BSTNode insert(MyBST.BSTNode root, int key) {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new MyBST.BSTNode(key);
        }

        // if given key is less than the root node,
        // recur for left subtree
        if (key < root.value) {
            root.left = insert(root.left, key);
        }

        // else recur for right subtree
        else {
            // key >= root.data
            root.right = insert(root.right, key);
        }

        return root;
    }

    /**
     * Compute the "height" of a tree -- the number of
     * nodes along the longest path from the root node
     * down to the farthest leaf node.
     * A tree with no nodes has height 0
     */
    protected int height(MyBST.BSTNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * function to print level order traversal of tree
     */
    public void printLevelOrder(MyBST.BSTNode root) {
        int h = height(root);

        System.out.println("Height of BST: " + h);

        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    /**
     * Print nodes at the given level
     */
    void printGivenLevel(MyBST.BSTNode root, int level) {
        if (root == null)
            return;

        if (level == 1) {
            System.out.print(root.getValue() + " ");
        } else if (level > 1) {
            printGivenLevel(root.getLeft(), level - 1);
            printGivenLevel(root.getRight(), level - 1);
        }
    }

    // Function to perform inorder traversal of the tree
    // sorts the tree ascending
    public void inorder(MyBST.BSTNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    // Function to perform preorder traversal of the tree
    public void preorder(MyBST.BSTNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Getter
    @Setter
    @ToString
    public static class BSTNode {
        private final int value;
        // horizontal distance of the node
        private int hd;
        //left and right references
        private MyBST.BSTNode left;
        private MyBST.BSTNode right;

        public BSTNode(int value) {
            this.value = value;
            this.hd = Integer.MAX_VALUE;
        }
    }
}
