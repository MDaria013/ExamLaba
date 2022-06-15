package com.example.java.courses;

import java.util.concurrent.ThreadLocalRandom;

public class CourseProject extends Course{

    @Override
    public void setCourseData(String name, String science, String subject) {
        setScience(science);
        setSubject(subject);
        setFormat("проектный");
        int nextInt = ThreadLocalRandom.current().nextInt(0, 100);
        if (nextInt < 50) {
            setName("Основы " + name +" (Курсовой проект)");
        } else {
            setName("Основы " + name+" (Курсовая работа)");
        }

    }
}
