package org.example;

public class Projector {
    private String name;
    private int yearOfManufacture;
    private double price;
    private String manufacturer;

    public Projector(String name, int yearOfManufacture, double price, String manufacturer) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    @Override
    public String toString() {
        return "Projector: " + name +
                ", Year of Manufacture: " + yearOfManufacture +
                ", Price: $" + price +
                ", Manufacturer: " + manufacturer;
    }
}
