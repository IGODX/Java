package com.example.eleventhhw;

import java.util.ArrayList;

public class ModelDetails {
   private ArrayList<String> imageUrls;

   private String description;

   public ModelDetails(ArrayList<String> imageUrls, String description){
       this.imageUrls = imageUrls;
       this.description = description;
   }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }
}
