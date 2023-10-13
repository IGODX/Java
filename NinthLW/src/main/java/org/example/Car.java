package org.example;

public class Car {
    private String brand;
    private int year;
    private double price;
    private String color;
    private double engineVolume;

    public Car(String brand, int year, double price, String color, double engineVolume) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.color = color;
        this.engineVolume = engineVolume;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Car " + brand + " (" + year + ") - Price: " + price + " $, Color: " + color + ", Engine volume: " + engineVolume + " l";
    }
}
