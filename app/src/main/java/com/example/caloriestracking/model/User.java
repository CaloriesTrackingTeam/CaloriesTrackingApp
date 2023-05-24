package com.example.caloriestracking.model;

public class User {

    private int userID;

    private String fullName;

    private int age;

    private double weight;

    private double height;

    private String sex;

    private String target;

    private String avatar;

    private String email;

    private String password;

    private int role;   //0:user, 1:admin

    private boolean premium;

    private double Carbs;       //này hình như là để dự đoán cân năng
    private double protein;     //này hình như là để dự đoán cân năng
    private double fat;         //này hình như là để dự đoán cân năng
    //--------------------------------------------------------------


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public double getCarbs() {
        return Carbs;
    }

    public void setCarbs(double carbs) {
        Carbs = carbs;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public User() {
    }

    public User(int userID, String fullName, int age, double weight, double height, String sex, String target, String avatar, String email, String password, int role, boolean premium, double carbs, double protein, double fat) {
        this.userID = userID;
        this.fullName = fullName;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.target = target;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.role = role;
        this.premium = premium;
        Carbs = carbs;
        this.protein = protein;
        this.fat = fat;
    }
}
