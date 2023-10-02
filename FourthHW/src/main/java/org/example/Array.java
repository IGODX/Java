package org.example;

import java.util.Random;

    public class Array<T extends Comparable<T>> {
    T[] array;

        public T[] getArray() {
            return array;
        }

        public Array(int arrayLength) {
        array = (T[]) new Comparable[arrayLength];
        System.out.println(array);
        fillArray();
    }

    private void fillArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = (T) Integer.valueOf(random.nextInt());
    }

    public void Print() {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

    public void Print(String info) {
        System.out.println(info);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
    public int length(){
            return array.length;
    }
    public T Max() {
        if (array.length == 0) {
            return null;
        }
        T max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i].compareTo(max) == 1)
                max = array[i];
        return max;
    }

    public T Min() {
        if (array.length == 0) {
            return null;
        }

        T min = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i].compareTo(min) < 0)
                min = array[i];
        return min;
    }

    public double Avg() {
        if (array.length == 0) {
       return 0.0;
       }

        double sum = 0.0;

        for (T value : array) {
            sum += ((Number)value).doubleValue();
       }

        return sum / array.length;
   }

    private void reverseArray() {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            T temp = array[left];
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
    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0){
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

        public int binarySearch(T key, int low, int high) {
            int middle = low + ((high - low) / 2);
            if (high < low) {
                return -1;
            }
            int compareResult = key.compareTo(array[middle]);

            if (compareResult == 0) {
                return middle;
            } else if (compareResult < 0) {
                return binarySearch(key, low, middle - 1);
            } else {
                return binarySearch(key, middle + 1, high);
            }
        }
        public void replace(int index, T newValue) {
            if (index >= 0 && index < array.length) {
                array[index] = newValue;
            } else {
               throw new IndexOutOfBoundsException();
            }
        }
}
