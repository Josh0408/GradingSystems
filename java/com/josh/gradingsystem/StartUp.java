package com.josh.gradingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class StartUp {
    @FXML
    private Label startUpClick;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        Stage stage = (Stage) startUpClick.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 640, 440));
        primaryStage.show();

    }


}
