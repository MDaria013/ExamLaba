package com.example.java.humans;

public abstract class Human {
    protected String name;
    protected String surname;
    protected Integer rating;

    public Human(String surname, String name, Integer rating) {
        this.name = name;
        this.surname = surname;
        this.rating=rating;
    }

//    public Human() {
//
//    }

    public abstract String getFullName();

    public void setRating(Integer rating){this.rating = rating;}

    public Integer getRating(){
        return this.rating;
    };

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

