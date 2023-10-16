package com.example.eleventhlw;

public class Showplace {
    private String name;
    private String imagePath;

    public Showplace(String name, String imagePath){
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "Showplace name : " + name;
    }
}
