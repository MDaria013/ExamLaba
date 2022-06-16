package com.example.java.humans;


import com.example.java.courses.Course;

import java.util.HashSet;

public class Teacher extends Human{
    private String patronymic;
    private int faculty;
    private int count;

    public Teacher(String surname, String name, String patronymic, int faculty, int rating) {
        super(surname, name, rating);
        this.patronymic = patronymic;
        this.faculty = faculty;
    }

    public Integer getRating() {
        return this.rating;
    }

    @Override
    public String getFullName() {
        return getSurname()+" "+getName()+" "+getPatronymic();
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public int getFaculty() {
        return this.faculty;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setFaculty(int faculty) {
        this.faculty = faculty;
    }

    public int getCount(){return this.count;}

    public void setCount(int count){this.count=count;}

    HashSet<Course> teachers = new HashSet<>();

    public HashSet getCourses() {
        return teachers;
    }

    public void setCourses(HashSet teachers) {
        this.teachers = teachers;
    }

}
