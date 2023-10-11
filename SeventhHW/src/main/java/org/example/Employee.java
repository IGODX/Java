package org.example;

public class Employee {
    private String surname;
    private int age;

    public Employee(String surname, int age) {
        this.surname = surname;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Surname: " + surname + ", Вік: " + age;
    }
}