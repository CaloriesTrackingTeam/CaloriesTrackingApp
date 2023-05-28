package com.example.caloriestracking.model;

public class Exercisek {

    private int exerciseID;
    private String exerciseName;
    private String exerciseAvatar;
    private double exerciseCalories;
    private double minutes;
    private String exerciseDescription;
    private String guide;
    //---------------

    public Exercisek(String exerciseName, double exerciseCalories, double minutes) {
        this.exerciseName = exerciseName;
        this.exerciseCalories = exerciseCalories;
        this.minutes = minutes;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseAvatar() {
        return exerciseAvatar;
    }

    public void setExerciseAvatar(String exerciseAvatar) {
        this.exerciseAvatar = exerciseAvatar;
    }

    public double getExerciseCalories() {
        return exerciseCalories;
    }

    public void setExerciseCalories(double exerciseCalories) {
        this.exerciseCalories = exerciseCalories;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public Exercisek(int exerciseID, String exerciseName, String exerciseAvatar, double exerciseCalories, double minutes, String exerciseDescription, String guide) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseAvatar = exerciseAvatar;
        this.exerciseCalories = exerciseCalories;
        this.minutes = minutes;
        this.exerciseDescription = exerciseDescription;
        this.guide = guide;
    }
}
