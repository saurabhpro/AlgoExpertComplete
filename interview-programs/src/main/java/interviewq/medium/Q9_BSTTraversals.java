package interviewq.medium;

import java.util.Collections;
import java.util.List;

import static interviewq.medium.Q7_BSTConstruction.BST;

public class Q9_BSTTraversals {

    // O(n) time | O(n) space
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return Collections.emptyList();
        }

        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);

        return array;
    }

    // O(n) time | O(n) space
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return Collections.emptyList();
        }

        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);

        return array;
    }

    // O(n) time | O(n) space
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return Collections.emptyList();
        }

        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);

        return array;
    }
}