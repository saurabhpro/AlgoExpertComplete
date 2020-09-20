package interviewq.easy;

import java.util.ArrayList;
import java.util.List;

public class Q3_BSTPathSum {
    /**
     * O (n) time |
     * O (n) space ( O (n) for maximum leaf nodes so n/2 branch sums + O (log n) for storing path height of tree recursions)
     */
    public static List<Integer> branchSums(BinaryTree root) {

        final var result = new ArrayList<Integer>();
        int currentSum = 0;

        findAllBranchSums(root, currentSum, result);

        return result;
    }

    private static void findAllBranchSums(BinaryTree root, int currentSum, List<Integer> result) {
        if (root == null) {
            return;
        }

        currentSum += root.value;

        final boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf) {
            result.add(currentSum);
            return;
        }

        findAllBranchSums(root.left, currentSum, result);
        findAllBranchSums(root.right, currentSum, result);
    }

    public static void main(String[] args) {
        /*
         *               1
         *              /  \
         *             2    3
         *            / \   / \
         *          4   5  6   7
         *         / \  /
         *        8  9  10
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
        binaryTree.left.right.left = new BinaryTree(10);

        final var sums = branchSums(binaryTree);
        System.out.println(sums);

    }

    // This is the class of the input root.
    static class BinaryTree {
        final int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
