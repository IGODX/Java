package org.example;

public class City {
    private String cityName;
    private String regionName;
    private String countryName;
    private int population;
    private String postalCode;
    private String phoneNumber;

    public City(){}
    public City(String cityName, String regionName, String countryName, int population, String postalCode, String phoneNumber) {
        this.cityName = cityName;
        this.regionName = regionName;
        this.countryName = countryName;
        this.population = population;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Назва міста: " + cityName + "\n");
        builder.append("Назва країни: " + countryName + "\n");
        builder.append("Кількість жителів: " + population + "\n");
        builder.append("Поштовий індекс: " + postalCode + "\n");
        builder.append("Телефонний код: " + phoneNumber + "\n");
        return builder.toString();
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}