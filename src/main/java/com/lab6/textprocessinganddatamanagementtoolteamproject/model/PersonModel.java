package com.lab6.textprocessinganddatamanagementtoolteamproject.model;

public class PersonModel {
    int id;
    String name;

    public PersonModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
