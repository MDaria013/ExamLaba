package com.example.java.courses;

import java.util.concurrent.ThreadLocalRandom;

public class CourseTheoretical extends Course{

    @Override
    public void setCourseData(String name, String science, String subject) {
        setScience(science);
        setSubject(subject);
        setFormat("теоретический");
        int nextInt = ThreadLocalRandom.current().nextInt(0, 100);
        if (nextInt < 50) {
            setName("Основы " + name);
        } else {
            setName("Теоретические основы " + name);
        }
    }
}
