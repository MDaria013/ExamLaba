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
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CourseGenerator {


    private Reader reader;

    private ThreadLocalRandom random;

    private String[] subject;
    private String[] name;
    private String[] science;

    public String[] getSubject() {
        return subject;
    }

    public String[] getName() {
        return name;
    }

    public String[] getScience() {
        return science;
    }


    public CourseGenerator(File file) throws IOException, InvalidFormatException {
        this.random = ThreadLocalRandom.current();
        reader = new Reader(file);
        setUp();
    }

    public void setUp() throws IOException, InvalidFormatException {
        subject = reader.readData(4);
        science = reader.readData(6);
        name = buildCourseName();
        reader.close();
    }

    public String[] buildCourseName() {
        String[] course = new String[subject.length];
        int k = 0;
        for (String sub : subject) {
            String[] words = sub.split(" ");
            if (words.length == 2) {
                if (words[0].endsWith("ая") & words[1].endsWith("ра")) {
                    course[k] = words[0].substring(0, words[0].length() - 2) + "ой " + words[1].substring(0, words[1].length() - 1) + "ы";
                } else if (words[0].endsWith("ая") & words[1].endsWith("а")) {
                    course[k] = words[0].substring(0, words[0].length() - 2) + "ой " + words[1].substring(0, words[1].length() - 1) + "и";
                } else if (words[0].endsWith("ий")) {
                    course[k] = words[0].substring(0, words[0].length() - 2) + "ого " + words[1] + "а";
                } else if (words[0].endsWith("ть") & words[1].endsWith("и")) {
                    course[k] = words[0].substring(0, words[0].length() - 1) + "и " + words[1];
                } else if (words[0].endsWith("ые") & words[1].endsWith("ы")) {
                    course[k] = words[0].substring(0, words[0].length() - 1) + "х " + words[1].substring(0, words[1].length()-1) +"ов";
                }
            } else {
                if (words[0].endsWith("ия")|words[0].endsWith("a")) {
                    course[k] =words[0].substring(0, words[0].length() - 1) + "и";
                } else if (words[0].endsWith("ие")){
                    course[k] = words[0].substring(0, words[0].length() - 2) + "ия";;
                } else course[k]=words[0];
            }

            k++;
        }
        return course;
    }



      /*  public String Generator(String[] arr) {
            int i= random.nextInt(0, arr.length);
            String s = arr[i];
            return s;
        }

        public String GeneratorTeor(String[] arr) {
            double rn = Math.random();
            String group = "";
            if (rn > 0 & rn<0.5) {
                group = "Основы ";
            } else {
                group = "Теоретические основы ";
            }
            return (group+Generator(arr));
        }

        public String GeneratorProj(String[] arr) {
            double rn = Math.random();
            String group = "";
            if (rn > 0 & rn<0.5) {
                group = "Курсовой проект по ";
            } else
                group = "Курсовая работа по ";
            return (group+Generator(arr));
        }


        public String GeneratorPract(String[] arr) {
            double rn = Math.random();
            String group = "";
            if (rn > 0 & rn<0.5) {
                group = "Практика ";
            } else
                group = "Практические основы ";
            return (group+Generator(arr));
        }
*/

    }
