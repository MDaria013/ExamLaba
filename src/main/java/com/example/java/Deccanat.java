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
     for (Teacher teacher:teachers){
         System.out.println(teacher.getFullName());
     }
    return teachers;
    }

    public ArrayList<Course> CreateCourses(ArrayList<Teacher> teachers, ArrayList<Student> students) throws Exception {
        for (int j = 0; j < 30; j++) {
            courses.add(courseFabric.CreateCourses());
            generateStudents(students,courses);}
            GeneratorCourses(courses);

        return courses;
    }

    public HashSet GeneratorTeachers(ArrayList<Teacher> teachersList, int index) {
        HashSet<Teacher> tch = new HashSet<>();
                        tch.add(teachersList.get(index));
        return tch;
    }


    public void GeneratorCourses(ArrayList<Course> coursesList) {
        Random r = new Random();
        for (int i = 0; i < courses.size(); i++) {
            if (i < 18) {
                courses.get(i).setTeachers(GeneratorTeachers(teachers, i));
            } else if (i < 29) {

                courses.get(i).setTeachers(GeneratorTeachers(teachers, i - 18));
            } else if (i < 30) {

                courses.get(i).setTeachers(GeneratorTeachers(teachers, i - r.nextInt(12, 29)));
            }
        }
    }


    public void generateStudents(ArrayList<Student> studentArrayList, ArrayList<Course> courses) {
        int num = ThreadLocalRandom.current().nextInt(1, 2);
        List<Student> students = null;

        ArrayList<Student> freest = new ArrayList<>(studentArrayList);

        for (int i = 0; i < courses.size(); i++) {
            int j = 0;
            students = new ArrayList<>();
            int occupancy = 0;
            int Id = 0;
            for (Student student : studentArrayList) {
                if (j < 30) {
                    if (freest.contains(student)) {
                        if (student.getScience().equals(courses.get(i).getScience()) &&
                                student.getSubject().equals(courses.get(i).getSubject()) && student.getFormat().equals(courses.get(i).getFormat()) ||
                                (student.getSubject().equals(courses.get(i).getSubject()) && student.getFormat().equals(courses.get(i).getFormat()))) {
                            students.add(student);
                            freest.remove(student);
                            Id = Id + 1;
                            student.setId(Id);
                            occupancy = occupancy + 1;
                            j++;
                            courses.get(i).setOccupancy(occupancy);
                        } else {
                            courses.get(i).setOccupancy(occupancy);
                        }}
                    } else break;

                    Collections.sort(students, Comparator.comparing(Student::getId));
                    Set<Student> unique = new LinkedHashSet<>(students);

                    courses.get(i).setStudents(unique);
                }
            }

    }



}
