package com.example.java;


import com.example.java.courses.Course;
import com.example.java.courses.CoursePractical;
import com.example.java.courses.CourseProject;
import com.example.java.courses.CourseTheoretical;
import com.example.java.humans.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CourseFabric {


    private CourseGenerator cG;
    private ThreadLocalRandom random;

    CourseFabric(File file) throws IOException, InvalidFormatException {
        cG = new CourseGenerator(file);
    }


    public Course CreateCourses(){
        Course course=null;
            double rn=Math.random();
            if (rn<0.3)
                course = CreateTeor();
            else if (rn>0.3 & rn<0.6)
                course = CreatePract();
            else course = CreateProj();

            //course = new Course(Generator(anImport.getScience()),Generator(anImport.getSubject()), Generator(anImport.getName()));
       // course.setTeachers(cG.GeneratorTeachers(t));
        return course;
    }


    public Course CreateTeor() {
        Course course = null;
        course =  new CourseTheoretical(cG.Generator(cG.getScience()),cG.Generator(cG.getSubject()), cG.GeneratorTeor(cG.getName()));
        return course;
    }

    public Course CreatePract() {
        Course course = null;
        course =  new CoursePractical(cG.Generator(cG.getScience()),cG.Generator(cG.getSubject()), cG.GeneratorPract(cG.getName()));
        return course;
    }

    public Course CreateProj() {
        Course course = null;
        course =  new CourseProject(cG.Generator(cG.getScience()),cG.Generator(cG.getSubject()), cG.GeneratorProj(cG.getName()));
        return course;
    }


}
