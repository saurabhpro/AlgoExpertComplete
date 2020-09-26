package interviewq.medium;

public class Q7_BSTConstruction {

    public static void main(String[] args) {

        BST tree = new BST(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(13);
        tree.insert(22);
        tree.insert(1);
        tree.insert(14);

        // print the tree
        tree.inorder();

        // op 1 - insert 12
        tree.insert(12);
        tree.inorder();

        // op 2 - contains 13
        System.out.println(tree.contains(13));

        // op 3 - remove 10
        tree.remove(10);
        tree.inorder();
    }

    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        /**
         * check for small or large -> if yes then simply use the left/right pointers
         * and call the method recursively
         * NOTE: This BST doesn't allow duplicates
         *
         * @param value to be inserted
         */
        // Average case => O(log n) time | O(log n) space
        // Worse case => O(n) time | O(n) space
        public void insert(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insert(value);
                }
            } else if (value > this.value) {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insert(value);
                }
            }
        }

        // Average case => O(log n) time | O(1) space
        // Worse case => O(n) time | O(1) space
        public void insertIterative(int value) {
            BST currentNode = this;

            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else if (value > currentNode.value) {
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        /**
         * check for small or large -> if yes then simply use the left/right pointers
         * and call the method recursively
         *
         * @param value to be found
         * @return true if BST contains the {@code value}
         */
        // Average case => O(log n) time | O(log n) space
        // Worse case => O(n) time | O(n) space
        public boolean contains(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    return false;
                }

                return this.left.contains(value);

            } else if (value > this.value) {
                if (this.right == null) {
                    return false;
                }

                return this.right.contains(value);
            } else {
                return true;
            }
        }

        // Average case => O(log n) time | O(1) space
        // Worse case => O(n) time | O(1) space
        public boolean containsIterative(int value) {
            BST currentNode = this;
            boolean rv = false;

            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    rv = true;
                    break;
                }
            }

            return rv;
        }

        /**
         * Theory -
         * 1) Node to be deleted is leaf: Simply remove from the tree.
         * 2) Node to be deleted has only one child: Copy the child to the node and delete the child
         * 3) Node to be deleted has two children: Find inorder successor of the node.
         * <span>
         * Copy contents of the inorder successor to the node and delete the inorder successor.
         * Note that inorder predecessor can also be used.
         * </span>
         * <p>
         * Code Approach -
         * 1. First Recursively find the deleteValue
         * 2. use parent to decide which node to swap
         * 3. make that branch null
         */
        public BST remove(int value) {
            remove(value, null);

            return this;
        }


        private void remove(int deleteValue, BST parent) {
            BST currentNode = this;

            if (deleteValue < this.value) {
                if (currentNode.left != null) {
                    parent = currentNode;
                    currentNode.left.remove(deleteValue, parent);
                }
            } else if (deleteValue > currentNode.value) {
                if (currentNode.right != null) {
                    parent = currentNode;
                    currentNode.right.remove(deleteValue, parent);
                }
            } else {
                // case 3 - has both children - find inorder successor or predecessor and replace itself by it.
                if (currentNode.right != null && currentNode.left != null) {
                    final int inorderSuccessor = currentNode.right.minValue();
                    currentNode.value = inorderSuccessor;

                    // Delete the inorder successor
                    currentNode.right.remove(inorderSuccessor, currentNode);
                }
                // the deletion of root use cases
                // 1 - only one node in tree - don't delete or set value to null
                // 2 - only left child in tree - overwrite the current node with its left
                // 3 - only right child in tree - overwrite the current node with its right
                else if (parent == null) {
                    if (currentNode.left != null) {
                        currentNode.value = currentNode.left.value;
                        currentNode.right = currentNode.left.right;
                        currentNode.left = currentNode.left.left;
                    } else if (currentNode.right != null) {
                        currentNode.value = currentNode.right.value;
                        currentNode.right = currentNode.right.right;
                        currentNode.left = currentNode.right.left;
                    } else {
                        // single node tree // do nothing
                        // or
                        currentNode.value = 0;
                    }
                }
                // case 1 - node to be deleted is a leaf node - both children are null
                // case 2 - node has at most one child - replace current by its child
                else if (parent.left == currentNode) {
                    if (currentNode.left == null) {
                        parent.left = currentNode.right;
                    } else {
                        parent.left = currentNode.left;
                    }
                } else if (parent.right == currentNode) {
                    if (currentNode.left == null) {
                        parent.right = currentNode.right;
                    } else {
                        parent.right = currentNode.left;
                    }
                }
            }
        }

        /**
         * node with two children: Get the inorder successor (smallest in the right subtree)
         */
        protected final int minValue() {
            BST currentNode = this;

            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }

            return currentNode.value;
        }

        protected final int minValueRecursive() {
            if (this.left == null) {
                return this.value;
            }

            return this.left.minValueRecursive();
        }

        public void inorder() {
            doInorder(this);
            System.out.println();
        }

        private void doInorder(BST node) {
            if (node == null) {
                return;
            }
            doInorder(node.left);
            System.out.print(node.value + " ");
            doInorder(node.right);
        }
    }
}
