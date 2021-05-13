package com.company.stack;

/**
 * https://www.programiz.com/dsa/stack
 * For the array-based implementation of a stack, the push and pop operations take constant time, i.e. O(1).
 */
public class Stack {

    int[] items;
    int topItemIndex;
    int capacity;

    public Stack(int capacity){
        this.capacity = capacity;
        topItemIndex = -1;
        items = new int[capacity];
    }

    public void push(int item){
        if (isFull()){
            System.out.println("Stack is full");
            return;
        }
        items[++topItemIndex] = item;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return items[topItemIndex--];
    }

    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return items[topItemIndex];
    }

    public int size(){
        return topItemIndex + 1;
    }

    public boolean isFull(){
        return topItemIndex == capacity - 1;
    }

    public boolean isEmpty(){
        return topItemIndex == -1;
    }
}
