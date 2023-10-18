package com.example.eleventhhw;

import java.util.ArrayList;

public class ManufacturerHistory {
    private ArrayList<String> urls;

    private String text;

    public ManufacturerHistory(String text,ArrayList<String> urls){
        this.text = text;
        this.urls = urls;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public String getText() {
        return text;
    }
}
