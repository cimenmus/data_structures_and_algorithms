package com.company.tree.binarytree;

public class BinaryTree {

    public Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int key) {
        root = new Node(key);
    }

    public static class Node {

        public int value;
        public Node left, right;

        public Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }
}
