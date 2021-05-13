package com.company.queue;

import java.util.*;

public class Exercises {

    public static void main(String[] args) {
        Queue queue = createQueue();

        //traverse(queue);

        //insertion(queue, 8888);

        //deletion(queue);

        // update(queue);

    }

    //region Traversing
    private static void traverse(Queue queue){
        for (int index = queue.frontItemIndex; index < queue.rearItemIndex; index++){
            System.out.print( queue.items[index]);
            if (index != queue.rearItemIndex - 1){
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    //endregion

    //region Insertion
    private static void insertion(Queue queue, int item){
        traverse(queue);
        queue.enQueue(item);
        traverse(queue);
    }
    //endregion

    //region Deletion
    private static void deletion(Queue queue){
        traverse(queue);
        System.out.println("Item deleted: " + queue.deQueue());
        traverse(queue);
    }

    private static void deleteSpecificItem(Queue queue, int item){
        traverse(queue);
        // TODO: will be implemented after Arrays
        traverse(queue);
    }
    //endregion

    //region Updating
    private static void update(Queue queue){
        traverse(queue);
        System.out.println("Even numbers will be updated");
        for (int index = queue.frontItemIndex; index < queue.rearItemIndex; index++){
            if (queue.items[index] % 2 == 0){
                queue.items[index] *= 2;
            }
        }
        traverse(queue);
    }
    //endregion

    //region Sorting
    // TODO: will be implemented after Arrays
    //endregion

    //region Searching
    // TODO: will be implemented after Arrays
    //endregion

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
