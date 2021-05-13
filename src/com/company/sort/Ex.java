package com.company.sort;

public class Ex {

    public void bubbleSort(int[] array){
        int size = array.length;
        for (int i = 0; i < size - 1; i++){
            boolean isSwapped = false;
            for (int j = 0; j < size - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped){
                break;
            }
        }
    }

    public void insertionSort(int[] array){
        int size = array.length;
        for (int i = 1; i < size; i++){
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]){
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
}
