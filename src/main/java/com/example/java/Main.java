package com.example.java;

import com.example.java.courses.Course;
import com.example.java.humans.Student;
import com.example.java.humans.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();


        HumanFabric humanFabric = null;
        CourseFabric courseFabric = null;

        File file = new File("C:\\Users\\user\\IdeaProjects\\F\\ExamLaba1.1\\examlaba.xlsx");
        try {
            humanFabric = new HumanFabric(file);
            courseFabric = new CourseFabric(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


        for (int j = 0; j < 60; j++) {
            students.add(humanFabric.CreateStudent());
        }


        for (int j = 1; j <= 18; j++) {
            teachers.add(humanFabric.CreateTeacher());
        }


        for (int j = 0; j < 30; j++) {
            courses.add(courseFabric.CreateCourses());
        }


        for (Student student : students) {
            System.out.println(student.getFullName());
        }

        System.out.println("------------");

        for (Teacher teacher : teachers) {
            System.out.println(teacher.getFullName());
        }

        System.out.println("------------");

        for (Course course : courses) {
            System.out.println(course.getFullName());
        }


    }


}
