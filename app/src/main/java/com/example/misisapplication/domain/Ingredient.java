package com.example.misisapplication.domain;

public class Ingredient {

    private int id;
    private int weight;

    public Ingredient(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }


}
