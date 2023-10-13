package org.example;

public class SumThread extends Thread{
    private int[] arr;

    private int sum = 0;
    public SumThread(int[]arr){
        this.arr = arr;
    }
    public void run(){
        for(int i = 0; i<arr.length; i++)
            sum+=arr[i];
    }
    public int getSum(){
        return sum;
    }
}
