package org.example;

import java.util.Date;

public class Client {
    private String userName;
    private int priority;

    private Date date;

    public Client(String userName, int priority){
        this.userName = userName;
        this.priority = priority;
        date = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public int getPriority() {
        return priority;
    }

    public Date getDate(){
        return date;
    }
}
