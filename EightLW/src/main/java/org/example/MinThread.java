package org.example;

public class MinThread extends Thread {

    private int[] arr;
    private int min;
    public MinThread(int[]arr){
        this.arr = arr;
    }

    public void run() {
        if(arr.length == 0)
            return;
        int min = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(min > arr[i])
                min = arr[i];
        }
        this.min = min;
    }

    public int getMin(){
        return min;
    }
}
