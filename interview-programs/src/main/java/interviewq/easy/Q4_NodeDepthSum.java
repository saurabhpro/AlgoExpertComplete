package interviewq.easy;

public class Q4_NodeDepthSum {


    public static int nodeDepths(BinaryTree root) {
        return getLevelNodeCount(root);
    }

    static int getLevelNodeCount(BinaryTree root) {

        int heightOfTree = height(root);
        int sumOfNodeDepth = 0;

        for (int lvl = 1; lvl <= heightOfTree; lvl++) {
            int noOfNodesOnLevel = getLevelNodes(root, lvl);
            System.out.println("Level = " + lvl + " has " + noOfNodesOnLevel + " nodes");
            sumOfNodeDepth += noOfNodesOnLevel * (lvl - 1);
        }

        return sumOfNodeDepth;
    }

    // nodes
    static int height(BinaryTree root) {
        if (root == null) {
            return -1;      // we take height as no of edges in between root and leave
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int getLevelNodes(BinaryTree root, int lvl) {
        if (root == null) {
            return 0;
        }

        if (lvl == 1) {
            return 1;
        }

        return getLevelNodes(root.left, lvl - 1) + getLevelNodes(root.right, lvl - 1);
    }

    public static void main(String[] args) {
        /*
         *               1
         *              /  \
         *             2    3
         *            / \   / \
         *          4   5  6   7
         *         / \
         *        8  9
         */

        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);

        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);

        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);

        final var sums = nodeDepths(binaryTree);

        System.out.println(sums);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}
