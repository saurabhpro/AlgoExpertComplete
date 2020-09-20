package trees;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Condition for bottom view are that the nodes shouldn't be at same level and same heightDistance
 * like here 5 and 13 have same heightDifference so we can only pick one
 */
public class BottomViewOfBST {
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
     * // making map of Horizontal Distance
     * Approach:
     * Create a map like, map where key is the horizontal distance
     * and value is a pair(a, b) where a is the value of the node and b is the height of the node.
     *
     * Perform a pre-order traversal of the tree. If the current node at a horizontal distance of h
     * is the first we’ve seen, insert it in the map.
     * Otherwise, compare the node with the existing one in map and if the height of the new node is greater,
     * update in the Map.
     * 0  -> 10, 5, 13
     * -1 -> 5
     * -2 -> 2
     * -3 -> 1
     * 1  -> 15, 14
     * 2  -> 22
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
        // bst.inorder(root);
        // System.out.println();
        // bst.printLevelOrder(root);

        final var bottomViewOfBST = bottomViewOfBST(root);
        System.out.println(bottomViewOfBST);
    }

    //expected = 1 2 5 14 22
    protected static List<Integer> bottomViewOfBST(MyBST.BSTNode root) {
        //verticalOrderTraversal(root);
        // if (root)
        //  hd = 0
        // else if (root.left)
        //  hd = hd - 1
        // else if (root.right)
        //  hd = hd + 1

        Map<Integer, Map.Entry<Integer, Integer>> result = new HashMap<>();

        // init call
        printBottomViewUtil(root, 1, 0, result);

        System.out.println(result);
        System.out.println("Bottom view of the given binary tree :\n");
        // print map
        //result.forEach((k, v) -> System.out.print(v.getKey() + " "));

        return result.values()
                .stream()
                .mapToInt(Map.Entry::getKey)
                .boxed()
                .collect(Collectors.toList());
    }

    // calculate Horizontal Distance using preOrderTraversal
    private static void printBottomViewUtil(MyBST.BSTNode root,
                                            int height,
                                            int hd,
                                            Map<Integer, Map.Entry<Integer, Integer>> result) {
        // Base case
        if (root == null)
            return;

        // If node for a particular
        // horizontal distance is not
        // present, add to the map.
        if (!result.containsKey(hd)) {
            result.putIfAbsent(hd, Map.entry(root.getValue(), height));
        }

        // Compare height for already
        // present node at similar horizontal
        // distance
        else {
            final Map.Entry<Integer, Integer> p = result.get(hd);
            // update the cursor with latest value of horizontal distance
            if (p.getValue() <= height) {
                result.put(hd, Map.entry(root.getValue(), height));
            }
        }

        // Recur for left subtree
        printBottomViewUtil(root.getLeft(), height + 1, hd - 1, result);

        // Recur for right subtree
        printBottomViewUtil(root.getRight(), height + 1, hd + 1, result);
    }

    static class MyBST {

        public MyBST.BSTNode root;

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

        // Iterative function to insert a key into BST.
        // Root is passed by reference to the function
        public MyBST.BSTNode insertIterative(MyBST.BSTNode root, int key) {
            // if tree is empty, create a new node and set root
            if (root == null) {
                return new MyBST.BSTNode(key);
            }

            // start with root node
            MyBST.BSTNode curr = root;

            // pointer to store parent node of current node
            MyBST.BSTNode parent = null;

            // traverse the tree and find parent node of key
            while (curr != null) {
                // update parent node as current node
                parent = curr;

                // if given key is less than the current node,
                // go to left subtree else go to right subtree
                if (key > curr.getValue()) {
                    curr = curr.getLeft();
                } else {
                    curr = curr.getRight();
                }
            }

            // construct a new node and assign to appropriate parent pointer
            // left has greater and right has <=
            if (key > parent.getValue()) {
                parent.setLeft(new MyBST.BSTNode(key));
            } else {
                parent.setRight(new MyBST.BSTNode(key));
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
        protected void printLevelOrder(MyBST.BSTNode root) {
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

        @Getter
        @Setter
        @ToString
        static class BSTNode {
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

}
