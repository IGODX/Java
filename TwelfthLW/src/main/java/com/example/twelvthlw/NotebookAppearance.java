package com.example.twelvthlw;

public class NotebookAppearance {
    private String id;

    private String appearance;

    public NotebookAppearance(String id, String appearance){

        this.id = id;
        this.appearance = appearance;
    }

    public String getId() {
        return id;
    }

    public String getAppearance() {
        return appearance;
    }
}
