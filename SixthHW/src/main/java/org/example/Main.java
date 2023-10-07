package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.function.Predicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Is 2023 a leap year? "+ isLeapYear(2023));
        daysBetweenTwoDates();
        dayOfWeekByDate();
        dayOfWeekByDate();

        Fraction fraction1 = new Fraction(10,20);
        Fraction fraction2 = new Fraction(36,40);
        FractionOperations sum = (f1, f2)->{
            int newNumerator = f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator();
            int newDenominator = f1.getDenominator() * f2.getDenominator();
            return new Fraction(newNumerator, newDenominator);
        };
        FractionOperations multiply = (f1,f2)->{
            int newNumerator = f1.getNumerator() * f2.getNumerator();
            int newDenominator = f1.getDenominator() * f2.getDenominator();
            return new Fraction(newNumerator, newDenominator);
        };
        FractionOperations substract = (f1,f2)->{
            int newNumerator = f1.getNumerator() * f2.getDenominator() - f2.getNumerator();
            int newDenominator = f1.getDenominator() * f2.getDenominator();
            return new Fraction(newNumerator, newDenominator);
        };
        FractionOperations divide = (f1,f2)->{
            int newNumerator = f1.getNumerator() * f2.getDenominator();
            int newDenominator = f1.getDenominator() * f2.getNumerator();
            return new Fraction(newNumerator, newDenominator);
        };
        System.out.println(sum.apply(fraction1,fraction2));
        System.out.println(multiply.apply(fraction1,fraction2));
        System.out.println(substract.apply(fraction1,fraction2));
        System.out.println(divide.apply(fraction1,fraction2));

        MinMax<Double> max = (a,b,c,d)->{
            double res1 = Math.max(a,b);
            double res2 = Math.max(c,d);
            return Math.max(res1, res2);
        };
        MinMax<Double> min = (a,b,c,d)->{
            double res1 = Math.min(a,b);
            double res2 = Math.min(c,d);
            return Math.min(res1, res2);
        };
        System.out.println("Min : " + min.find(1.1,500.2,3.3,50.5));
        System.out.println("Max : " + max.find(1.9,500.1,3.2,50.6));

        int[] numbers = {1, 2, 3, 4, 5, -1, -2, -3, -4, -5};

        Predicate<Integer> isPositive = x -> x > 0;

        Predicate<Integer> isNegative = x -> x < 0;
        int start = 1;
        int end = 5;
        Predicate<Integer> isNotInDiapason = x -> x < start || x > end;

        int targetNumber = 3;
        Predicate<Integer> isEqualToTarget = x -> x == targetNumber;

        System.out.println("Sum of positive numbers: " + sumOf(numbers, isPositive));
        System.out.println("Sum of elements that aren't in diapason: " + sumOf(numbers, isNotInDiapason));
        System.out.println("Sum of negative numbers: " + sumOf(numbers, isNegative));
        System.out.println("Sum of elements that equal " + targetNumber + ": " + sumOf(numbers, isEqualToTarget));
    }

    public static boolean isLeapYear(int year){
        Predicate<Integer> isLeapYear = y -> (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
        return isLeapYear.test(year);
    }
    public static void daysBetweenTwoDates(){
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2022, 12, 31);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("The number of days between " + date1 + " "+ date2 + " : " + daysBetween);
    }
    public static void numberOfWeeksBetweenTwoDates(){
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2022, 12, 31);
        long weeks = ChronoUnit.WEEKS.between(date1, date2);
        System.out.println("The number of weeks between: " + weeks);
    }

    public static void dayOfWeekByDate(){
        LocalDate date = LocalDate.of(1969, 7, 20);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String dayOfWeekName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(date + " - " + dayOfWeekName);
    }
    public static int sumOf(int[] array, Predicate<Integer> condition) {
        int sum = 0;
        for (int element : array) {
            if (condition.test(element)) {
                sum += element;
            }
        }
        return sum;
    }
}
@FunctionalInterface
interface FractionOperations{
    Fraction apply(Fraction fraction1, Fraction fraction2);
}
@FunctionalInterface
interface MinMax<T>{
    T find(T arg1, T arg2, T arg3, T arg4);
}