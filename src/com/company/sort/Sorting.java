package com.company.sort;

import java.util.Random;

public class Sorting {

    public static void main(String[] args) {
        int[] array = createArray();
        traverseArray(array);

        //bubbleSort(array);
        //traverseArray(array);

        //optimizedBubbleSort(array);
        //traverseArray(array);

        //selectionSort(array);
        //traverseArray(array);

        //insertionSort(array);
        //traverseArray(array);

        //mergeSort(array, 0, array.length - 1);
        //traverseArray(array);

        //quickSort(array, 0, array.length - 1);
        //traverseArray(array);
    }

    //region Bubble Sort
    private static void bubbleSort(int[] array){
        int size = array.length;
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void optimizedBubbleSort(int[] array){
        int size = array.length;
        for (int i = 0; i < size - 1; i++){
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
    //endregion

    //region Selection Sort
    private static void selectionSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++){
            int minItemIndex = i;
            for(int j = i + 1; j < size; j++){
                if (array[j] < array[minItemIndex]){
                    minItemIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minItemIndex];
            array[minItemIndex] = temp;
        }
    }
    //endregion

    //region Insertion Sort
    private static void insertionSort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
                traverseArray(array);
            }
            array[j + 1] = key;
        }
    }
    //endregion

    //region Merge Sort

    // Divide the array into two sub arrays, sort them and merge them
    private static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            mergeSort(arr, leftIndex, middleIndex);
            mergeSort(arr, middleIndex + 1, rightIndex);
            merge(arr, leftIndex, middleIndex, rightIndex);
        }
    }

    // Merge two sub arrays L and M into arr
    private static void merge(int[] arr, int leftIndex, int middleIndex, int rightIndex) {

        // Create L ← A[left..rightIndex] and M ← A[middle+1..rightIndex]
        int n1 = middleIndex - leftIndex + 1;
        int n2 = rightIndex - middleIndex;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for (int i = 0; i < n1; i++){
            L[i] = arr[leftIndex + i];
        }
        for (int j = 0; j < n2; j++){
            M[j] = arr[middleIndex + 1 + j];
        }

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = leftIndex;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }
    //endregion

    //region Quick Sort

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }

    // method to find the partition position
    static int partition(int[] array, int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greatr element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }
    //endregion

    private static int[] createArray(){
        Random random = new Random();
        int length = 5 + random.nextInt(10);
        int[] array = new int[length];
        for (int i = 0; i < length; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static void traverseArray(int[] array){
        for(Integer i: array){
            System.out.print(i + " -->");
        }
        System.out.println();
    }
}
