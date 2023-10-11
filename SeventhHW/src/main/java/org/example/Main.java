package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        firstTask("D:\\Java Projects\\SeventhHW\\src\\main\\java\\org\\example\\firstTask1.txt",
                "D:\\Java Projects\\SeventhHW\\src\\main\\java\\org\\example\\firstTask2.txt");
        secondTask("D:\\Java Projects\\SeventhHW\\src\\main\\java\\org\\example\\secondTask.txt");
        thirdTask("D:\\Java Projects\\SeventhHW\\src\\main\\java\\org\\example\\thirdTask.txt");
        int[] array = {1, 2, 3, 4, 5, 50, 100, 300};
        fourthTask(array,"D:\\Java Projects\\SeventhHW\\src\\main\\java\\org\\example\\fourthTask.txt");
        Corporation corporation = new Corporation();
        corporation.choseOption();
    }
    public static void firstTask(String path1, String path2){
        try( BufferedReader reader1 = new BufferedReader(new FileReader(path1));
             BufferedReader reader2 = new BufferedReader(new FileReader(path2))
        ){
            ArrayList<String> lines1 = new ArrayList<>();
            ArrayList<String> lines2 = new ArrayList<>();

            String line1, line2;

            while ((line1 = reader1.readLine()) != null) {
                lines1.add(line1);
            }

            while ((line2 = reader2.readLine()) != null) {
                lines2.add(line2);
            }
            for (int i = 0; i < lines1.size() && i < lines2.size(); i++) {
                if (!lines1.get(i).equals(lines2.get(i))) {
                    System.out.println("Line " + (i + 1) + " doesn't match:");
                    System.out.println("File 1: " + lines1.get(i));
                    System.out.println("File 2: " + lines2.get(i));
                }
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void secondTask(String path){
        try( BufferedReader reader = new BufferedReader(new FileReader(path))){
            String longestLine = "";
            int longestLength = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > longestLength) {
                    longestLine = line;
                    longestLength = line.length();
                }
            }
            System.out.println("Longest line length: " + longestLength);
            System.out.println("Longest line: " + longestLine);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void thirdTask(String path){
        File file = new File(path);
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(" ");
                int[] array = new int[elements.length];

                for (int i = 0; i < elements.length; i++) {
                    array[i] = Integer.parseInt(elements[i]);
                }

                System.out.print("Array: ");
                for (int num : array) {
                    System.out.print(num + " ");
                }

                System.out.println();

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                int sum = 0;

                for (int num : array) {
                    if (num > max) {
                        max = num;
                    }
                    if (num < min) {
                        min = num;
                    }
                    sum += num;
                }

                System.out.println("Max: " + max);
                System.out.println("Min: " + min);
                System.out.println("Sum: " + sum);
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public static void fourthTask(int[] numbers,String path){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int number : numbers) {
                writer.write(Integer.toString(number) + " ");
            }
            writer.newLine();

            for (int number : numbers) {
                if (number % 2 == 0) {
                    writer.write(Integer.toString(number) + " ");
                }
            }
            writer.newLine();

            for (int number : numbers) {
                if (number % 2 != 0) {
                    writer.write(Integer.toString(number) + " ");
                }
            }
            writer.newLine();

            for (int i = numbers.length - 1; i >= 0; i--) {
                writer.write(Integer.toString(numbers[i]) + " ");
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void fivthTask(){

    }
}