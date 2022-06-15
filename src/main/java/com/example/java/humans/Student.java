package com.example.java.humans;

public class Student extends Human{
    private String group;
    private String subject;
    protected String format;
    private String science;

    public Student(String name, String surname, String group, String science,String subject, String format, Integer rating) {
        super(name, surname,rating);
        this.group = group;
        this.science = science;
        this.subject=subject;
        this.format=format;
    }

    public Student() {

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

}
