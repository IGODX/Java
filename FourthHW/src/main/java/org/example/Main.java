package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Array array = new Array(10);
//        array.Print();
//        array.Print("Message");
//
//        Builder builder = new Builder("Some Builder", 30, "builder");
//        builder.introduce();
//        builder.build();
//
//        Tiger tiger = new Tiger("Tiger", 8, "roar");
//        tiger.sleep();
//        tiger.eat();
//        tiger.makeSound();
//
//        IMath mathOperations = array;
//        System.out.println("Max: " + mathOperations.Max());
//        System.out.println("Min: " + mathOperations.Min());
//        System.out.println("Avg: " + mathOperations.Avg());
//        System.out.println("\n**********************************\n");
//
//        ISort sortingOperations = array;
//        sortingOperations.SortAsc();
//        array.Print();
//        System.out.println("\n**********************************\n");
//        sortingOperations.SortDesc();
//        array.Print();

        // 30.09 Tasks
        int task = 1;
        do {
            System.out.println("Enter task number : (1-4 available. Enter 0 to stop.)");
            task = scanner.nextInt();
            switch (task){
                case 1: {
                    Array<Integer> array = new Array<Integer>(10);
                    System.out.println("Array before sorting :");
                    array.Print();
                    System.out.println("Replacing 2 element with 50");
                    array.replace(2, 50);
                    array.Print();
                    System.out.println("Array after sorting :");
                    array.SortAsc();
                    array.Print();
                    System.out.println("Max element : " + array.Max());
                    System.out.println("Min element : " + array.Min());
                    System.out.println("Average : " + array.Avg());
                    System.out.println("Enter the element that you want to find in array : ");
                    int element = scanner.nextInt();
                    int index = array.binarySearch(element, 0, array.length()); 
                    System.out.println(index != -1 ? "Element has been found. Index : " + index : "Element has not been found");
                }
                    break;
                case 2:
                {
                    Matrix<Float> matrix = new Matrix<Float>(6,6);
                    Matrix<Float> matrix2 = new Matrix<Float>(6,6);
                    matrix.display();
                    Matrix<Float>res = matrix.add(matrix2);
                    res.display();

                }
                    break;
                case 3:{
                    minOfNumbers(5, 10, 50, 20, 30);
                }break;
                case 4:{
                    maxOfNumbers(500, 10, 6000, 20,1,2);
                }break;
            }
        }
        while (task > 0);
    }
    public static <T extends Comparable<T>> void minOfNumbers(T... numbers){
        if (numbers.length == 0) {
            System.out.println("No numbers provided.");
            return;
        }
        T min = numbers[0];
        for (T number : numbers) {
            if (number.compareTo(min) < 0) {
                min = number;
            }
        }

        System.out.println("Min number: " + min);
    }
    public static <T extends Comparable<T>> void maxOfNumbers(T... numbers){
        if (numbers.length == 0) {
            System.out.println("No numbers provided.");
            return;
        }
        T max = numbers[0];
        for (T number : numbers) {
            if (number.compareTo(max) >= 0) {
                max = number;
            }
        }

        System.out.println("Max number: " + max);
    }
}