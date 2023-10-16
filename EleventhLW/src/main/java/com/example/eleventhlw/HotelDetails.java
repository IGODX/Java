package com.example.eleventhlw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HotelDetails {
    private ArrayList<String> additionalPhotos;

    private String description;

    public HotelDetails(List<String> additionalPhotos, String description){
        this.additionalPhotos = new ArrayList<>(additionalPhotos);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getAdditionalPhotos() {
        return additionalPhotos;
    }
}
