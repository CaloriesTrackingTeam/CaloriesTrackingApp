package com.example.caloriestracking.model;

import java.sql.Date;

public class Track {
    private int id;

    private Date date;
    private float calo;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getCalo() {
        return calo;
    }

    public void setCalo(float calo) {
        this.calo = calo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Track(Date date, float calo, User user) {
        this.date = date;
        this.calo = calo;
        this.user = user;
    }
}
