package com.company.tree.binarysearchtree;

import com.company.tree.binarytree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Exercises {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = createBinarySearchTree();

        traverseInOrder(binarySearchTree.root);
        System.out.println();

        //System.out.println("is 5 available: " + search(binarySearchTree.root, 5));
        //System.out.println("is 7 available: " + search(binarySearchTree.root, 7));

        //System.out.println("Min value: " + getMinValue(binarySearchTree.root));
        //System.out.println("Max value: " + getMaxValue(binarySearchTree.root));
    }

    //region Traversing - DFS
    // DFS -> Deep First Search
    // Traverse Preorder: root-left-right
    public static void traversePreOrder(BinarySearchTree.Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // DFS -> Deep First Search
    // Traverse Inorder: left-root-right
    public static void traverseInOrder(BinarySearchTree.Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    // DFS -> Deep First Search
    // Traverse Postorder: left-right-root
    public static void traversePostOrder(BinarySearchTree.Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
    //endregion

    //region Traversing - BFS - Recursive
    // BFS -> Breadth First Search (also knows as Level Order)
    /*
    Time Complexity: O(n^2) in worst case.
    For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree.
    So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).

    Space Complexity: O(n) in worst case.
    For a skewed tree, printGivenLevel() uses O(n) space for call stack.
    For a Balanced tree, call stack uses O(log n) space, (i.e., height of the balanced tree).
     */
    public static void traverseLevelOrderRecursive(BinarySearchTree BinarySearchTree){
        int height = calculateHeight(BinarySearchTree.root);
        for(int i = 0; i < height; i++){
            levelOrderTraversal(BinarySearchTree.root, i);
        }
    }

    public static int calculateHeight(BinarySearchTree.Node node) {
        if (node == null) {
            return 0;
        }
        int lhs = calculateHeight(node.left);
        int rhs = calculateHeight(node.right);
        return Math.max(lhs, rhs) + 1;
    }

    public static void levelOrderTraversal(BinarySearchTree.Node node, int level){
        if(node == null){
            return;
        }
        if(level == 0){
            System.out.print(node.value + " ");
        }else{
            levelOrderTraversal(node.left, level-1);
            levelOrderTraversal(node.right, level-1);
        }
    }
    //endregion

    //region Traversing - BFS - Iterative
    /*
    Time Complexity: O(n) where n is number of nodes in the binary tree
    Space Complexity: O(n) where n is number of nodes in the binary tree
     */
    public static void traverseLevelOrderIterative(BinarySearchTree.Node root){
        if(root == null){
            return;
        }
        Queue<BinarySearchTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinarySearchTree.Node node = queue.poll();
            System.out.print(node.value + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    //endregion

    //region Inserting
    public static BinarySearchTree.Node insert(BinarySearchTree.Node node, int value) {
        if (node == null){
            return new BinarySearchTree.Node(value);
        }
        if (value < node.value){
            node.left = insert(node.left, value);
        } else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }
    //endregion

    //region Searching
    public static boolean search(BinarySearchTree.Node node, int value) {
        if (node == null){
            return false;
        }
        if (node.value == value){
            return true;
        }
        return node.value < value ? search(node.left, value) : search(node.right, value);
    }
    //endregion

    private static boolean isFullBinarySearchTree(BinarySearchTree.Node node) {

        // Checking tree emptiness
        if (node == null)
            return true;

        // Checking the children
        if (node.left == null && node.right == null)
            return true;

        if (node.left != null && node.right != null)
            return isFullBinarySearchTree(node.left) && isFullBinarySearchTree(node.right);

        return false;
    }

    private static int getNodeCount(BinarySearchTree.Node node) {
        if (node == null)
            return 0;
        return 1 + getNodeCount(node.left) + getNodeCount(node.right);
    }

    private static int getMinValue(BinarySearchTree.Node node) {
        int min = node.value;
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
    }

    private static int getMaxValue(BinarySearchTree.Node node) {
        int min = node.value;
        while (node.right != null) {
            min = node.right.value;
            node = node.right;
        }
        return min;
    }

    private static boolean isCompleteBinarySearchTree(BinarySearchTree.Node root, int index, int numberNodes) {

        // Check if the tree is empty
        if (root == null)
            return true;

        if (index >= numberNodes)
            return false;

        return (isCompleteBinarySearchTree(root.left, 2 * index + 1, numberNodes)
                && isCompleteBinarySearchTree(root.right, 2 * index + 2, numberNodes));
    }

    private static BinarySearchTree createBinarySearchTree(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new BinaryTree.Node(8);
        insert(tree.root,3);
        insert(tree.root,1);
        insert(tree.root,6);
        insert(tree.root,7);
        insert(tree.root,10);
        insert(tree.root,14);
        insert(tree.root,4);
        return tree;
    }
}
