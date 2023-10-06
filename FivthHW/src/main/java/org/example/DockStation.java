package org.example;

import java.util.ArrayList;
import java.util.Random;

public class DockStation {
    private int passengersAtStop = 0;
    Random random = new Random();


    public int getPassengersAtStop() {
        return passengersAtStop;
    }

    private Boat[] boats;

    public Boat[] getBoats() {
        return boats;
    }

    public DockStation(int numberOfBoats, int boatCapacity){
        boats = new Boat[numberOfBoats];
        for(int i = 0; i<numberOfBoats;i++)
            boats[i] = (new Boat(i, boatCapacity));
    }

    public void passengersEnterTheBoat(int boatId, int numberOfPassengers){
        System.out.println("Passenger is entering the boat " + boatId);
        passengersAtStop+=numberOfPassengers;
        int capacity = boats[boatId].getCapacity();
        for(int i = 0; i<numberOfPassengers; i++){
        if(boats[boatId].getPassengers().size() <= capacity)
            boats[boatId].addPassenger(new Passenger(1, random.nextInt(30)));
            passengersAtStop--;
        }
    }
    public void passengersLeaveTheBoat(int boatId){
        System.out.println("Passengers are leaving the boat " + boatId);
        boats[boatId].removePassengers();

    }

    public void endStop(){
        System.out.println("End stop");
        for(int i = 0;i<boats.length; i++){
         boats[i].endStop();
        }
    }


}
