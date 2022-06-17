package com.example.java.humans;

import com.example.java.courses.Course;

public class Student extends Human {
    private String group;
    private String subject;
    protected String format;
    private String science;
    private boolean desire;
    private String focus;
    private String party;


    public Student(String name, String surname, String group, String science, String subject, String format, Integer rating, boolean desire, String focus, String party) {
        super(name, surname, rating);
        this.group = group;
        this.science = science;
        this.subject = subject;
        this.format = format;
        this.desire = desire;
        this.focus = focus;
        this.party = party;
    }


    @Override
    public String getFullName() {
        return getSurname() + " " + getName() + " - " + getGroup() + " r: " + getRating();
    }

    public String getPreference() {
        return getScience() + " " + getSubject() + " " + getFormat();
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScience() {
        return this.science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getDesire() {
        return this.desire;
    }

    public void setDesire(Boolean desire) {
        this.desire = desire;
    }

    public String getFocus() {
        return this.focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getParty() {
        return this.party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}