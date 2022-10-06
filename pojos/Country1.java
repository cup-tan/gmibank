package com.gmibank.pojos;

public class Country1 { // country nin icindeki veriler

    private int id;
    private String name;
    private String states;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
/*
     "country": {
            "id": 3,
            "name": "USA",
            "states": null
        },
     */
}
