package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OddNumbersThread extends Thread{
    private int[] arr;

    private String outputFile;
    public OddNumbersThread(int[] arr, String outputFile){
        this.arr = arr;
        this.outputFile = outputFile;
    }

    public void run(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for(int number : arr)
                if(number % 2 != 0)
                    writer.write(number + " ");
        } catch (IOException e) {

        }
    }
}
