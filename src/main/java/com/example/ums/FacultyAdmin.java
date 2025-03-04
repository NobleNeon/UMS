package com.example.ums;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FacultyAdmin extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FacultyAdmin.class.getResource("Faculty_Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 680);
        stage.setTitle("Faculty_Admin");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}