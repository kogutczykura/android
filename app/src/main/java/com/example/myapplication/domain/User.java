package com.example.myapplication.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Bike> bikes = new ArrayList<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public void addBike(Bike bike) {
        this.bikes.add(bike);
    }

    public void removeBike(Bike bike) {
        this.bikes.remove(bike);
    }
}
