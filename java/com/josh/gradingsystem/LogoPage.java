package com.josh.gradingsystem;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class LogoPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Load image from resources
        Image logoImage = new Image("@Images/istockphoto-1950359091-612x612.jpg");
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitHeight(200);
        logoView.setPreserveRatio(true);

        // Setup scale transition animation
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), logoView);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        // Handle mouse click event
        logoView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            try {
                // Open new stage and close current one
                new HelloApplication().start(new Stage());
                primaryStage.close();
            } catch (Exception ex) {
                ex.printStackTrace(); // Print stack trace for better debugging
            }
        });

        // Create scene and set stylesheet
        StackPane root = new StackPane(logoView);
        Scene scene = new Scene(root, 640, 440);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/com/josh/gradingsystem/LogoStyle.css")));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Logo Page"); // Set a title for the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
