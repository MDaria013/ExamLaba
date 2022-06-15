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

    private ThreadLocalRandom random;
    private CourseGenerator cG;
    public CourseFabric(CourseGenerator cG) {
        this.cG=cG;
    }

    public Course CreateCourses(){
        Course course=null;
        int rand = ThreadLocalRandom.current().nextInt(0, 100);
        if (rand < 30) {
            course =  new CourseTheoretical();
            int rn = random.current().nextInt(0, cG.getSubject().length);
            course.setCourseData(cG.getName()[rn],
                    cG.getScience()[random.current().nextInt(0, cG.getScience().length)],
                    cG.getSubject()[rn]);
            return course;
        }else if (rand<60) {
            course =  new CoursePractical();
            int rn = random.current().nextInt(0, cG.getSubject().length);
            course.setCourseData(cG.getName()[rn],
                    cG.getScience()[random.current().nextInt(0, cG.getScience().length)],
                    cG.getSubject()[rn]);
            return course;
        }else  {
            course =  new CourseProject();
            int rn = random.current().nextInt(0, cG.getSubject().length);
            course.setCourseData(cG.getName()[rn],
                    cG.getScience()[random.current().nextInt(0, cG.getScience().length)],
                    cG.getSubject()[rn]);
            return course;
        }
    }

}