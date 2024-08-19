package com.josh.gradingsystem;

import com.josh.gradingsystem.login.AdminRepository;
import com.josh.gradingsystem.login.UserDetails;
import com.josh.gradingsystem.student.Student;
import com.josh.gradingsystem.student.StudentRepo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class StudentViewController {

    //Student Data entry
    @FXML
    public TextField studentIdTxt;

    @FXML
    public TextField firstNameTxt;

    @FXML
    public TextField lastNameTxt;

    @FXML
    public TextField programTxt;

    @FXML
    public TextField assignmentTxt;

    @FXML
    public TextField examinationTxt;

    @FXML
    public TextField semesterTxt;

    @FXML
    public TextField levelTxt;

    @FXML
    public TextField genderTxt;

    @FXML
    public TextField contactTxt;

    @FXML
    public TextField insEmailTxt;

    @FXML
    public TextField facultyTxt;

    @FXML
    public TextField midsemTxt;

    @FXML
    public TextField totalScoreTxt;

    @FXML
    public TextField gradeTxt;

    @FXML
    public TextField yearTxt;

    @FXML
    private Button calculateButton;

    @FXML
    private Button saveButton;

    @FXML
    private Label studentMessageLabel;

    @FXML
    private Button viewButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button backButton;






    @FXML
    public void handleInputAndCalculation(){
        double Assignment = Double.parseDouble(assignmentTxt.getText());
        double MidSem = Double.parseDouble(midsemTxt.getText());
        double Examination = Double.parseDouble(examinationTxt.getText());
        if (Assignment > 20){
            try{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Assignment must be greater than 0 or equal to 20");
                alert.showAndWait();
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number");
                alert.showAndWait();


            }
        } else if (MidSem > 20 ) {

            try{
                Alert alert = new Alert(Alert.AlertType.ERROR, "MidSem must be greater than 0 or equal to 20");
                alert.showAndWait();
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number");
                alert.showAndWait();


            }


        } else if (Examination > 60) {

            try{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Examination must be greater than 0 or equal to 60");
                alert.showAndWait();
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid number");
                alert.showAndWait();


            }

        }else{
            double total = (Assignment + MidSem + Examination);
            String Total = String.valueOf(total);
            totalScoreTxt.setText(Total);

            if (total > 85){
                gradeTxt.setText("A+");
            } else if (total >= 80) {
                gradeTxt.setText("A");
            }else if (total >= 75) {
                gradeTxt.setText("B+");
            } else if (total >= 70) {
                gradeTxt.setText("B");

            }else if (total >= 65) {
                gradeTxt.setText("C+");
            } else if (total >= 60) {
                gradeTxt.setText("C");

            }else if (total >= 50) {
                gradeTxt.setText("D");
            }else {
                gradeTxt.setText("F");
            }

        }


    }





    @FXML
    public void submitStudentDetailOnAction(){
        if(studentIdTxt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the student ID ");
            alert.showAndWait();
        }else if(firstNameTxt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the firstname");
            alert.showAndWait();
        } else if (lastNameTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the lastname");
            alert.showAndWait();

        } else if (genderTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the gender");
            alert.showAndWait();

        } else if (programTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the program");
            alert.showAndWait();
        } else if (insEmailTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the institutional Email");
            alert.showAndWait();

        }else if(facultyTxt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the faculty");
            alert.showAndWait();

        }else if(levelTxt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the level");
            alert.showAndWait();
        }else if(yearTxt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the year");
            alert.showAndWait();
        } else if (semesterTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the semester Exams");
            alert.showAndWait();

        } else if (contactTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter the contact");
            alert.showAndWait();

        }else {


            Student student = new Student();
            String studentId = studentIdTxt.getText();
            String firstName = firstNameTxt.getText();
            String lastName = lastNameTxt.getText();
            String gender = genderTxt.getText();
            String program = programTxt.getText();
            String institutionEmail = insEmailTxt.getText();
            String faculty = facultyTxt.getText();
            String level = levelTxt.getText();
            String year = yearTxt.getText();
            double assignment = Double.parseDouble(assignmentTxt.getText());
            double midSem = Double.parseDouble(midsemTxt.getText());
            double examination = Double.parseDouble(examinationTxt.getText());
            double totalScore = Double.parseDouble(totalScoreTxt.getText());
            String grade = gradeTxt.getText();
            String semesterExams = semesterTxt.getText();
            String contact = contactTxt.getText();


            student.setStudentId(studentId);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setGender(gender);
            student.setProgram(program);
            student.setInstitutionEmail(institutionEmail);
            student.setFaculty(faculty);
            student.setLevel(level);
            student.setYear(year);
            student.setAssignment(assignment);
            student.setMidsem(midSem);
            student.setExamination(examination);
            student.setTotalScore(totalScore);
            student.setGrade(grade);
            student.setSemesterExams(semesterExams);
            student.setContact(contact);

            int result = StudentRepo.insert(student);
            if (result > 0) {
                studentMessageLabel.setText("Student Data Saved Successfully");
            } else {
                studentMessageLabel.setText(" Failed To Save Student Data");
            }

            studentIdTxt.clear();
            firstNameTxt.clear();
            lastNameTxt.clear();
            programTxt.clear();
            levelTxt.clear();
            genderTxt.clear();
            facultyTxt.clear();
            insEmailTxt.clear();
            assignmentTxt.clear();
            midsemTxt.clear();
            examinationTxt.clear();
            semesterTxt.clear();
            yearTxt.clear();
            gradeTxt.clear();
            totalScoreTxt.clear();
            contactTxt.clear();

        }


    }



    public void switchToScene4() throws IOException {
        Stage stage = (Stage) viewButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("viewStudentData.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,1221, 500 ));
        primaryStage.show();

    }


    public void cancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    public void switchToScene1(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 640, 440));
        primaryStage.show();

    }

}
