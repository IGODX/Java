package com.example.eleventhhw;

public class LaptopModel {
    private String description;

    private String imageUrl;

    public LaptopModel(String description, String imageUrl){

        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
