package com.company.queue;

import java.util.Random;

public class Exercises2 {

    public static void main(String[] args) {
        Queue queue = createQueue();
    }

    private static void traverse(Queue queue){
        for (int i = 0; i < queue.rearItemIndex; i++){
            System.out.println(queue.items[i]);
        }
    }

    private static Queue createQueue(){
        Random random = new Random();
        int capacity = random.nextInt(10);
        capacity += 10;
        Queue queue = new Queue(capacity);
        for (int i = 0; i < capacity - 3; i++){
            queue.enQueue(random.nextInt(1000));
        }
        return queue;
    }
}
