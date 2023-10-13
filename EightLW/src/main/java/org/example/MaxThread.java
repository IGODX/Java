package org.example;

public class MaxThread extends Thread {
    private int[] arr;

    private int max;
    public MaxThread(int[]arr){
        this.arr = arr;
    }

    public void run() {
        if(arr.length == 0)
            return;
        int max = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(max < arr[i])
                max = arr[i];
        }
        this.max = max;
    }
    public int getMax(){
        return max;
    }
}
