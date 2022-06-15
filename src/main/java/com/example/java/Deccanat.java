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
       // int i=1;
     for (int j = 1; j <= 18; j++) {
        teachers.add(fabricTeacher.CreateData());
       }

    return teachers;
    }

    public ArrayList<Course> CreateCourses(ArrayList<Teacher> teachers, ArrayList<Student> students) throws Exception {
        for (int j = 0; j < 30; j++) {
            courses.add(courseFabric.CreateCourses());
            generateStudent(students,courses);}
        for (Course course:courses){
            course.setTeachers(GeneratorTeachers(teachers));
            //course.setStudents(GeneratorStudents(students));
        }
        //GeneratorStudents(students);

        return courses;
    }

    public HashSet GeneratorTeachers(ArrayList<Teacher> teachersList) {
        HashSet<Teacher> tch = new HashSet<>();
        Random r = new Random();
        for (int i=0;i<1; i++){
            tch.add(teachersList.get(r.nextInt(teachersList.size())));
        }
        return tch;
    }

    public void generateStudent(ArrayList<Student> studentArrayList, ArrayList<Course> courses) {
        int num = ThreadLocalRandom.current().nextInt(1, 2);
        List<Student> students = null;

        for (int i=0; i<courses.size(); i++) {
            students = new ArrayList<>();
            int occupancy = 0;
            int Id =0;
            for (Student student : studentArrayList) {
                    if (student.getScience().equals(courses.get(i).getScience()) &&
                            student.getSubject().equals(courses.get(i).getSubject()) && student.getFormat().equals(courses.get(i).getFormat())) {
                        students.add(student);
                        Id = Id + 1;
                        student.setId(Id);
                        occupancy = occupancy + 1;
                        courses.get(i).setOccupancy(occupancy);

                    } else courses.get(i).setOccupancy(occupancy);

            }
            Collections.sort(students, Comparator.comparing(Student::getId));
            Set<Student> unique = new LinkedHashSet<>(students);

            courses.get(i).setStudents(unique);
        }
        }


    public HashSet GeneratorCourses(ArrayList<Course> coursesList, int j) {
        //int num = ThreadLocalRandom.current().nextInt(1, 3);
        Random r = new Random();
        HashSet<Course> courses = new HashSet<>();
        if (j<=7){
        //7
        for (int i = 0; i < 1; i++)
            courses.add(coursesList.get(r.nextInt(coursesList.size())));
        } else if(j<=17){
        //10
        for (int i = 0; i < 2; i++)
            courses.add(coursesList.get(r.nextInt(coursesList.size())));}
        else{
        //1
        for (int i = 0; i < 3; i++)
            courses.add(coursesList.get(r.nextInt(coursesList.size())));
        }

        return courses;
    }

}
