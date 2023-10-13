package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EvenNumbersThread  extends Thread{
    private int[] arr;

    private String outputFile;
    public EvenNumbersThread(int[] arr, String outputFile){
        this.arr = arr;
        this.outputFile = outputFile;
    }

    public void run(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for(int number : arr)
                if(number % 2 == 0)
                    writer.write(number + " ");
        } catch (IOException e) {

        }
    }
}
