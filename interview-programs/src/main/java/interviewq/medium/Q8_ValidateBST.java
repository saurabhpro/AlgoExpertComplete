package interviewq.medium;

import static interviewq.medium.Q7_BSTConstruction.BST;

public class Q8_ValidateBST {
    public static void main(String[] args) {
        var tree = new BST(10);
        tree.insert(5);

        tree.inorder();

        final boolean validateBST = validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println(validateBST);
    }

    /**
     * O(n) time as we check all nodes
     * O(d) space for call stack of longest branch at any given time (if tree is unbalanced d = n)
     */
    public static boolean validateBST(BST root, int minValue, int maxValue) {
        /* an empty tree is BST or reached end*/
        if (root == null) {
            return true;
        }

        /* false if this node violates the min/max constraints */
        if (root.value < minValue || root.value >= maxValue) {
            return false;
        }

        return validateBST(root.left, minValue, root.value)
                && validateBST(root.right, root.value, maxValue);
    }
}
