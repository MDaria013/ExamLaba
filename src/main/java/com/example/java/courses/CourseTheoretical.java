package com.example.java.courses;

public class CourseTheoretical extends Course{
    public CourseTheoretical(String science, String subject, String name) {
        super(science, subject, name);
        setFormat("теоретический");
    }
}
