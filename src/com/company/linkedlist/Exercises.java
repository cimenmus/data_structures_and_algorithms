package com.company.linkedlist;

import java.util.Random;

public class Exercises {

    public static void main(String[] args) {

        LinkedList linkedList = createSampleList();

        //insertAtBeginning(linkedList, 8);
        //insertAtEnd(linkedList, 8);
        //insertAfter(linkedList);

        //deleteFromBeginning(linkedList);
        //deleteFromEnd(linkedList);
        //deleteAtPosition(linkedList, 1);

        //System.out.println("Length: " + getLengthIterative(linkedList));
        //System.out.println("Length: " + getLengthRecursive(linkedList, linkedList.head));
        //System.out.println("2nd Item: " + findValueByPositionIterative(linkedList, 2));
        //System.out.println("Contains value 2: " + searchValueIterative(linkedList, 2));

        //insertAtPosition(linkedList, 0, 8);
        //deleteNode(linkedList, new LinkedList.Node(3));
        //deleteValue(linkedList, 3);

        //sortAscendingIterative(linkedList);

        //searchingIterative(linkedList, 3);

        updateEvenNumbers(linkedList);

        traverse(linkedList);
    }

    //region Traversing
    private static void traverse(LinkedList linkedList){
        LinkedList.Node node = linkedList.head;
        while (node != null){
            System.out.print(node.value + " -->  ");
            node = node.next;
        }
        System.out.println();
    }

    private static int getLengthIterative(LinkedList linkedList){
        if (linkedList.head == null){
            return 0;
        }
        LinkedList.Node node = linkedList.head;
        int length = 1;
        while (node.next != null){
            length++;
            node = node.next;
        }
        return length;
    }

    public static int getLengthRecursive(LinkedList linkedList, LinkedList.Node node){
        if (node == null){
            return 0;
        }
        return getLengthRecursive(linkedList, node.next) + 1;
    }
    //endregion

    //region Insertion

    private static void insertAtBeginning(LinkedList linkedList, int value){
        LinkedList.Node newNode = new LinkedList.Node(value);
        newNode.next = linkedList.head;
        linkedList.head = newNode;
    }

    private static void insertAtEnd(LinkedList linkedList, int value){
        LinkedList.Node newNode = new LinkedList.Node(value);

        if (linkedList.head == null){
            linkedList.head = newNode;
            return;
        }

        LinkedList.Node lastNode = linkedList.head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    private static void insertAtPosition(LinkedList linkedList, int position, int value){
        LinkedList.Node newNode = new LinkedList.Node(value);
        LinkedList.Node node = linkedList.head;
        int index = 0;
        if (position == 0){
            newNode.next = linkedList.head;
            linkedList.head = newNode;
            return;
        }
        while (node != null){
            if (index == position - 1){
                LinkedList.Node nextNode = node.next;
                newNode.next = nextNode;
                node.next = newNode;
                return;
            } else {
                index++;
                node = node.next;
            }
        }
    }
    //endregion

    //region Deletion

    private static void deleteFromBeginning(LinkedList linkedList){
        if (linkedList.head == null){
            return;
        }
        linkedList.head = linkedList.head.next;
    }

    private static void deleteFromEnd(LinkedList linkedList){
        if (linkedList.head == null){
            return;
        }
        LinkedList.Node lastPreviousNode = linkedList.head;
        while (lastPreviousNode.next != null && lastPreviousNode.next.next != null){
            lastPreviousNode = lastPreviousNode.next.next;
        }
        lastPreviousNode.next = null;
    }

    private static void deleteAtPosition(LinkedList linkedList, int position){
        if (linkedList.head == null){
            return;
        }
        LinkedList.Node node = linkedList.head;
        for (int i = 0; node != null && i < position - 1; i++){
            node = node.next;
        }
        if (node == null || node.next == null) {
            return;
        }

        node.next = node.next.next;
    }

    private static void deleteNode(LinkedList linkedList, LinkedList.Node nodeToDelete) {
        LinkedList.Node node = linkedList.head;
        while (node != null){
            if (node.next.value == nodeToDelete.value){
                node.next = node.next.next;
            }
            else if (node.value == nodeToDelete.value){

            }
            else {
                node = nodeToDelete.next;
            }
        }
    }

    private static void deleteValue(LinkedList linkedList, int value){

        // Store head node
        LinkedList.Node temp = linkedList.head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.value == value) {
            linkedList.head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.value != value) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;

    }
    //endregion

    //region Updating
    private static void updateEvenNumbers(LinkedList linkedList){

        traverse(linkedList);

        LinkedList.Node node = linkedList.head;
        while(node != null) {
            if (node.value % 2 == 0){
                node.value *= 2;
            }
            node = node.next;
        }
    }
    //endregion

    //region Sorting
    private static void sortAscendingIterative(LinkedList linkedList){

        traverse(linkedList);

        LinkedList.Node current = linkedList.head;
        if(current == null) {
            return;
        }

        while(current != null) {
            LinkedList.Node index = current.next;

            while(index != null) {
                if(current.value > index.value) {
                    int temp = current.value;
                    current.value = index.value;
                    index.value = temp;
                }
                index = index.next;
            }

            current = current.next;
        }
    }
    //endregion

    //region Searching
    private static void searchingIterative(LinkedList linkedList, int value){
        LinkedList.Node node = linkedList.head;
        int position = 0;
        int indexOfSearchedItem = -1;
        while (node != null){
            if (node.value == value){
                indexOfSearchedItem = position;
                break;
            } else {
                node = node.next;
                position++;
            }
        }
        if (indexOfSearchedItem != -1){
            System.out.println("Item found at position: " + indexOfSearchedItem);
        } else {
            System.out.println("Item not found");
        }
    }
    // Time Complexity: O(n)
    private static int findValueByPositionIterative(LinkedList linkedList, int position){
        int index = 0;
        LinkedList.Node node = linkedList.head;
        while (node != null){
            if (index == position){
                return node.value;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    private static boolean searchValueIterative(LinkedList linkedList, int value){
        LinkedList.Node node = linkedList.head;
        while (node != null){
            if (node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    //endregion

    private static LinkedList createSampleList(){
        LinkedList linkedList = new LinkedList();
        Random random = new Random();
        int itemCount = 5 + random.nextInt(15);
        for (int index = 0; index < itemCount; index++){
            insertAtEnd(linkedList, random.nextInt(50));
        }
        return linkedList;
    }

}
