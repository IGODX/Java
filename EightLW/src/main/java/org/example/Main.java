package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        firstTask();
//        secondTask();
       // thirdTask();
        fourthTask();
    }

    public static void firstTask(){
        int[] arr = { 1, 2 , 3, -10, 500, 200};
        MinThread minThread = new MinThread(arr);
        MaxThread maxThread = new MaxThread(arr);
        minThread.start();
        maxThread.start();
        try{
            minThread.join();
            maxThread.join();
        }
        catch (InterruptedException e) {
        }
        System.out.println(minThread.getMin());
        System.out.println(maxThread.getMax());
    }

    public static void secondTask(){
        int[] arr = { 1, 2 , 3, -10, 500, 200};
        AvgThread avgThread = new AvgThread(arr);
        SumThread sumThread = new SumThread(arr);

        avgThread.start();
        sumThread.start();

        try{
            avgThread.join();
            sumThread.join();
        }
        catch (InterruptedException e) {
        }
        System.out.println(avgThread.getAvg());
        System.out.println(sumThread.getSum());
    }
    public static void thirdTask(){
        System.out.println("Enter filepath:");
//        String path = scanner.nextLine();
        String path = "D:\\Java Projects\\EightLW\\src\\main\\java\\org\\example\\array.txt";
        int[] arr = new int[0];
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] numbers = line.split(" ");
                arr = new int[numbers.length];
                for(int i = 0;i<arr.length;i++)
                    arr[i] = Integer.parseInt(numbers[i]);
            }
        } catch (IOException e) {
        }

        EvenNumbersThread evenNumbersThread = new EvenNumbersThread(arr, "D:\\Java Projects\\EightLW\\src\\main\\java\\org\\example\\even.txt");
        OddNumbersThread oddNumbersThread = new OddNumbersThread(arr, "D:\\Java Projects\\EightLW\\src\\main\\java\\org\\example\\odd.txt");
    evenNumbersThread.start();
    oddNumbersThread.start();
        try{
            evenNumbersThread.join();
            oddNumbersThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void fourthTask(){
        AtomicReference<Boolean> result = new AtomicReference<>();
        Runnable task = ()-> result.set(findWord("D:\\Java Projects\\EightLW\\src\\main\\java\\org\\example\\fourthTask.txt", "Привет"));
        Thread thread = new Thread(task);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result.get() == true ? "Слово найдено!" : "Слово не найдено!");
    }
    private static boolean findWord(String path, String word){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = reader.readLine()) != null){
                if(line.contains(word))
                    return true;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}