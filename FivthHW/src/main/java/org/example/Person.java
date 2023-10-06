package org.example;

import java.util.ArrayList;

public class Person {
    private String id;
    private String firstName;
    private String surname;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private ArrayList<Fine> fines;

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public Person(String id, String firstName, String surname){
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        fines = new ArrayList<>();
    }

    public boolean addFine(Fine fine){
       return fines.add(fine);
    }
//    public boolean removeFine(String id){
//        fines.remove(id);
//        return fines.
//    }


    public ArrayList<Fine> getFines() {
        return fines;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Person id : " + id + "\n");
        builder.append("Firstname : " + getFirstName() + "\n");
        builder.append("Surname : " + getSurname() + "\n");
        return builder.toString();
    }

}