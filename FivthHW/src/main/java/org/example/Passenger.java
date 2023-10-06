package org.example;

public class Passenger {
    private int id;
    private int timeSpentAtStop;

    public Passenger(int id, int timeSpentAtStop) {
        this.id = id;
        this.timeSpentAtStop = timeSpentAtStop;
    }

    public int getId() {
        return id;
    }

    public int getTimeSpentAtStop() {
        return timeSpentAtStop;
    }
}
