package com.example.java;


import com.example.java.courses.Course;
import com.example.java.humans.Student;
import com.example.java.humans.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Controller {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    Writer writer = new Writer();
    Deccanat deccanat=null;
    //Map<Teacher, Boolean> teacherBooleanMap = new HashMap();

    @FXML
    private TreeView<String> tree;


    @FXML
    private TextArea textt;

    @FXML
    private Button buttonUser;
    private Button buttonTree;
    private Button buttonText;
   /* public void initialize(){
        buttonUser.setDisable(true);
    }*/

    public static void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }


    @FXML
    void ChooseFile(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\Users\\user\\IdeaProjects\\F\\ExamLaba1.3"));
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel", "*.xlsx");
            fc.getExtensionFilters().add(extFilter);
            File selectedFile = fc.showOpenDialog(null);
            deccanat = new Deccanat(selectedFile);


        } catch (Exception e) {
            error(e);
        }
    }


    @FXML
    void CreateHumans(ActionEvent event) throws IOException, InvalidFormatException {
        for (Student st: deccanat.CreateStudents()){
            students.add(st);
        }
        for (Teacher tch: deccanat.CreateTeachers()){
            teachers.add(tch);
        }
    }

    @FXML
    void CreateCourse(ActionEvent event) throws Exception {
        for (Course c: deccanat.CreateCourses(teachers, students)){
            courses.add(c);
        }
    }

    @FXML
    void ShowCourse(ActionEvent event) throws IOException, InvalidFormatException {
        writer.writeTree(tree, courses, teachers, students);
    }


    @FXML
    void Showtext (ActionEvent event) {
        MultipleSelectionModel<TreeItem<String>> selectionModel = tree.getSelectionModel();
        // устанавливаем множественный выбор (если он необходим)
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);


        String selected = "";
        // перебираем выбанные элементы
        for(TreeItem<String> item : selectionModel.getSelectedItems()){

            selected += item.getValue() + " ";}

        textt.setText(selected);
    }

    @FXML
    void Createtext (ActionEvent event) {
        MultipleSelectionModel<TreeItem<String>> selectionModel = tree.getSelectionModel();
        // устанавливаем множественный выбор (если он необходим)
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);


        String selected = "";
        // перебираем выбанные элементы
        for(TreeItem<String> item : selectionModel.getSelectedItems()){

            selected += item.getValue() + " ";

            item.setValue(textt.getText());}

    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }




   /* @FXML
    void ReadingBook(ActionEvent event) {
        try {

            File fileB = new File("C:\\Users\\user\\IdeaProjects\\F\\ExamLaba1.1\\examlaba.xlsx");
            try {
                humanFabric = new HumanFabric(fileB);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }


            for (int j = 0; j < 18; j++) {
                teachers.add(humanFabric.CreateTeachers());}

            for (int j = 0; j < 60; j++) {
                students.add(humanFabric.CreateStudents());}

            //Сортировка студентов
            Collections.sort(students, Comparator.comparing(Student::getRating).reversed());


            for(Student student: students){
                System.out.println(student.getFullName());
            }

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void ReadingUser(ActionEvent event) {
        try {

            File fileA = new File("C:\\Users\\user\\IdeaProjects\\F\\ExamLaba1.0\\course.xlsx");
            try {
                courseFabric = new CourseFabric(fileA);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }

            for (int j = 0; j < 30; j++) {
                courses.add(courseFabric.CreateCourses(teachers));}

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void Showtree(ActionEvent event) {
        try {

            //initializeTree();
            writeTree3();

        } catch (Exception e) {
            error(e);
        }
    }


    @FXML
    void ShowChoose(ActionEvent event) {
        try {

            //initializeTree();
            //writeTree4();

        } catch (Exception e) {
            error(e);
        }
    }
*/






    public void initializeTree() {

        TreeItem<String> rootItem = new TreeItem<>("Курсы");
        rootItem.setExpanded(true);

        /*for (Teacher teacher : teachers) {

            TreeItem<String> branchItem = new TreeItem<>(teacher.getFullName()+" "+teacher.getCourses().size());
            rootItem.getChildren().add(branchItem);

            teacher.getCourses().forEach((obj) -> {
                Course course = (Course) obj;
                TreeItem<String> teacherItem = new TreeItem<>(course.getFullName());
                branchItem.getChildren().add(teacherItem);
            });
        }*/

        for (Course course : courses) {

            TreeItem<String> branchItem = new TreeItem<>(course.getName());
            rootItem.getChildren().add(branchItem);

            /*TreeItem<String> bookItem = new TreeItem<>(book.getName());
            branchItem.getChildren().add(bookItem);
            bookItem.getChildren().add(new TreeItem<>("Тип : " + book.getType()));
            bookItem.getChildren().add(new TreeItem<>("Язык : " + book.getLanguage()));
            */


            branchItem.getChildren().add(new TreeItem<>("Наука : " + course.getScience()));
            branchItem.getChildren().add(new TreeItem<>("Предмет : " + course.getSubject()));
            branchItem.getChildren().add(new TreeItem<>("Формат : " + course.getFormat()));

            course.getTeachers().forEach((obj) -> {
                Teacher teacher = (Teacher) obj;
                TreeItem<String> teacherItem = new TreeItem<>(teacher.getFullName());
                branchItem.getChildren().add(teacherItem);
            });
        }

        tree.setRoot(rootItem);
    }

    TreeItem<String> courseItem;

   }