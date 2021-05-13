package com.company.queue;

/**
 * https://www.programiz.com/dsa/queue
 * https://nerdbook.wordpress.com/2018/03/26/kuyruk-veri-yapisi-queue/
 * The complexity of enqueue and dequeue operations in a queue using an array is O(1).
 */
public class Queue {

    int[] items;
    int capacity, frontItemIndex, rearItemIndex;

    public Queue(int capacity){
        this.capacity = capacity;
        items = new int[capacity];
        frontItemIndex = -1;
        rearItemIndex = -1;
    }

    public void enQueue(int item){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        if (frontItemIndex == -1){
            frontItemIndex = 0;
        }
        items[++rearItemIndex] = item;
    }

    public int deQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int item = items[frontItemIndex];
        if (frontItemIndex >= rearItemIndex){
            // Q has only one element, so we reset the queue after deleting it
            frontItemIndex = -1;
            rearItemIndex = -1;
        } else {
            frontItemIndex++;
        }
        return item;
    }

    public int size(){
        if (isEmpty()){
            return 0;
        }
        return rearItemIndex + 1;
    }

    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return items[frontItemIndex];
    }

    public boolean isFull(){
        return frontItemIndex == 0 && rearItemIndex == capacity - 1;
    }

    public boolean isEmpty(){
        return frontItemIndex == -1;
    }
}
