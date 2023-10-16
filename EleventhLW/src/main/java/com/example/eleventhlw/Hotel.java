package com.example.eleventhlw;

public class Hotel {
    private String name;
    private String imagePath;

    public Hotel(String name, String imagePath){
        this.name = name;
        this.imagePath = imagePath;
    }
    @Override
    public String toString(){
        return "Hotel name : " + name;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
