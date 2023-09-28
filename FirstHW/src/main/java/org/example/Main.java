package org.example;

import java.util.*;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int tasks = 1;
        do {
            System.out.println("Enter task number : ");
            tasks = scanner.nextInt();
            switch (tasks) {
                case 1:
                   firstTask();
                    break;
                case 2:
                    secondTask();
                    break;
                case 3:
                    thirdTask();
                    break;
                case 4:
                    fourthTask();
                    break;
                case 5:
                   fifthTask();
                    break;
                case 6:
                    sixthTask();
                    break;
                case 7:
                    seventhTask();
                    break;
                case 8:
                    eightTask();
                    break;
                case 9:
                    ninethTask();
                    break;
                case 10:
                    tenthTask();
                    break;
                case 11:
                    eleventhTask();
                    break;
                case 12:
                    twelvethTask();
                    break;
                default:
                    System.out.println("Ending program...");
                    break;
            }
        } while (tasks != 0);
    }
    public static void firstTask(){
        String str = "\"Your time is limited,\n\tso don't waste it\n\t\t living someone else's life\"\n\t\t\tSteve Jobs";
        System.out.println(str);
    }

    public static void secondTask(){

        System.out.println("Enter value: ");
        int value = scanner.nextInt();

        System.out.println("Enter percent: ");
        int percent = scanner.nextInt();

        int result = value * percent / 100;

        System.out.println("10 percent from " + value + " equals " + result);
    }
    public static void thirdTask(){
        int[] threeNumbers = new int[3];
        System.out.println("Enter 3 values: ");
        for(int i=0; i<3; i++){
            threeNumbers[i] = scanner.nextInt();
        }
        String str = "";
        for(int i=0; i<3; i++){
           str += threeNumbers[i];
        }
        System.out.println(str);
    }
    public static void fourthTask(){
        System.out.println("Enter 6 digits number: ");
        String number = scanner.nextLine();

        if (number.length() != 6) {
            System.out.println("The number is not 6 digits!");
            return;
        }

        char firstChar = number.charAt(0);
        char sixthChar = number.charAt(5);
        number = number.replace(firstChar, sixthChar);
        number = number.replace(sixthChar, firstChar);

        char secondChar = number.charAt(1);
        char fifthChar = number.charAt(4);
        number = number.replace(secondChar, fifthChar);
        number = number.replace(fifthChar, secondChar);

        System.out.println("Changed number: " + number);
    }
    public static void fifthTask(){
        System.out.println("Enter month number : ");
        int month = scanner.nextInt();
        switch (month){
            case 1:
            case 2:
            case 12:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default: System.out.println("Error number must be greater then 0 and less then 13");
            break;
        }
    }

    public static void sixthTask(){
        System.out.println("Enter number of meters : ");
        double meters = scanner.nextDouble();
        System.out.println("Enter unit of measurement : 1 - mile, 2 - inch, 3 - yard: ");
        int unit = scanner.nextInt();

        switch (unit) {
            case 1:
                double miles = meters / 0.000621371192;
                System.out.println(meters + " meters equals " + miles + " miles");
                break;
            case 2:
                double inches = meters * 39.37007874;
                System.out.println(meters + " meters equals " + inches + " inches");
                break;
            case 3:
                double yards = meters / 0.9144;
                System.out.println(meters + " meters equals " + yards + " yards");
                break;
            default:
                System.out.println("Wrong unit of measurement");
                break;
        }
    }

    public static void seventhTask(){
        System.out.println("Enter the start of the diapason: ");
        int start = scanner.nextInt();

        System.out.println("Enter the end of the diapason: ");
        int end = scanner.nextInt();

        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }

        for (int i = start + 1; i < end; i += 2) {
            System.out.println(i);
        }
    }
    public static void eightTask(){
        System.out.println("Enter the start of the diapason: ");
        int start = scanner.nextInt();
        System.out.println("Enter the end of the diapason: ");
        int end = scanner.nextInt();
        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }
        for (; start<=end; start++)
            for (int i = 1; i <= 10; i++)
            System.out.println(start + "*" + i + "=" + start*i);
    }

    public static void ninethTask(){
        int n = 10;

        int[] array = new int[n];

        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }

        int negative = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negative++;
            }
        }

        int positive = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] > 0)
                positive++;
        int zero = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == 0)
                zero++;
        System.out.println("Min number: " + min);
        System.out.println("Max number: " + max);
        System.out.println("Number of negative numbers: " + negative);
        System.out.println("Number of positive numbers: " + positive);
        System.out.println("Number of zeros: " + zero);
    }

    public static void tenthTask(){
        int n = 10;

        int[] array = new int[n];

        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt();

        int[] evenArray = new int[array.length];
        int evenCount = createArrayForTenthTask(array, evenArray, x-> x % 2 == 0);

        int[] oddArray = new int[array.length];
        int oddCount =  createArrayForTenthTask(array, oddArray, x-> x % 2 != 0);

        int[] negativeArray = new int[array.length];
        int negativeCount = createArrayForTenthTask(array, negativeArray, x-> x < 0);

        int[] positiveArray = new int[array.length];
        int positiveCount = createArrayForTenthTask(array, positiveArray, x-> x >= 0);


        System.out.println("Even numbers:");
        printArray(evenArray, evenCount);

        System.out.println("Odd numbers:");
        printArray(oddArray, oddCount);

        System.out.println("Negative numbers:");
        printArray(negativeArray, negativeCount);

        System.out.println("Positive numbers:");
        printArray(positiveArray, positiveCount);
    }

    public static void eleventhTask(){
        System.out.println("Enter length : ");
        int length = scanner.nextInt();
        System.out.println("Enter symbol : ");
        char symb = scanner.next().charAt(0);
        System.out.println("Enter true to set vertical or false to set horizon : ");
        boolean vertical = scanner.nextBoolean();
        drawLine(length, symb, vertical);
    }

    public static void twelvethTask(){
        int n = 10;
        Integer[] array = new Integer[n];

        for (int i = 0; i<array.length; i++)
            System.out.print(array[i] + " ");
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt();
        System.out.println("Enter 1 if you want to sort by descending, or 0 for reverse sorting");
        boolean descending = scanner.nextBoolean();
        sortArray(array, descending);
        for (int i = 0; i<array.length; i++)
            System.out.print(array[i] + " ");
    }
    private static void sortArray(Integer[] array, boolean descending) {
        if (descending)
            Arrays.sort(array);
        else
            Arrays.sort(array, Comparator.reverseOrder());
    }
    private static void printArray(int[] arr, int length) {
        for (int i = 0; i<length; i++)
            System.out.println(arr[i]);
    }

    private static void drawLine(int length, char symbol, boolean vertical) {
        if (vertical) {
            for (int i = 0; i < length; i++) {
                System.out.print(symbol);
            }
        } else {
            for (int i = 0; i < length; i++) {
                System.out.println(symbol);
            }
        }
    }
    private static int createArrayForTenthTask(int[] mainArray, int[] arrayToFill, Predicate<Integer> predicate){
        int count = 0;
        for (int i=0; i<mainArray.length; i++)
            if(predicate.test(mainArray[i]))
                arrayToFill[count++] = mainArray[i];
        return count;
    }
}