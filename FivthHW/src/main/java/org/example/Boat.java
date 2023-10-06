package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Boat {
    private int id;
    private int capacity;

Random random = new Random();
    private ArrayList<Passenger> passengers = new ArrayList<>();
    public Boat(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    public boolean addPassenger(Passenger passenger){
       return passengers.add(passenger);
    }
    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
    public void removePassengers(){
        int number = passengers.size();
        if (number > 0) {
            int passengersToRemove = random.nextInt(number);
            for (int i = passengersToRemove - 1; i >= 0; i--) {
                passengers.remove(i);
            }
        }
    }
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void endStop(){
        passengers = new ArrayList<>();
    }
}
