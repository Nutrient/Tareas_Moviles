package com.example.carlo.tarea1;

public class Alumno {
    String name;
    String phone;
    String scolarship;
    String gender;
    String book;
    String sports;

    public Alumno(String name, String phone, String scolarship, String gender, String book, String sports) {
        this.name = name;
        this.phone = phone;
        this.scolarship = scolarship;
        this.gender = gender;
        this.book = book;
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", scolarship='" + scolarship + '\'' +
                ", gender='" + gender + '\'' +
                ", book='" + book + '\'' +
                ", sports='" + sports + '\'' +
                '}';
    }
}
