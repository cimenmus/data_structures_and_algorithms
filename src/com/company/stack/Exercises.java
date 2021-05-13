package com.company.stack;

import java.util.Iterator;
import java.util.Random;

public class Exercises {

    public static void main(String[] args) {
        Stack stack = createStack();

        //traverse(stack);
        //traverseWithIterator();

        //insertion(stack, 33333);

        //deletion(stack);
        //deleteSpecificItem(stack, 5);

        update(stack);
    }

    //region Traversing
    private static void traverse(Stack stack){
        for (int index = 0; index < stack.topItemIndex; index++){
            System.out.print( stack.items[index]);
            if (index != stack.topItemIndex - 1){
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }

    @SuppressWarnings("WhileLoopReplaceableByForEach")
    private static void traverseWithIterator(){
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(16);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " --> ");
        }
    }
    //endregion

    //region Insertion
    private static void insertion(Stack stack, int item){
        traverse(stack);
        stack.push(item);
        traverse(stack);
    }
    //endregion

    //region Deletion
    private static void deletion(Stack stack){
        traverse(stack);
        System.out.println("Item deleted: " + stack.pop());
        traverse(stack);
    }
    private static void deleteSpecificItem(Stack stack, int item){
        traverse(stack);
        // TODO: will be implemented after Arrays
        traverse(stack);
    }
    //endregion

    //region Updating
    private static void update(Stack stack){
        traverse(stack);
        System.out.println("Even numbers will be updated");
        for (int index = 0; index < stack.topItemIndex; index++){
            if (stack.items[index] % 2 == 0){
                stack.items[index] *= 2;
            }
        }
        traverse(stack);
    }
    //endregion

    //region Sorting
    // TODO: will be implemented after Arrays
    //endregion

    //region Searching
    // TODO: will be implemented after Arrays
    //endregion

    private static Stack createStack(){
        Random random = new Random();
        int capacity = random.nextInt(10);
        capacity += 10;
        Stack stack = new Stack(capacity);
        for (int i = 0; i < capacity - 3; i++){
            stack.push(random.nextInt(1000));
        }
        return stack;
    }
}
