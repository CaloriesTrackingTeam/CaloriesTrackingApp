package com.example.caloriestracking.model;

import java.util.ArrayList;
import java.util.List;

public class Food {

    private int foodID;

    private String foodName;

    private String foodAvatar;

    private double foodCalories;

    private String foodDescription;

    private String recipe;

    private double foodWeight;      //gram

    private double foodCarbs;   //tinh bột

    private double foodProtein; //

    private double foodFat;     //chất béo

    private List<User> users = new ArrayList<>();   //food liked by user

    //--------------------------------------------------------

    public Food(String foodName, double foodCalories, double foodWeight) {
        this.foodName = foodName;
        this.foodCalories = foodCalories;
        this.foodWeight = foodWeight;
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodAvatar() {
        return foodAvatar;
    }

    public void setFoodAvatar(String foodAvatar) {
        this.foodAvatar = foodAvatar;
    }

    public double getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(double foodCalories) {
        this.foodCalories = foodCalories;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public double getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(double foodWeight) {
        this.foodWeight = foodWeight;
    }

    public double getFoodCarbs() {
        return foodCarbs;
    }

    public void setFoodCarbs(double foodCarbs) {
        this.foodCarbs = foodCarbs;
    }

    public double getFoodProtein() {
        return foodProtein;
    }

    public void setFoodProtein(double foodProtein) {
        this.foodProtein = foodProtein;
    }

    public double getFoodFat() {
        return foodFat;
    }

    public void setFoodFat(double foodFat) {
        this.foodFat = foodFat;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Food() {
    }

    public Food(int foodID, String foodName, String foodAvatar, double foodCalories, String foodDescription, String recipe, double foodWeight, double foodCarbs, double foodProtein, double foodFat, List<User> users) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodAvatar = foodAvatar;
        this.foodCalories = foodCalories;
        this.foodDescription = foodDescription;
        this.recipe = recipe;
        this.foodWeight = foodWeight;
        this.foodCarbs = foodCarbs;
        this.foodProtein = foodProtein;
        this.foodFat = foodFat;
        this.users = users;
    }
}
