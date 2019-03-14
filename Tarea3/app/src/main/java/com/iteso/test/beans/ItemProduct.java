package com.iteso.test.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {
    private int image, code;
    String title, store, location, phone, description;


    public ItemProduct() {
        this.image = 0;
        this.code = 0;
        this.title = "";
        this.store = "";
        this.location = "";
        this.phone = "";
        this.description = "";
    }

    public ItemProduct (Parcel in) {
        image = in.readInt();
        code = in.readInt();
        title = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        description = in.readString();
    }

    public ItemProduct(int image, String title, String store, String location, String phone, String description, int code) {
        this.image = image;
        this.code = code;
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.description = description;
    }

    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel in) {
            return new ItemProduct(in);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeInt(code);
        parcel.writeString(title);
        parcel.writeString(store);
        parcel.writeString(location);
        parcel.writeString(phone);
        parcel.writeString(description);
    }
}
