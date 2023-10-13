package org.example;

public class TV {
    private String model;
    private int year;
    private double price;
    private double screenSize;
    private String manufacturer;


    // Constructor
    public TV(String model, int year, double price, double screenSize, String manufacturer) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.screenSize = screenSize;
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Television " + model + " (" + year + ") - Price: " + price + " UAH, Screen Size: " + screenSize + " inches, Manufacturer: " + manufacturer;
    }
}
