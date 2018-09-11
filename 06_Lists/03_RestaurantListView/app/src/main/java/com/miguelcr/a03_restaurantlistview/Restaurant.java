package com.miguelcr.a03_restaurantlistview;

class Restaurant {
    private String name;
    private String address;
    private float rate;
    private String photo;

    public Restaurant(String name, String address, float rate, String photo) {
        this.name = name;
        this.address = address;
        this.rate = rate;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
