package com.company.queue;

/**
 * https://www.programiz.com/dsa/circular-queue
 * https://nerdbook.wordpress.com/2018/03/26/kuyruk-veri-yapisi-queue/
 *
 * Basit kuyrukta karşılaşılan ve kuyruğun başında kalan kullanılmayan alan problemini çözmek için
 * döngüsel kuyruk veri yapısı geliştirilmiştir.
 * Döngüsel kuyrukta, kuyruğun başı ile sonu birleştirilmiştir.
 * Önde boşalan yerler, arkadaymış gibi otomatik olarak kullanıma sokulur.
 *
 * The complexity of the enqueue and dequeue operations of a circular queue is O(1) for (array implementations).
 */
public class CircularQueue {

    private int items[];
    private int size, frontItemIndex, rearItemIndex;

    public CircularQueue(int size) {
        this.size = size;
        items = new int[size];
        frontItemIndex = -1;
        rearItemIndex = -1;
    }

    public void enQueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (frontItemIndex == -1){
            frontItemIndex = 0;
        }
        rearItemIndex = (rearItemIndex + 1) % size;
        items[rearItemIndex] = item;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = items[frontItemIndex];
        if (frontItemIndex == rearItemIndex) {
            // Q has only one element, so we reset the queue after deleting it
            frontItemIndex = -1;
            rearItemIndex = -1;
        }
        else {
            frontItemIndex = (frontItemIndex + 1) % size;
        }
        return item;
    }

    private boolean isFull() {
        return (frontItemIndex == 0 && rearItemIndex == size - 1) || frontItemIndex == rearItemIndex + 1;
    }

    private boolean isEmpty() {
        return frontItemIndex == -1;
    }

}
