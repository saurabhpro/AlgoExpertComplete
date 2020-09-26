package interviewq.easy;

import baseds.MyBST;

public class Q3_BSTMinDifferenceNode {
    static int closestMatch = -1;

    /**
     * Average Case: O(log (n)) time | O(1) space
     * Worse Case: O(n) time | O(1) space
     */
    public static int findClosestValueInBst(MyBST.BSTNode root, int target) {
        // denoting the minimum difference from the required target
        int min = Integer.MAX_VALUE;

        // closest key from the target in the tree
        int closestKey = -1;

        while (root != null) {
            int diff = Math.abs(root.getValue() - target);

            // here we use the min to check if its least
            if (diff < min) {
                min = diff;
                closestKey = root.getValue();
            }

            if (target < root.getValue()) {
                root = root.getLeft();
            } else if (target > root.getValue()) {
                root = root.getRight();
            } else {
                break;        // nothing can be closer to 0
            }
        }

        return closestKey;
    }

    /**
     * Average Case: O(log (n)) time | O(log (n)) space
     * Worse Case: O(n) time | O(n) space
     */
    public static int findClosestValueInBstRecursive(MyBST.BSTNode root, int target) {
        if (root == null) {
            return -1;
        }

        return findClosestValueInBst(root, target, root.getValue());
    }


    private static int findClosestValueInBst(MyBST.BSTNode root, int target, int closestMatch) {
        int newMin = Math.abs(root.getValue() - target);

        if (newMin < Math.abs(closestMatch - target)) {
            closestMatch = root.getValue();
        }

        if (target < root.getValue() && root.getLeft() != null) {
            return findClosestValueInBst(root.getLeft(), target, closestMatch);
        } else if (target > root.getValue() && root.getRight() != null) {
            return findClosestValueInBst(root.getRight(), target, closestMatch);
        } else {
            return closestMatch;
        }
    }


    /**
     * <pre>
     *              10
     *             /   \
     *            5     15
     *           / \    /  \
     *          2   5   13  22
     *         /          \
     *        1            14
     *
     * </pre>
     */
    public static void main(String[] args) {
        var bst = new MyBST();

        var root = new MyBST.BSTNode(10);
        bst.insert(root, 5);
        bst.insert(root, 15);
        bst.insert(root, 2);
        bst.insert(root, 5);
        bst.insert(root, 13);
        bst.insert(root, 22);
        bst.insert(root, 1);
        bst.insert(root, 14);

        // ascending order inorder
        bst.inorder(root);
        System.out.println();

        bst.printLevelOrder(root);

        findClosestValueInBst(root, 11);


    }
}
