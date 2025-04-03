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

    public class GlobalVariables {
        public static String userId;
        public static Faculty currentFaculty;
        public static Student currentStudent;
    }

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        GlobalVariables.userId = usernameField.getText();
        String password = passwordField.getText();
        FileProcessing.loadStudent();

        System.out.println("User input - ID: " + GlobalVariables.userId + ", Password: " + password);
        students.forEach(System.out::println);

        if (isValidUser(GlobalVariables.userId, password)) {
            // Find the faculty member with the given ID
            Faculty loggedInFaculty = null;
            Student loggedInStudent = null;
            for (Faculty faculty : faculties) {
                if (faculty.getId().equals(GlobalVariables.userId)) {
                    loggedInFaculty = faculty;
                    break;
                }
            }
            for (Student student : students) {
                if (student.getId().equals(GlobalVariables.userId)) {
                    loggedInStudent = student;
                    break;
                }
            }

            // Check if the user is an Admin
            if (loggedInFaculty != null && "ADMIN".equals(loggedInFaculty.getRole())) {
                isAdmin = true;
                switchToAdminScene(event);
            } else {
                isAdmin = false;
                System.out.println("User logged in");
                if (GlobalVariables.userId.startsWith("F")){
                    GlobalVariables.currentFaculty = loggedInFaculty;
                    System.out.println("Current faculty: " + GlobalVariables.currentFaculty);
                }
                else{
                    GlobalVariables.currentStudent = loggedInStudent;
                    System.out.println("Current student: " + GlobalVariables.currentStudent);
                }
                switchToUserScene(event);
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
    @FXML
    private void switchToUserScene(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Main_User.fxml")); // Update this path as needed
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