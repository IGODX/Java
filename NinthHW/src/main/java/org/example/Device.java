package org.example;

public class Device {
    private String name;
    private int yearOfManufacture;
    private double price;
    private String color;
    private String deviceType;

    public Device(String name, int yearOfManufacture, double price, String color, String deviceType) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.color = color;
        this.deviceType = deviceType;
    }

    public String getColor() {
        return color;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    public String getDeviceType() {
        return deviceType;
    }

    @Override
    public String toString() {
        return "Device" + name +
                ", year : " + yearOfManufacture +
                ", price : " + price +
                ", color : " + color +
                ", deviceType : " + deviceType;
    }
}
