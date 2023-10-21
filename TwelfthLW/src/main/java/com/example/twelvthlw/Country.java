package com.example.twelvthlw;

public class Country {
    private String countryName;

    private String id;

    public Country( String id, String countryName){

        this.id = id;
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getId() {
        return id;
    }
}
