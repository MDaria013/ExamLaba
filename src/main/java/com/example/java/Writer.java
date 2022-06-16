package com.example.java;


import javafx.application.Application;
import com.example.java.courses.Course;
import com.example.java.courses.CoursePractical;
import com.example.java.courses.CourseProject;
import com.example.java.courses.CourseTheoretical;
import com.example.java.humans.Student;
import com.example.java.humans.Teacher;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;

public class Writer {

    public void writeTree(TreeView tree, ArrayList<Course> courses, ArrayList<Teacher> teachers, ArrayList<Student> students) {

        int theorNum = 0;
        int projNum = 0;
        int practNum = 0;

        int g=0;


        TreeItem<String> rootItem = new TreeItem<>();
        rootItem.setExpanded(true);
        TreeItem<String> projBranchItem = new TreeItem<>();
        rootItem.getChildren().add(projBranchItem);
        TreeItem<String> practBranchItem = new TreeItem<>();
        rootItem.getChildren().add(practBranchItem);
        TreeItem<String> theorBranchItem = new TreeItem<>();
        rootItem.getChildren().add(theorBranchItem);

        for (Course course:courses) {
        g=g+course.getOccupancy();

            TreeItem<String> c = new TreeItem<>("'" + course.getName() + "' "+course.getOccupancy());
            if (course instanceof CourseTheoretical){
                theorBranchItem.getChildren().add(c);
                theorNum++;
            } else if (course instanceof CoursePractical){
                practBranchItem.getChildren().add(c);
                practNum++;
            }else if (course instanceof CourseProject){
                projBranchItem.getChildren().add(c);
                projNum++;
            }

            c.getChildren().add(new TreeItem<>("Наука : " + course.getScience()));
            c.getChildren().add(new TreeItem<>("Предмет : " + course.getSubject()));
            c.getChildren().add(new TreeItem<>("Формат : " + course.getFormat()));



            course.getTeachers().forEach((obj) -> {
                Teacher teacher = (Teacher) obj;

                TreeItem<String> teacherItem = new TreeItem<>("Преподаватель: " + teacher.getFullName());
                c.getChildren().add(teacherItem);
                teacherItem.getChildren().add(new TreeItem<>("Факультет : " + teacher.getFaculty()));
                teacherItem.getChildren().add(new TreeItem<>("Рейтинг : " + teacher.getRating()));

            });

            TreeItem<String> studentItem = new TreeItem<>("Студенты: " );
            c.getChildren().add(studentItem);

            course.getStudents().forEach((obj) -> {
                Student student = (Student) obj;

                studentItem.getChildren().add(new TreeItem<>(student.getId()+". " +student.getFullName() + " " + student.getPreference()));

            });

        }

        rootItem.setValue("Курсы "+g);
        practBranchItem.setValue("Практические ("+practNum+")");
        projBranchItem.setValue("Проектные ("+projNum+")");
        theorBranchItem.setValue("Теоретические ("+theorNum+")");

        tree.setRoot(rootItem);
    }

   }