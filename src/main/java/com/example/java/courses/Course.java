package com.example.java.courses;

import com.example.java.humans.Student;
import com.example.java.humans.Teacher;

import java.util.HashSet;

public abstract class Course {
    private String name;
    private String subject;
    private String science;
    private String format;
    private int occupancy;

    public Course(String science, String subject, String name) {
        this.science=science;
        this.subject=subject;
        this.name=name;
    }

    public Course() {

    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {this.format=format;}

    public String getName() {
        return this.name;
    }
    public void setName(String name) {this.name=name;}

    public String getSubject() {
        return this.subject;
    }

    public String getScience(){return this.science;}

    public void setScience(String science) {this.science=science;}

    public String getFullName(){return getScience()+" "+getSubject()+" "+getFormat()+" "+getName();}

    public int getOccupancy(){return this.occupancy;}

    public void setOccupancy(int occupancy){
        this.occupancy=occupancy;
    }


    HashSet<Teacher> teachers = new HashSet<>();

    public HashSet getTeachers() {
        return teachers;
    }

    public void setTeachers(HashSet teachers) {
        this.teachers = teachers;
    }


//    HashSet<Student> students = new HashSet<>();
//
//    public HashSet getStudents() {
//        return students;
//    }
//
//    public void setStudents(HashSet students) {
//        this.students = students;
//    }
}

