package org.example;

import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int task = 1;
        do{
            System.out.println("Enter task number: ");
            task = scanner.nextInt();
            switch (task) {
                case 1:
                    firstTask();
                    break;
                case 7:
                    seventhTask();
                    break;
                case 9:
                    ninthTask();
                    break;
                case 10:
                    tenthTask();
                    break;
                case 11:
                    eleventhTask();
                    break;
                case 12:
                    twelfthTask();
                    break;
            }
            }
        while (task > 0);

    }
    public static void firstTask(){
        System.out.println("Fall seven times");
        System.out.println("and");
        System.out.println("stand up eight");
    }
    public static void seventhTask(){
        System.out.print("Enter number to calculate factorial: ");
        int n = scanner.nextInt();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Factorial " + n + " = " + factorial);
    }
    public static void ninthTask(){
        System.out.print("Enter the number of elements in array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        int sum = 0;

        System.out.println("Enter numbers in array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        double average = (double) sum / n;

        System.out.println("Array elements:");

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\nSum of elements in array: " + sum);
        System.out.println("Average number: " + average);
    }

    public static void tenthTask(){
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to count: ");
        int numberToCount = scanner.nextInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] == numberToCount) {
                count++;
            }
        }

        System.out.println("The number " + numberToCount + " appears in the array " + count + " times.");
    }
    private static int calculateRangeSum(int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }
    public static void eleventhTask(){
        System.out.print("Enter the start: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end: ");
        int end = scanner.nextInt();
        int sum = calculateRangeSum(start, end);
        System.out.println("The sum of numbers in the range from " + start + " to " + end + " is: " + sum);
    }

    public static void twelfthTask(){
        int[] inputArray = {1, 2, 3, 4, 5};
        int[] factorialArray = calculateFactorials(inputArray);

        System.out.println("Input Array: " + Arrays.toString(inputArray));
        System.out.println("Factorial Array: " + Arrays.toString(factorialArray));
    }
    private static int[] calculateFactorials(int[] array) {
        int[] resultArray = new int[array.length];

        for (int i = 0; i < array.length; i++)
            resultArray[i] = calculateFactorial(array[i]);


        return resultArray;
    }

    private static int calculateFactorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        int factorial = 1;
        for (int i = 2; i <= n; i++)
            factorial *= i;

        return factorial;
    }
}