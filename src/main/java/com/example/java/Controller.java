package com.example.java;


import com.example.java.courses.Course;
import com.example.java.humans.Student;
import com.example.java.humans.Teacher;

import com.example.java.parties.Party;
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
    ArrayList<Party> parties = new ArrayList<>();

    Writer writer = new Writer();
    Deccanat deccanat=null;
    //Map<Teacher, Boolean> teacherBooleanMap = new HashMap();

    @FXML
    private TreeView<String> tree1;

    @FXML
    private TreeView<String> tree2;

    @FXML
    private TreeView<String> tree3;


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
//            FileChooser fc = new FileChooser();
//            fc.setInitialDirectory(new File("C:\\Users\\user\\IdeaProjects\\F\\ExamLaba1.3"));
//            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel", "*.xlsx");
//            fc.getExtensionFilters().add(extFilter);
//            File selectedFile = fc.showOpenDialog(null);

            File selectedFile = new File(this.getClass().getResource("examlaba.xlsx").getFile());

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
        for (Course c : deccanat.CreateCourses(teachers)) {
            courses.add(c);
        }
    }

    @FXML
    void CreateCoursewithSt(ActionEvent event) throws Exception {
        deccanat.CreateCourseWithStudents(students, courses);
        deccanat.countTch();
    }

    @FXML
    void ShowCourse(ActionEvent event) throws IOException, InvalidFormatException {
        writer.writeTree(tree1, courses);
    }

    @FXML
    void CreateParty(ActionEvent event) throws Exception {
        for (Party p : deccanat.CreateParties()) {
            parties.add(p);
        }
        for (Party p:parties){
            System.out.println(p.getName()+" "+p.getFocus()+" "+p.getStudents());
        }
    }

    @FXML
    void ShowParty(ActionEvent event) throws IOException, InvalidFormatException {
        writer.writeTree3(tree3, parties);

    }

    @FXML
    void ShowTeacher(ActionEvent event) throws IOException, InvalidFormatException {
        writer.writeTree2(tree2, teachers);

    }



    @FXML
    void Showtext (ActionEvent event) {
        MultipleSelectionModel<TreeItem<String>> selectionModel = tree1.getSelectionModel();

        String selected = "";
        // перебираем выбанные элементы
        for(TreeItem<String> item : selectionModel.getSelectedItems()){

            selected += item.getValue() + " ";}

        textt.setText(selected);
    }

    @FXML
    void Createtext (ActionEvent event) {
        MultipleSelectionModel<TreeItem<String>> selectionModel = tree1.getSelectionModel();

        String selected = "";
        for(TreeItem<String> item : selectionModel.getSelectedItems()){

            //selected += item.getValue() + " ";

            item.setValue(textt.getText());}

    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

}