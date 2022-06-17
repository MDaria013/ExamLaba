package com.example.java;

import com.example.java.courses.Course;
import com.example.java.humans.Student;
import com.example.java.humans.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Deccanat {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    CourseFabric courseFabric = null;
    CourseGenerator courseGenerator = null;

    HumanGenerator humanGenerator = null;
    FabricTeacher fabricTeacher = null;
    FabricStudent fabricStudent = null;
    private ThreadLocalRandom random;


    public Deccanat(File file) throws IOException, InvalidFormatException {
        this.courseGenerator = new CourseGenerator(file);
        this.courseFabric = new CourseFabric(courseGenerator);
        this.humanGenerator = new HumanGenerator(file);
        this.fabricStudent = new FabricStudent(humanGenerator);
        this.fabricTeacher = new FabricTeacher(humanGenerator);
    }

    public ArrayList<Student> CreateStudents(){
        for (int j = 0; j < 600; j++) {
            students.add(fabricStudent.CreateData());}
    //Сортировка студентов
        Collections.sort(students, Comparator.comparing(Student::getRating).reversed());

    return students;
    }

    public ArrayList<Teacher> CreateTeachers(){
     for (int j = 1; j <= 18; j++) {
        teachers.add(fabricTeacher.CreateData());
       }

    return teachers;
    }

    public ArrayList<Course> CreateCourses(ArrayList<Teacher> teachers) {
        for (int j = 0; j < 30; j++) {
            courses.add(courseFabric.CreateCourses());
        }

        GeneratorCoursesWithTeach(courses);

        //generateStudents(students, courses);

        return courses;
    }

    public void CreateCourseWithStudents(ArrayList<Student> students, ArrayList<Course> courses){
        generateStudents(students, courses);
    }


    public Teacher GeneratorTeachers(ArrayList<Teacher> teachersList, int index) {
        Teacher tch = (teachersList.get(index));
        return tch;
    }


    public void GeneratorCoursesWithTeach(ArrayList<Course> coursesList) {
        Random r = new Random();
        for (int i = 0; i < courses.size(); i++) {
            if (i < 18) {

                courses.get(i).setTeacher(GeneratorTeachers(teachers, i));
            } else if (i < 29) {

                courses.get(i).setTeacher(GeneratorTeachers(teachers, i - 18));
            } else if (i < 30) {

                courses.get(i).setTeacher(GeneratorTeachers(teachers, i - r.nextInt(12, 29)));
            }
        }
    }


    public void generateStudents(ArrayList<Student> studentArrayList, ArrayList<Course> courses) {

        ArrayList<Student> freest = new ArrayList<>(studentArrayList);


        for (Student student : studentArrayList) {
            if (freest.contains(student)) {

//              int numCourseStudentAbs;
//              studentAbsCourse;

                int numCourseStudentBest = -1;
                int numCourseStudentNorm = -1;
                int numCourseStudentBad = -1;
                int ratingNorm = 0;
                int ratingBad = 0;


                for (int i = 0; i < courses.size(); i++) {


                    if ((student.getScience().equals(courses.get(i).getScience()) &&
                            student.getSubject().equals(courses.get(i).getSubject()) &&
                            student.getFormat().equals(courses.get(i).getFormat()))) {

                        if (courses.get(i).getOccupancy() < 30) {


                            numCourseStudentBest = i;
                            break;
                        }

                    } else {

                        if ((student.getSubject().equals(courses.get(i).getSubject()) && student.getFormat().equals(courses.get(i).getFormat()))) {

                            if (courses.get(i).getOccupancy() < 30) {


                                if (ratingNorm == 0) {

                                    ratingNorm = courses.get(i).getTeacher().getRating();

                                    numCourseStudentNorm = i;
                                } else {
                                    if (courses.get(i).getTeacher().getRating() > ratingNorm) {
                                        ratingNorm = courses.get(i).getTeacher().getRating();

                                        numCourseStudentNorm = i;
                                    }
                                }

                            }

                        } else {
                            if (courses.get(i).getOccupancy() < 30) {


                                if (ratingBad == 0) {

                                    ratingBad = courses.get(i).getTeacher().getRating();

                                    numCourseStudentBad = i;
                                } else {
                                    if (courses.get(i).getTeacher().getRating() > ratingBad) {
                                        ratingBad = courses.get(i).getTeacher().getRating();

                                        numCourseStudentBad = i;
                                    }
                                }

                            }
                        }

                    }
                }

                if (numCourseStudentBest != -1) {
                    courses.get(numCourseStudentBest).getStudents().add(student);
                    courses.get(numCourseStudentBest).addOccupancy();
                } else if (numCourseStudentNorm != -1) {
                    courses.get(numCourseStudentNorm).getStudents().add(student);
                    courses.get(numCourseStudentNorm).addOccupancy();
                } else if (numCourseStudentBad!= -1) {
                    courses.get(numCourseStudentBad).getStudents().add(student);
                    courses.get(numCourseStudentBad).addOccupancy();
                }

                freest.remove(student);

            }


        }

    }

}
