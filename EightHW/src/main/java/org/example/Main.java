package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //firstTask();
        //secondTask();
        //thirdTask();
        fourthTask();
    }
    private static void firstTask(){
        int[]arr = new int[15];
        Runnable task = ()-> fillArray(arr);
        Thread thread1 = new Thread(task);
        thread1.start();
        try{
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AvgThread avgThread = new AvgThread(arr);
        SumThread sumThread = new SumThread(arr);
        avgThread.start();
        sumThread.start();
        try {
            avgThread.join();
            sumThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(avgThread.getAvg());
        System.out.println(sumThread.getSum());
    }
    private static void secondTask(){
        int[] arr = new int[15];
        Runnable task = ()->{
            fillArray(arr);
            List<Integer> lst = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            writeToFile("D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\array.txt", lst);
        };
        Thread thread = new Thread(task);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread primeThread = new Thread(() -> {
            List<Integer> primes = new ArrayList<>();
            for (int num : arr)
                if (isPrime(num))
                    primes.add(num);
            writeToFile("D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\simpleNumbers.txt", primes);
        });

        Thread calculateFactorial = new Thread(()->{
            List<Integer> factorials = new ArrayList<>();
            for (int num : arr) {
                factorials.add(calculateFactorial(num));
            }
            writeToFile("D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\factorial.txt", factorials);
        });
        primeThread.start();
        calculateFactorial.start();
        try{
            primeThread.join();
            calculateFactorial.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void thirdTask(){
        String directoryInput = "D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\input";
        String directoryOutput = "D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\output";

        Thread copyThread = new Thread(() -> {
            try {
                copyDirectory(new File(directoryInput), new File(directoryOutput));
            } catch (IOException e) {
            }
        });

        copyThread.start();

        try {
            copyThread.join();
        } catch (InterruptedException e) {
        }
    }

    private static void fourthTask(){
        String path = "D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\folder1\\";
        String destination = "D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\merged";
        String word = "f1";
        File directory = new File(path);
        File destinationFolder = new File(destination);
        if (!destinationFolder.exists()) {
            if (destinationFolder.mkdirs()) {
                System.out.println("Folder has been created");
            } else {
                System.err.println("Folder has not been created");
                return;
            }
        }
        File[] files = directory.listFiles();
        if(files != null){
            Thread searchAndMergeThread = new Thread(() -> {
                for (File file : files) {
                    if (file.getName().contains(word)) {
                        try {
                            Path sourceFilePath = file.toPath();
                            Path destinationFilePath = Paths.get(destination, file.getName());
                            Files.copy(sourceFilePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("File has been copied!");
                        } catch (IOException e) {
                        }
                    }
                }
            });
            searchAndMergeThread.start();
            try{
                searchAndMergeThread.join();
            } catch (InterruptedException e) {

            }
        }
        Thread removeForbiddenWords = new Thread(()->{
            var words = readForbiddenWords("D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\forbiddenWords.txt");
            try {
                removeForbiddenWords("D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\textWithForbiddenWords.txt",words);
            } catch (IOException e) {
            }
        });
        removeForbiddenWords.start();
        try {
            removeForbiddenWords.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    private static void copyDirectory(File sourceDir, File targetDir) throws IOException {
        if (sourceDir.isDirectory()) {
            if (!targetDir.exists()) {
                targetDir.mkdir();
            }

            String[] children = sourceDir.list();
            for (String child : children) {
                copyDirectory(new File(sourceDir, child), new File(targetDir, child));
            }
        }
        else {
            Files.copy(sourceDir.toPath(), targetDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
    private static List<String> readForbiddenWords(String path){
        String[] forbiddenWords = new String[0];
      try(BufferedReader reader = new BufferedReader(new FileReader(path))){
          String line;

          while ((line = reader.readLine()) != null)
            forbiddenWords = line.split(", ");
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
        return Arrays.stream(forbiddenWords).toList();
    }
    private static int removeForbiddenWords(String path, List<String> forbiddenWords) throws IOException {
        int removedWordCount = 0;
        List<String> resultLines = new ArrayList<>();
        List<String> inputLines = Files.readAllLines(Paths.get(path));
        for (String line : inputLines) {
            for (String forbiddenWord : forbiddenWords)
                line = line.replaceAll(forbiddenWord, "");
            resultLines.add(line);
        }
        Path outputFilePath = Paths.get("D:\\Java Projects\\EightHW\\src\\main\\java\\org\\example\\outputWords.txt");
        Files.write(outputFilePath, resultLines);

        return removedWordCount;
    }
    private static void fillArray(int[]arr){
        for (int i = 0; i<arr.length; i++)
            arr[i] = ThreadLocalRandom.current().nextInt(50);
    }
    private static int calculateFactorial(int number) {
        if (number <= 1) return 1;
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
    private static void writeToFile(String path, List<Integer> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int num : data)
                writer.write(Integer.toString(num) + " ");
        } catch (IOException e) {
        }
    }

}