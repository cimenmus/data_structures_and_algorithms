package com.company.tree.binarysearchtree;

import com.company.tree.binarytree.BinaryTree;

public class BinarySearchTree extends BinaryTree {

    void deleteValue(int value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, int value) {
        if (root == null)
            return root;

        // Find the node to be deleted
        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);
        else {
            // If the node is with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    // Find the inorder successor
    int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }
}
