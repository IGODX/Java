package org.example;

import java.util.Random;

public class Array implements IShow, IMath, ISort{
    int[] array;

    public Array(int arrayLength){
        array = new int[arrayLength];
        fillArray();
    }
    private void fillArray(){
        Random random = new Random();
        for (int i=0; i< array.length;i++)
            array[i] = random.nextInt();
    }
    public void Print() {
        for (int i=0; i< array.length;i++)
        System.out.println(array[i]);
    }

    public void Print(String info) {
        System.out.println(info);
        for (int i=0; i< array.length;i++)
            System.out.println(array[i]);
    }

    public int Max() {
        if (array.length == 0) {
            return 0;
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    public int Min() {
        if (array.length == 0) {
            return 0;
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] < min)
                min = array[i];
        return min;
    }

    public float Avg() {
        if (array.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int value : array)
            sum += value;

        return (float) sum / array.length;
    }

    private void reverseArray() {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    public void SortAsc() {
        quickSort(array, 0, array.length-1);
    }

    public void SortDesc() {
        quickSort(array, 0, array.length-1);
        reverseArray();
    }
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
