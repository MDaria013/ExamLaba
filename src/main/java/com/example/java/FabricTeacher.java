package com.example.java;

import com.example.java.humans.Teacher;

public class FabricTeacher extends Fabric{

    public FabricTeacher(HumanGenerator hG) {
        super(hG);
    }

    @Override
    public Teacher CreateData() {
        Teacher teacher=null;
        for (int i=0; i<18; i++){
            double rn=Math.random();
            if (rn>0.6)
                teacher = new Teacher(hG.GeneratorFemale_Surname(hG.getTMale_Surname()), hG.Generator(hG.getFemale_name()), hG.GeneratorFemale_patronomyc(hG.getPatronymic()),hG.GeneratorFaculty(),hG.GeneratorTeacherRating());
            else
                teacher = new Teacher(hG.Generator(hG.getTMale_Surname()),hG.Generator(hG.getMale_name()), hG.Generator(hG.getPatronymic()),hG.GeneratorFaculty(),hG.GeneratorTeacherRating());
        }
        return teacher;
    }
}
