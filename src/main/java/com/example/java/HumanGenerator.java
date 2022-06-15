package com.example.java;

import com.example.java.courses.Course;
import com.example.java.humans.Teacher;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class HumanGenerator {

    private Reader reader;

    private ThreadLocalRandom random;
    private String[] male_name;
    private String[] female_name;
    private String[] surname;
    private String[] teacher_surname;
    private String[] patronymic;
    //
    private String[] subject;
    private String[] format;
    private String[] science;

    public String[] getMale_name(){
        return male_name;
    }

    public String[] getFemale_name(){
        return female_name;
    }

    public String[] getMale_Surname(){
        return surname;
    }

    public String[] getTMale_Surname(){
        return teacher_surname;
    }

    public String[] getPatronymic() {
        return patronymic;
    }
    //
    public String[] getSubject() {
        return subject;
    }

    public String[] getFormat() {
        return format;
    }

    public String[] getScience() {
        return science;
    }


    public HumanGenerator(File file) throws IOException, InvalidFormatException {
        this.random = ThreadLocalRandom.current();
        reader = new Reader(file);
        setUp();
    }

    public void setUp () throws IOException, InvalidFormatException {
        male_name = reader.readData(0);
        female_name = reader.readData(1);
        surname = reader.readData(2);
        teacher_surname = reader.readData(3);
        patronymic = buildMale_patronymic();
        subject = reader.readData(4);
        format = reader.readData(5);
        science = reader.readData(6);
        reader.close();
    }

    public String[] buildMale_patronymic() {
        String[] patronymic = new String[male_name.length];
        int k=0;
        for (String male_name: male_name) {
            if (male_name.endsWith("ев")) {
                patronymic[k] = male_name.substring(0, male_name.length() - 2) + "ьвович";}
            else if (male_name.endsWith("а")|male_name.endsWith("ья")) {
                patronymic[k] = male_name.substring(0, male_name.length() - 1) + "ич";
            } else if (male_name.endsWith("ж")|male_name.endsWith("ш")|male_name.endsWith("ч")|male_name.endsWith("щ")|male_name.endsWith("ц")|male_name.endsWith("р")|
                    male_name.endsWith("н")|male_name.endsWith("л")|male_name.endsWith("б")|male_name.endsWith("м")|male_name.endsWith("с")|
                    male_name.endsWith("к")|male_name.endsWith("г")|male_name.endsWith("в")|male_name.endsWith("д")|male_name.endsWith("п")){
                patronymic[k]=male_name+"ович";}
            else if (male_name.endsWith("ь")|male_name.endsWith("й")){
                patronymic[k]=male_name.substring(0, male_name.length() - 1) +"евич";
            } else
                patronymic[k]=male_name+"eвич";
            k++;
        }

        return patronymic;
    }

    public String Generator(String[] arr) {
        String s = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];
        //(int)Math.random()*100*arr.length];
        return s;
    }

    public String GeneratorFemale_Surname(String[] arr) {
        String surname = Generator(arr);
        String Female_Surname = "";
        if (surname.endsWith("ий")) {
            Female_Surname = surname.substring(0, surname.length() - 2) + "ая";
        } else  if (surname.endsWith("в") || surname.endsWith("н")) {
            Female_Surname = surname + "а";
        } else {
            Female_Surname = surname;
        }
        return Female_Surname;
    }

    public String GeneratorFemale_patronomyc(String[] arr) {
        String patronomyc = Generator(arr);
        String Female_patronomyc = patronomyc.substring(0, patronomyc.length() - 3) + "вна";
        return Female_patronomyc;
    }

    public Integer GeneratorStudentRating() {
        int rating;
        rating = ThreadLocalRandom.current().nextInt(0, 101);
        return rating;
    }

    public Integer GeneratorTeacherRating() {
        int rating;
        rating = ThreadLocalRandom.current().nextInt(1, 11);
        return rating;
    }

    public String GeneratorGroup() {
        double rn = Math.random();
        String group = "";
        if (rn > 0 & rn<0.1) {
            group = "Б18-103";
        } else if (rn >0.1 & rn<0.2) {
            group = "Б18-602";
        } else if (rn >0.2 & rn<0.3){
            group = "Б19-904";
        } else if (rn >0.3 & rn<0.4) {
            group = "M20-994";
        } else if (rn >0.4 & rn<0.5){
            group = "Б21-103";
        } else if (rn >0.5 & rn<0.6) {
            group = "Б19-702";
        } else if (rn >0.6 & rn<0.7){
            group = "Б21-203";
        } else if (rn >0.7 & rn<0.8) {
            group = "Б20-205";
        } else if (rn >0.8 & rn<0.0){
            group = "M20-B03";
        } else
            group = "C21-402";
        return group;
    }

    public Integer GeneratorFaculty() {
        int rn = ThreadLocalRandom.current().nextInt(1, 90);
        Integer faculty ;
        faculty = rn;
        return faculty;
    }

}
