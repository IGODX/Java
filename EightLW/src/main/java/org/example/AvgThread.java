package org.example;

public class AvgThread extends Thread{
    private int[] arr;

    private double avg;
    public AvgThread(int[]arr){
        this.arr = arr;
    }
    public void run(){
        for(int i = 0; i<arr.length; i++)
            avg+=arr[i];
        avg = avg / arr.length;
    }
    public double getAvg(){
        return avg;
    }
}
