package com.iteso.test.beans;

public class ItemProduct {
    private int image;
    String title, store, location, phone, description;


    public ItemProduct() {
        this.image = 0;
        this.title = "";
        this.store = "";
        this.location = "";
        this.phone = "";
        this.description = "";
    }

    public ItemProduct(int image, String title, String store, String location, String phone, String description) {
        this.image = image;
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
