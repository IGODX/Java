package org.example;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CalculateOperation sumOfThree = (a, b, c) -> a+b+c;
        print(sumOfThree);
        CalculateOperation multiplyOfThree = ((a, b, c) -> a*b*c);
        print(multiplyOfThree);
        PrintDate printTime = ()->{
            System.out.println(new Date().getTime());
        };
        PrintDate printDate = ()->{
            System.out.println(new Date().getDate());
        };
        printTime.print();
        printDate.print();

        //Second task
        BinaryOperator<Integer> max = (a, b) -> Math.max(a, b);
        int maximum = max.apply(5, 10);
        System.out.println("Max: " + maximum);

        BinaryOperator<Integer> min = (a, b) -> Math.min(a, b);
        int minimum = min.apply(2, 3);
        System.out.println("Min: " + minimum);
        Function<Integer, Integer> factorial = n -> {
            if (n == 0) {
                return 1;
            }
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        int factorialResult = factorial.apply(5);
        System.out.println("Factorial of the number 5 : " + factorialResult);

        Predicate<Integer> isPrime = n -> {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
        boolean isPrimeResult = isPrime.test(11);
        System.out.println("Is number 11 prime : " + isPrimeResult);


        // Third task
        MinMax<Integer> min2 = (a,b,c)->{
          int res = Math.min(a,b);
          return Math.min(c, res);
        };
        print("Min : ", min2, 30,500,600);
        print("Max : ", (a,b,c)->{
            int res = Math.max(a,b);
            return Math.max(c, res);
        }, 30,500,600);
        // Forth task
        int[] numbers = {1, 10, 33, 44, 6, 47, 108, 31, 2};

        int sumOfEven = sumOf(numbers, x -> x % 2 == 0);
        System.out.println("Sum of even numbers: " + sumOfEven);
        int sumOfOdd = sumOf(numbers, x -> x % 2 != 0);
        System.out.println("Sum of odd numbers: " + sumOfOdd);
        int start = 3;
        int end = 8;
        int sumInRange = sumOf(numbers, x -> x >= start && x <= end);
        System.out.println("Sum of numbers in range from " + start + " to " + end + " : " + sumInRange);

        int multipleOf = 3;
        int sumOfMultiples = sumOf(numbers, x -> x % multipleOf == 0);
        System.out.println("Sum of numbers that multiples " + multipleOf + ": " + sumOfMultiples);
    }
    public static int sumOf(int[] arr, Predicate<Integer> predicate){
        int sum = 0;
        for(int i=0; i<arr.length; i++)
            if(predicate.test(arr[i]))
                sum+= arr[i];
        return sum;
    }
    public static void print(CalculateOperation operation){
        System.out.println(operation.calculate(10,15,20));
    }
    public static <T extends Number> void print(String message, MinMax<T> minMax, T arg1, T arg2, T arg3){
       System.out.println(message + minMax.find(arg1,arg2,arg3));
    }
}
@FunctionalInterface
interface CalculateOperation {
    int calculate(int a, int b, int c);
}
@FunctionalInterface
interface PrintDate{
    void print();
}
@FunctionalInterface
interface MinMax<T extends Number>{
   T find(T a, T b, T c);
}