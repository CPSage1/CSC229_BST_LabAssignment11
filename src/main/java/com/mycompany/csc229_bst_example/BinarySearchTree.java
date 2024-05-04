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
    // ToDo 1: complete InOrder Traversal
    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root != null) {
            doInOrder(root.getLeft());
            //Prints data of the current node
            System.out.print(root.getData() + " ");
            doInOrder(root.getRight());
        }
    }
    // ToDo 2: complete the pre-order travesal
    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    private void doPreOrder(BstNode root) {

        if (root != null) {
            //Prints data of the current node
            System.out.print(root.getData() + " ");
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }
    // ToDo 3: Find the height of a tree
    public int findHeight() {
        return getHeight(root);
    }
    //The helper method to find the height of the tree
    private int getHeight(BstNode node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        // Returns the max height of both left and right subtrees and the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //ToDo 4: complete getDepth of a node
    public int getDepth(BstNode node) {
        return findDepth(root, node, 0);
    }
    //The helper method to find the depth of the node
    private int findDepth(BstNode root, BstNode node, int depth) {
        if (root == null)
            return -1; //Node not found
        if (root == node)
            return depth; //Node found
        int leftDepth = findDepth(root.getLeft(), node, depth + 1);
        if (leftDepth != -1)
            return leftDepth; // If the node is found in the left subtree, return its depth
        return findDepth(root.getRight(), node, depth + 1); //searches right subtree
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }

    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.getData());//Prints the node
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);//Prints left subtree
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);//Prints right subtree
        }
    }
}
