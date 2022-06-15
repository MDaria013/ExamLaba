package com.example.java.courses;

import java.util.concurrent.ThreadLocalRandom;

public class CoursePractical extends Course{

    @Override
    public void setCourseData(String name, String science, String subject) {
        setScience(science);
        setSubject(subject);
        setFormat("практический");
        int nextInt = ThreadLocalRandom.current().nextInt(0, 100);
        if (nextInt < 50) {
            setName("Практика " + name);
        } else {
            setName("Практические основы " + name);
        }
    }
}
