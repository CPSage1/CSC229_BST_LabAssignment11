package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root != null) {
            doInOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            doInOrder(root.getRight());
        }
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    private void doPreOrder(BstNode root) {
        // ToDo 1: complete InOrder Traversal
        if (root != null) {
            System.out.print(root.getData() + " ");
            // ToDo 2: complete the pre-order travesal
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }

    public int findHeight() {
        return getHeight(root);
    }
    // ToDo 3: Find the height of a tree
    private int getHeight(BstNode node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node
        return findDepth(root, node, 0);
    }

    private int findDepth(BstNode root, BstNode node, int depth) {
        if (root == null)
            return -1;
        if (root == node)
            return depth;
        int leftDepth = findDepth(root.getLeft(), node, depth + 1);
        if (leftDepth != -1)
            return leftDepth;
        return findDepth(root.getRight(), node, depth + 1);
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }

    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.getData());
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);
        }
    }
}
