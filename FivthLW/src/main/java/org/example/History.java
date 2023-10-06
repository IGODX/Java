package org.example;
import java.util.Date;
public class History {
    private String userName;
    private int priority;

    private Date date;

    public History(String userName, Date date, int priority){
        this.userName = userName;
        this.date = date;
        this.priority = priority;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDate() {
        return date;
    }

    public int getPriority(){
        return priority;
    }
    @Override
    public String toString(){
        return "User name : " + userName + " Date : " + date;
    }
}
