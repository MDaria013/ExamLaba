package com.example.java.humans;

import com.example.java.courses.Course;

public class Student extends Human{
    private String group;
    private String subject;
    protected String format;
    private String science;
    private int Id;
    private int course=0;

    public Student(String name, String surname, String group, String science,String subject, String format, Integer rating) {
        super(name, surname,rating);
        this.group = group;
        this.science = science;
        this.subject=subject;
        this.format=format;
    }


    @Override
    public String getFullName() {
        return getSurname()+" "+getName()+" - "+getGroup()+" = "+getRating();
    }

    public String getPreference(){return getScience()+" "+getSubject()+" "+getFormat();}

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {this.format=format;}

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject=subject;
    }

    public String getScience() {
        return this.science;
    }

    public void setScience(String science) {
        this.science=science;
    }

    public String getGroup(){
        return this.group;
    }

    public void setGroup(String group){
        this.group=group;
    }

    public int getId(){return  this.Id;}

    public void setId(int Id){this.Id=Id;}

    public int getCourse(){return this.course;}

    public void setCourse(int course){
        this.course=course;}

}
