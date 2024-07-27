package com.lab6.textprocessinganddatamanagementtoolteamproject.model;

public class CarModel {
    String name;
    int price;

    public CarModel(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
