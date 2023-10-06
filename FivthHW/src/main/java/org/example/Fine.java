package org.example;

import java.util.Date;

public class Fine {
    private String id;
    private String type;
    private double amount;
    private String city;
    private Date date;

    private String personId;

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCity() {
        return city;
    }

    public String getPersonId() {
        return personId;
    }

    public String getType() {
        return type;
    }

    public Fine(String id, String personId, String type, double amount, String city, Date date){
        this.id = id;
        this.personId = personId;
        this.type = type;
        this.amount = amount;
        this.city = city;
        this.date = date;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Fine with Id : " + id + "\n");
        builder.append("Person id : " + personId + "\n");
        builder.append("Fine type : " + type + "\n");
        builder.append("Amount to pay : " + amount + "\n");
        builder.append("City : " + city + "\n");
        builder.append("Date : " + date + "\n");
        return builder.toString();
    }
}