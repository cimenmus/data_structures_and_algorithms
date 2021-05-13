package com.company.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercises {

    public static void main(String[] args) {
        int[] items = createArray();

        //traverse(items);
        //traverseUsingArrays(items);


        //reverseIterative(items);
        //reverseWithCollections(items);

        //concatenateTwoArrays(items, createArray());
        //concatenateTwoArraysIterative(items, createArray());

        //findAverage(items);
        //findMin(items);
        //findItemIterativeOnUnsortedArray(items, 3);
        //findPrimitiveItemWithStreamOnUnsortedArray(items, 3);
        //findNonPrimitiveItemWithStreamOnUnsortedArray(items, 3);
        //findPrimitiveItemWithArraysOnUnsortedArray(items, 3);
        //findMissingNumberIterative();

        //sortArrayAscendingIterative(items);
        //sortArrayAscendingWithArrays(items);
        //sortArrayDescendingIterative(items);

        //removeAtIndex(items, 3);

    }

    //region Traversing
    private static void traverse(int[] items){
        for (int index = 0; index < items.length; index++) {
            System.out.print(items[index]);
            if (index != items.length - 1){
                System.out.print(" --> ");
            } else {
                System.out.println();
            }
        }
    }

    private static void traverseUsingArrays(int[] items){
        System.out.println(Arrays.toString(items));
    }
    //endregion

    //region Reverse
    private static void reverseIterative(int[] items){
        traverse(items);
        int startIndex = 0;
        int endIndex = items.length - 1;
        while (startIndex < endIndex){
            int temp = items[endIndex];
            items[endIndex] = items[startIndex];
            items[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
        traverse(items);
    }

    private static void reverseWithCollections(int[] items){
        traverse(items);
        Collections.reverse(Arrays.asList(items));
        traverse(items);
    }
    //endregion

    //region Concatenate
    private static void concatenateTwoArraysIterative(int[] items1, int[] items2){
        traverse(items1);
        traverse(items2);
        int[] merged = new int[items1.length + items2.length];
        int position = 0;
        for (Integer item: items1){
            merged[position++] = item;
        }
        for (Integer item: items2){
            merged[position++] = item;
        }
        traverse(merged);
    }

    private static void concatenateTwoArrays(int[] items1, int[] items2){
        traverse(items1);
        traverse(items2);
        int[] merged = new int[items1.length + items2.length];
        System.arraycopy(items1, 0, merged, 0, items1.length);
        System.arraycopy(items2, 0, merged, items1.length, items2.length);
        traverse(merged);
    }
    //endregion

    //region Find Min/Max
    private static void findAverage(int[] items){
        traverse(items);
        double sum = 0;
        for (Integer item: items){
            sum += item;
        }
        double average = sum / items.length;
        System.out.println("Average is: " + average);
    }

    private static void findMin(int[] items){
        traverse(items);
        int min = items[0];
        for (Integer item: items){
            if (item < min){
                min = item;
            }
        }
        System.out.println("Min is: " + min);
    }
    //endregion

    //region Find Item
    private static void findItemIterativeOnUnsortedArray(int[] items, int itemToFind){
        traverse(items);
        for (Integer item: items){
            if (item == itemToFind){
                System.out.println("Item found: " + itemToFind);
                return;
            }
        }
        System.out.println("Item not found: " + itemToFind);
    }

    private static void findPrimitiveItemWithStreamOnUnsortedArray(int[] items, int itemToFind){
        traverse(items);
        boolean isAvailable = IntStream.of(items).anyMatch(n -> n == itemToFind);
        if (isAvailable){
            System.out.println("Item found: " + itemToFind);
        } else {
            System.out.println("Item not found: " + itemToFind);
        }
    }

    private static void findNonPrimitiveItemWithStreamOnUnsortedArray(Integer[] items, int itemToFind){
        boolean isAvailable = Arrays.stream(items).anyMatch(n -> n == itemToFind);
        if (isAvailable){
            System.out.println("Item found: " + itemToFind);
        } else {
            System.out.println("Item not found: " + itemToFind);
        }
    }

    private static void findPrimitiveItemWithArraysOnUnsortedArray(int[] items, int itemToFind){
        traverse(items);
        int itemIndex = Arrays.binarySearch(items, itemToFind);
        if (itemIndex != -1){
            System.out.println("Item found at index " + itemIndex);
        } else {
            System.out.println("Item not found: " + itemToFind);
        }
    }
    //endregion

    //region Find Missing
    private static void findMissingNumberIterative(){
        // Time Complexity: O(n). Only one traversal of the array is needed.
        // Space Complexity: O(1). No extra space is needed
        int length = 100;
        int[] items = new int[length];
        Random random = new Random();
        int missingNumber = random.nextInt(length);
        for (int index = 1; index <= length; index++){
            if (index != missingNumber){
                items[index - 1] = index;
            } else {
                items[index - 1] = 0;
            }
        }
        traverse(items);

        int expectedSum = (length * (length + 1)) / 2;
        int sum = 0;
        for (int item: items){
            sum += item;
        }
        int foundNumber = expectedSum - sum;
        System.out.println("Missing number: " + foundNumber);
    }
    //endregion

    //region Sort Ascending
    private static void sortArrayAscendingIterative(int[] items){
        traverse(items);
        for (int i = 0; i < items.length; i++){
            for (int j = i + 1; j < items.length; j++){
                if (items[i] > items[j]){
                    int temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
        traverse(items);
    }

    private static void sortArrayAscendingWithArrays(int[] items){
        // Arrays.sort() method uses Dual-Pivot Quicksort algorithm
        // complexity is O(n log(n))
        // for primitive arrays
        traverse(items);
        Arrays.sort(items);
        traverse(items);
    }

    private static void sortArrayAscendingWithCollections(){
        //Collections.sort(); // for non-primitive arrays
    }
    //endregion

    //region Sort Descending
    private static void sortArrayDescendingIterative(int[] items){
        traverse(items);
        for (int i = 0; i < items.length; i++){
            for (int j = i + 1; j < items.length; j++){
                if (items[i] < items[j]){
                    int temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
        traverse(items);
    }

    private static void sortArrayDescendingWithArrays(int[] items){
        // Arrays.sort() method uses Dual-Pivot Quicksort algorithm
        // complexity is O(n log(n))
        // for primitive arrays
        traverse(items);
        //Arrays.sort(items, Collections.reverseOrder()); // sort ascending and the reverse it
        traverse(items);
    }
    //endregion

    private static void primitiveArrayListAndArrayConversions(){

        int[] intArray = {1, 2, 3, 4};
        List<Integer> integerList = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        long[] longArray = {1L, 2L, 3L, 4L};
        List<Long> longList = Arrays.stream(longArray).boxed().collect(Collectors.toList());

        double[] doubleArray = {1.0, 2.0, 3.0, 4.0};
        List<Double> doubleList = Arrays.stream(doubleArray).boxed().collect(Collectors.toList());

        char[] charArray = {'A', 'B', 'C', 'D'};

    }

    //region Remove Item
    private static void removeAtIndex(int[] array, int index){
        traverse(array);
        int[] copyArray = new int[array.length - 1];
        System.arraycopy(array, 0, copyArray, 0, index);
        System.arraycopy(array, index + 1, copyArray, index, array.length - index - 1);
        traverse(copyArray);

    }
    //endregion

    private static int[] createArray(){
        Random random = new Random();
        int size = 5 + random.nextInt(15);
        int[] items = new int[size];
        for (int i = 0; i < size; i++){
            items[i] = random.nextInt(100);
        }
        return items;
    }



    int getTotalTime(int[] arr) {
        // Write your code here
        int total = 0;
        int pointer = arr.length - 1;
        Arrays.sort(arr);
        while(pointer > 0){
            int i1 = arr[pointer];
            int i2 = arr[pointer - 1];
            int sum = i1 + i2;
            total += sum;
            arr[i2] = sum;
            pointer--;
        }

        return total;

    }
}
