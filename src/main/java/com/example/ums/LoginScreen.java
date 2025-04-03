package com.example.ums;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginScreen.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if(FileProcessing.deserializeStudents()){
            System.out.println("HI");
        }else{
            System.out.println("NO");
        }
        FileProcessing.loadData();
        FileProcessing.loadStudents();
        FileProcessing.loadStudents();
        launch();
    }
}