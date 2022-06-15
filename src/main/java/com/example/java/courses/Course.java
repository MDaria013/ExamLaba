package com.example.java.courses;

import com.example.java.humans.Student;
import com.example.java.humans.Teacher;

import java.util.HashSet;
import java.util.Set;

public abstract class Course {
    private String name;
    private String subject;
    private String science;
    private String format;
    private int occupancy;

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

    public void setSubject(String subject){this.subject=subject;}

    public String getScience(){return this.science;}

    public void setScience(String science) {this.science=science;}

    public String getFullName(){return getScience()+" "+getSubject()+" "+getFormat()+" "+getName();}

    public int getOccupancy(){return this.occupancy;}

    public void setOccupancy(int occupancy){
        this.occupancy=occupancy;
    }

    public abstract void setCourseData(String name, String science, String subject);

    Set<Teacher> teachers = new HashSet<>();

    public Set getTeachers() {
        return teachers;
    }

    public void setTeachers(Set teachers) {
        this.teachers = teachers;
    }

    Set<Student> students = new HashSet<>();

    public Set getStudents() {
        return students;
    }

    public void setStudents(Set students) {
        this.students = students;
    }

}


