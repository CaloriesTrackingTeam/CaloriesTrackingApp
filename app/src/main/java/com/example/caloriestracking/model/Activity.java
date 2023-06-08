package com.example.caloriestracking.model;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private int activityID;

    private String activityName;

    private String activityAvatar;

    private double activityCalories;

    private String activityDescription;

    private double minutes;

    private String guide;

    private List<User> users = new ArrayList<>();

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityAvatar() {
        return activityAvatar;
    }

    public void setActivityAvatar(String activityAvatar) {
        this.activityAvatar = activityAvatar;
    }

    public double getActivityCalories() {
        return activityCalories;
    }

    public void setActivityCalories(double activityCalories) {
        this.activityCalories = activityCalories;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Activity(){}

    public Activity(String activityName) {
        this.activityName = activityName;
    }

    public Activity(int activityID, String activityName, String activityAvatar, double activityCalories, String activityDescription, double minutes, String guide, List<User> users) {
        this.activityID = activityID;
        this.activityName = activityName;
        this.activityAvatar = activityAvatar;
        this.activityCalories = activityCalories;
        this.activityDescription = activityDescription;
        this.minutes = minutes;
        this.guide = guide;
        this.users = users;
    }

    public Activity(int exerciseID, String exerciseName, String exerciseAvatar, double exerciseCalories, double minutes, String exerciseDescription, String guide) {
        this.activityID = exerciseID;
        this.activityName = exerciseName;
        this.activityAvatar = exerciseAvatar;
        this.activityCalories = exerciseCalories;
        this.minutes = minutes;
        this.activityDescription = exerciseDescription;
        this.guide = guide;
    }
}
