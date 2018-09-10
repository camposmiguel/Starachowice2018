package com.miguelcr.a02_customlistview;

class Student {
    private String name;
    private String location;
    private int age;
    private String photoUrl;

    // Generate > Constructor
    public Student(String name, String location, int age, String photoUrl) {
        this.name = name;
        this.location = location;
        this.age = age;
        this.photoUrl = photoUrl;
    }

    // Generate > Getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
