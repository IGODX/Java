package com.example.eleventhlw;

public class City {
    private String name;
    private String country;
    private String imagePath;
    private int population;
    private String description;

    public City(String name, String country, String imagePath, int population, String description){
        this.country = country;
        this.name = name;
        this.imagePath = imagePath;
        this.population = population;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }
}