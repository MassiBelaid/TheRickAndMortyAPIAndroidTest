package com.lilbro.rickyapitest;

public class Character {
    private String name;
    private String status;
    private String species;
    private String gender;
    private String url;

    public Character(String name, String status, String species, String gender, String url) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getUrl() {
        return url;
    }



}
