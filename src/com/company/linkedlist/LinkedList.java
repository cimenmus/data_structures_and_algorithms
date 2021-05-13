package com.company.linkedlist;

/**
 * https://www.programiz.com/dsa/linked-list
 * https://www.programiz.com/dsa/linked-list-operations
 * https://afteracademy.com/blog/types-of-linked-list-and-operation-on-linked-list
 *
 * Space Complexity: O(n)
 * Time Complexity:
 *                  Worst case      Average Case
 * Search           O(n)            O(n)
 * Insert           O(1)            O(1)
 * Deletion         O(1)            O(n)
 */
public class LinkedList {

    public Node head;

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
