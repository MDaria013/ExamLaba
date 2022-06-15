package com.example.java.courses;

public class CourseProject extends Course{
    public CourseProject(String science, String subject, String name) {
        super(science, subject, name);
        setFormat("проектный");
    }
}
