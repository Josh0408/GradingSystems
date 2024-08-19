package com.josh.gradingsystem;

import com.josh.gradingsystem.student.Student;
import com.josh.gradingsystem.student.StudentRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private Button studentBackButton;

    //Student Details
    @FXML
    private TableView<Student> viewStudentDataCol;
    @FXML
    private TableColumn<Student, String> studentIdCol;
    @FXML
    private TableColumn<Student, String> firstNameCol;
    @FXML
    private TableColumn<Student, String> lastNameCol;
    @FXML
    private TableColumn<Student, String> programCol;
    @FXML
    private TableColumn<Student, String> levelCol;
    @FXML
    private TableColumn<Student,String> yearCol;
    @FXML
    private TableColumn<Student, Double> assignmentCol;
    @FXML
    private TableColumn<Student,Double> midSemCol;
    @FXML
    private TableColumn<Student,Double> examinationCol;
    @FXML
    private TableColumn<Student,Double> totalScoreCol;
    @FXML
    private TableColumn<Student,String> gradeCol;
    @FXML
    private TableColumn<Student,String> semesterExamsCol;
    @FXML
    private Button viewStudentDetailsButton;
   /* @FXML
    private TableColumn<> iconsCol;*/


    @FXML
     private void loadDataOnAction() {



            studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            programCol.setCellValueFactory(new PropertyValueFactory<>("program"));
            levelCol.setCellValueFactory(new PropertyValueFactory<>("level"));
            yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
            assignmentCol.setCellValueFactory(new PropertyValueFactory<>("assignment"));
            midSemCol.setCellValueFactory(new PropertyValueFactory<>("midsem"));
            examinationCol.setCellValueFactory(new PropertyValueFactory<>("examination"));
            totalScoreCol.setCellValueFactory(new PropertyValueFactory<>("totalScore"));
            gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
            semesterExamsCol.setCellValueFactory(new PropertyValueFactory<>("semesterExams"));

            ObservableList<Student> observableListOfStudents = FXCollections.observableList(StudentRepo.getStudents());
            viewStudentDataCol.setItems(observableListOfStudents);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataOnAction();
    }


    public void switchToStudentScene() throws IOException {
      try{
        Stage stage = (Stage) studentBackButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student-view.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Student Data Entry");
        primaryStage.setScene(new Scene(root, 953, 591));
        primaryStage.show();
      }catch(Exception e) {
            System.out.println(e.getMessage());
      }
    }
}
