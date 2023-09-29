package org.example;

import java.util.Scanner;

public class Person {
    private String fullName;
    private String birthDate;
    private String phoneNumber;
    private String city;
    private String country;
    private String homeAddress;
    public Person(){}
    public Person(String fullName, String birthDate, String phoneNumber, String city, String country, String homeAddress) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.homeAddress = homeAddress;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ПІБ: ").append(fullName).append("\n");
        builder.append("Дата народження: ").append(birthDate).append("\n");
        builder.append("Контактний телефон: ").append(phoneNumber).append("\n");
        builder.append("Місто: ").append(city).append("\n");
        builder.append("Країна: ").append(country).append("\n");
        builder.append("Домашня адреса: ").append(homeAddress);
        return builder.toString();
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ПІБ: ");
        fullName = scanner.nextLine();
        System.out.print("Введіть дату народження: ");
        birthDate = scanner.nextLine();
        System.out.print("Введіть контактний телефон: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Введіть місто: ");
        city = scanner.nextLine();
        System.out.print("Введіть країну: ");
        country = scanner.nextLine();
        System.out.print("Введіть домашню адресу: ");
        homeAddress = scanner.nextLine();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}