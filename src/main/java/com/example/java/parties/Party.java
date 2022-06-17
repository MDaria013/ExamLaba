package com.example.java.parties;

import com.example.java.humans.Student;

import java.util.HashSet;
import java.util.Set;

public class Party {

    private String name;
    private String focus;
    private int occupancy = 0;
    Set<Student> students = new HashSet<>();

    public Party() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {this.name=name;}

    public String getFocus() {
        return this.focus;
    }

    public void setFocus(String focus) {this.focus=focus;}

    public int getOccupancy(){return this.occupancy;}

    public void setOccupancy(int occupancy){
        this.occupancy=occupancy;
    }

    public void addOccupancy(){
        this.occupancy+=1;
    }

    public Set getStudents() {
        return students;
    }

    public void setStudents(Set students) {
        this.students = students;
    }

}


