package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.ums.FileProcessing.faculties;
import static com.example.ums.FileProcessing.students;


public class LoginController {
    public Boolean isAdmin;
    public Label usernameInput;
    public Label passwordInput;
    public TextField usernameField;
    public PasswordField passwordField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        String userId = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("User input - ID: " + userId + ", Password: " + password);
        students.forEach(System.out::println);

        if (isValidUser(userId, password)) {
            welcomeText.setText("Login successful!");
            if (faculties.stream().anyMatch(f -> f.facultyID.equals(userId))) {
                isAdmin = true;
                System.out.println("Admin logged in");
                switchToAdminScene(event);
            } else {
                isAdmin = false;
                System.out.println("Student logged in");
            }
        } else {
            welcomeText.setText("Invalid username or password.");
        }
    }

    private boolean isValidUser(String userId, String password) {
        return faculties.stream().anyMatch(f -> f.facultyID.equals(userId) && f.password.equals(password)) ||
                students.stream().anyMatch(s -> s.id.equals(userId) && s.password.equals(password));
    }

    @FXML
    private void switchToAdminScene(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Main_Admin.fxml")); // Update this path as needed
            Parent adminRoot = loader.load();
            Scene adminScene = new Scene(adminRoot);

            // Get the current stage and switch scenes
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(adminScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}