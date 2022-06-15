package com.example.java;

import com.example.java.courses.Course;
import com.example.java.humans.Student;
import com.example.java.humans.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HumanFabric {

    private HumanGenerator hG;

    HumanFabric(File file)  throws IOException, InvalidFormatException {
        hG = new HumanGenerator(file);
    }

    public Student CreateStudent(){
        Student student=null;
        for (int i=0; i<60; i++){
            double rn=Math.random();
            if (rn>0.6)
                student = new Student(hG.GeneratorFemale_Surname(hG.getMale_Surname()),hG.Generator(hG.getFemale_name()),hG.GeneratorGroup(),hG.Generator(hG.getScience()),hG.Generator(hG.getSubject()),hG.Generator(hG.getFormat()),hG.GeneratorStudentRating());
            else
                student = new Student(hG.Generator(hG.getMale_Surname()), hG.Generator(hG.getMale_name()),hG.GeneratorGroup(),hG.Generator(hG.getScience()),hG.Generator(hG.getSubject()),hG.Generator(hG.getFormat()),hG.GeneratorStudentRating());
        }
        return student;
    }


    public Teacher CreateTeacher(){
        Teacher teacher=null;
        for (int i=0; i<18; i++){
            double rn=Math.random();
            if (rn>0.6)
                teacher = new Teacher(hG.GeneratorFemale_Surname(hG.getTMale_Surname()), hG.Generator(hG.getFemale_name()), hG.GeneratorFemale_patronomyc(hG.getPatronymic()),hG.GeneratorFaculty(),hG.GeneratorTeacherRating());
            else
                teacher = new Teacher(hG.Generator(hG.getTMale_Surname()),hG.Generator(hG.getMale_name()), hG.Generator(hG.getPatronymic()),hG.GeneratorFaculty(),hG.GeneratorTeacherRating());
        }
       // teacher.setCourses(hG.GeneratorCourses(courses));
        return teacher;
    }
}
