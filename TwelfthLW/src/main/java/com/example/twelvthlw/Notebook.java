package com.example.twelvthlw;

public class Notebook {
    private int id;
    private String manufacturer;
    private String notebookName;
    private int numberOfPages;
    private boolean isCoverSoft;

    private int pageAppearanceId;
    private int countryId;

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setPageAppearanceId(int pageAppearanceId) {
        this.pageAppearanceId = pageAppearanceId;
    }

    public int getCountryId() {
        return countryId;
    }

    public int getPageAppearanceId() {
        return pageAppearanceId;
    }

    public int getId() {
        return id;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setCoverSoft(boolean coverSoft) {
        isCoverSoft = coverSoft;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
