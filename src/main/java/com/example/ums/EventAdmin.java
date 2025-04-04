package com.example.ums;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EventAdmin extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EventAdmin.class.getResource("Event_Admin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 680);
        stage.setTitle("Event_Admin");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}