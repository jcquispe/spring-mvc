package com.juanky.model;

public class Grade {
    private String cod;
    private String title;
    private String description;

    public Grade() {
    }

    public Grade(String cod, String title, String description) {
        this.cod = cod;
        this.title = title;
        this.description = description;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
