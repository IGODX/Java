package org.example;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static ArrayList<String> forbiddenWords = new ArrayList<>(Arrays.asList("хорошо", "плохо"));
    private static char[] symbols = {'!', ';', '.', ',', '@', '#', '$', '*' };
    public static void main(String[] args) {
        //printFileContent("D:\\firstTask.txt");
//        int count = numberOfTimesTheWordOccursInText("D:\\firstTask.txt", "Shakespeare");
//        System.out.println("Number of times word Shakespeare occured in text : " + count);
//        countCharacters("D:\\firstTask.txt");
//        int bytes = moveContent("D:\\Java Projects\\seventhLW\\src\\main\\java\\org\\example\\file1.txt",
//                "D:\\Java Projects\\seventhLW\\src\\main\\java\\org\\example\\file2.txt",
//                "D:\\Java Projects\\seventhLW\\src\\main\\java\\org\\example\\file3.txt",
//                "D:\\Java Projects\\seventhLW\\src\\main\\java\\org\\example\\output.txt");
//        System.out.println("Bytes from 3 files " + bytes);
       // System.out.println("Count of replacements : " + findAndReplace("D:\\firstTask.txt", "D:\\firstTaskOutput.txt", "Shakespeare", "peare"));
  System.out.println(removeForbiddenWords("D:\\Java Projects\\seventhLW\\src\\main\\java\\org\\example\\forbiddenWords.txt",
          "D:\\Java Projects\\seventhLW\\src\\main\\java\\org\\example\\forbiddenWordsOutput.txt"));
    }
    public static void printFileContent(String path){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = bufferedReader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int numberOfTimesTheWordOccursInText(String path, String wordToFind){
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words)
                    if (word.equals(wordToFind))
                        count++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }

    public static int removeForbiddenWords(String path, String output){
        int removedWordsCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                int count = 0;
                for (int i = 0; i < words.length; i++) {
                    if (forbiddenWords.contains(words[i])) {
                        words[i] = "";
                        count++;
                    }
                }

                removedWordsCount += count;
                String modifiedLine = String.join(" ", words);
                writer.write(modifiedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return removedWordsCount;
    }
    public static int findAndReplace(String path, String outputFile, String wordToChange, String newWord){
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
             lines.add(line);
            }
            for (int i = 0; i < lines.size(); i++) {
                String l = lines.get(i);
                String replacedLine = l.replaceAll(wordToChange, newWord);
                if (!replacedLine.equals(l)) {
                    count++;
                }
                lines.set(i, replacedLine);
            }
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }
    public static int moveContent(String firstFile, String secondFile, String thirdFile, String destination){
        int totalBytesCopied = 0;

        try (InputStream inputStream1 = new FileInputStream(firstFile);
             InputStream inputStream2 = new FileInputStream(secondFile);
             InputStream inputStream3 = new FileInputStream(thirdFile);
             OutputStream outputStream = new FileOutputStream(destination)) {

            totalBytesCopied += copyStream(inputStream1, outputStream);
            totalBytesCopied += copyStream(inputStream2, outputStream);
            totalBytesCopied += copyStream(inputStream3, outputStream);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return totalBytesCopied;
    }
    private static int copyStream(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        int totalBytesCopied = 0;
        byte[] newLine = "\n".getBytes();

        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
            totalBytesCopied += bytesRead;
        }
        output.write(newLine);
        return totalBytesCopied;
    }
    public static void countCharacters(String path){
        int numberOfLetters = 0;
        int numberOfDigits = 0;
        int numberOfSymbols = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            int characterValue;
            while((characterValue = bufferedReader.read()) != -1){
                char character = (char)characterValue;
                if(Character.isLetter(character))
                    numberOfLetters++;
                else if(Character.isDigit(character))
                    numberOfDigits++;
                else if(isSymbol(character))
                    numberOfSymbols++;
            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Number of letters : " + numberOfLetters);
        System.out.println("Number of digits : " + numberOfDigits);
        System.out.println("Number of symbols : " + numberOfSymbols);
    }
    private static boolean isSymbol(char character){
        for(char c : symbols)
            if(c == character)
                return true;
        return false;
    }
}