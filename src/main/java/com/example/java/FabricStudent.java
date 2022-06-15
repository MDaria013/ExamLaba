package com.example.java;

import com.example.java.humans.Human;
import com.example.java.humans.Student;

public class FabricStudent extends Fabric{


    public FabricStudent(HumanGenerator hG) {
        super(hG);
    }

    @Override
    public Student CreateData() {
        Student student;
        double rn=Math.random();
        if (rn>0.6)
            student = new Student(hG.GeneratorFemale_Surname(hG.getMale_Surname()),hG.Generator(hG.getFemale_name()),hG.GeneratorGroup(),hG.Generator(hG.getScience()),hG.Generator(hG.getSubject()),hG.Generator(hG.getFormat()),hG.GeneratorStudentRating());
        else
            student = new Student(hG.Generator(hG.getMale_Surname()), hG.Generator(hG.getMale_name()),hG.GeneratorGroup(),hG.Generator(hG.getScience()),hG.Generator(hG.getSubject()),hG.Generator(hG.getFormat()),hG.GeneratorStudentRating());
        return student;
    }

}
