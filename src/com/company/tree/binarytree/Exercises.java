package com.company.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Exercises {

    public static void main(String[] args) {
        BinaryTree binaryTree = createBinaryTree();

        System.out.println("\nDFS preOrder:");
        traversePreOrder(binaryTree.root);

        System.out.println("\n\nDFS inOrder:");
        traverseInOrder(binaryTree.root);

        System.out.println("\n\nDFS postOrder:");
        traversePostOrder(binaryTree.root);

        System.out.println("\n\nBFS - Recursive:");
        traverseLevelOrderRecursive(binaryTree);

        System.out.println("\n\nBFS - Iterative:");
        traverseLevelOrderIterative(binaryTree.root);

        System.out.println("\n\nInsert:");
        insert(binaryTree.root, 5);
        traverseLevelOrderIterative(binaryTree.root);
    }

    //region Traversing - DFS
    // DFS -> Deep First Search
    // Traverse Preorder: root-left-right
    public static void traversePreOrder(BinaryTree.Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // DFS -> Deep First Search
    // Traverse Inorder: left-root-right
    public static void traverseInOrder(BinaryTree.Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    // DFS -> Deep First Search
    // Traverse Postorder: left-right-root
    public static void traversePostOrder(BinaryTree.Node node) {
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
    public static void traverseLevelOrderRecursive(BinaryTree binaryTree){
        int height = calculateHeight(binaryTree.root);
        for(int i = 0; i < height; i++){
            levelOrderTraversal(binaryTree.root, i);
        }
    }

    public static int calculateHeight(BinaryTree.Node node) {
        if (node == null) {
            return 0;
        }
        int lhs = calculateHeight(node.left);
        int rhs = calculateHeight(node.right);
        return Math.max(lhs, rhs) + 1;
    }

    public static void levelOrderTraversal(BinaryTree.Node node, int level){
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
    public static void traverseLevelOrderIterative(BinaryTree.Node root){
        if(root == null){
            return;
        }
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree.Node node = queue.poll();
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
    public static BinaryTree.Node insert(BinaryTree.Node node, int value) {
        if (node == null){
            return new BinaryTree.Node(value);
        }
        if (value < node.value){
            node.left = insert(node.left, value);
        } else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }
    //endregion

    boolean isFullBinaryTree(BinaryTree.Node node) {

        // Checking tree emptiness
        if (node == null)
            return true;

        // Checking the children
        if (node.left == null && node.right == null)
            return true;

        if (node.left != null && node.right != null)
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);

        return false;
    }

    int getNodeCount(BinaryTree.Node node) {
        if (node == null)
            return 0;
        return 1 + getNodeCount(node.left) + getNodeCount(node.right);
    }

    boolean isCompleteBinaryTree(BinaryTree.Node root, int index, int numberNodes) {

        // Check if the tree is empty
        if (root == null)
            return true;

        if (index >= numberNodes)
            return false;

        return (isCompleteBinaryTree(root.left, 2 * index + 1, numberNodes)
                && isCompleteBinaryTree(root.right, 2 * index + 2, numberNodes));
    }

    private static BinaryTree createBinaryTree(){
        BinaryTree tree = new BinaryTree();

        /*
                 1
                / \
               2   3
              /
             4
         */
        tree.root = new BinaryTree.Node(1);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(3);
        tree.root.left.left = new BinaryTree.Node(4);

        return tree;
    }

}
