package com.josh.gradingsystem;

import com.josh.gradingsystem.login.AdminRepository;
import com.josh.gradingsystem.login.UserDetails;
import com.josh.gradingsystem.student.Student;
import com.josh.gradingsystem.student.StudentRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;




public class LoginController {


    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Button backButton;

    @FXML
    private Hyperlink hyperlinkButton;

    //Admin Registration Details
    @FXML
    public TextField adminUsernameTxt;

    @FXML
    public TextField adminPasswordField;

    @FXML
    public TextField adminLastnameTxt;

    @FXML
    public TextField adminFirstnameTxt;

    @FXML
    public Label adminMessageLabel;

    @FXML
    public Button updateButton;


    @FXML
    private void submitAdminDetailsOnAction() {

        if(adminUsernameTxt.getText().isEmpty()){
            adminMessageLabel.setText("Please enter your username");
            return;
        } else if (adminPasswordField.getText().isEmpty()) {
            adminMessageLabel.setText("Please enter your password");
            return;

        } else if (adminLastnameTxt.getText().isEmpty()) {
            adminMessageLabel.setText("Please enter your lastname");
            return;

        }else if(adminFirstnameTxt.getText().isEmpty()){
            adminMessageLabel.setText("Please enter your lastname");
            return;
        }else {

            String userName = adminUsernameTxt.getText();
            String password = adminPasswordField.getText();
            String lastname = adminLastnameTxt.getText();
            String firstname = adminFirstnameTxt.getText();



            UserDetails admin = new UserDetails();
            admin.setUserName(userName);
            admin.setPassword(password);
            admin.setLastName(lastname);
            admin.setFirstName(firstname);

            int res = AdminRepository.insert(admin);
            if (res > 0) {
                adminMessageLabel.setText("Admin Data Saved Successfully");


            } else {
                adminMessageLabel.setText("Invalid SignUp, Retry ");
            }

        }

    }


    @FXML
    public void loginButtonOnAction(ActionEvent event) throws IOException {

        if (!usernameTxt.getText().isBlank() && !passwordTxt.getText().isBlank()) {

            validateLogin();

        } else {
            loginMessageLabel.setText("Please enter username and password");
        }

    }


    public void validateLogin() {
        DBConnectivity connectNow = new DBConnectivity();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "SELECT count(1) FROM login WHERE userName = ? AND password = ?";

        try (PreparedStatement preparedStatement = connectDB.prepareStatement(verifyLogin)) {
            preparedStatement.setString(1, usernameTxt.getText());
            preparedStatement.setString(2, passwordTxt.getText());
            ResultSet queryResult = preparedStatement.executeQuery();

            if (queryResult.next() && queryResult.getInt(1) == 1) {
                loginMessageLabel.setText("Welcome");
                switchToScene3();
            } else {
                loginMessageLabel.setText("Invalid Login, try again");
            }

            queryResult.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            loginMessageLabel.setText("Database error. Please try again later.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connectDB != null && !connectDB.isClosed()) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void switchToScene2(ActionEvent event) throws IOException {
        Stage stage = (Stage) hyperlinkButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminReg.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Admin Registration");
        primaryStage.setScene(new Scene(root, 493, 350));
        primaryStage.show();

    }

    public void switchToScene1(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 640, 440));
        primaryStage.show();    

    }

    public void switchToScene3() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student-view.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Student Data Entry");
        primaryStage.setScene(new Scene(root, 953, 591));
        primaryStage.show();
    }


    public void cancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}


