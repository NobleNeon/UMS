package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.ums.FileProcessing.students;

public class StudentUserController {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;

    @FXML
    public Label studentInfo, studentAddress, studentAcademicLevel, studentCurrentSemester, studentSubject, studentGrade, studentEmail, studentTelephone;


    @FXML
    protected void handleButtonActionDashboard(ActionEvent event) {
        switchToUserDashboardScene(event);
    }

    @FXML
    protected void handleButtonActionSubject(ActionEvent event) {
        switchToUserSubjectScene(event);
    }

    @FXML
    protected void handleButtonActionCourse(ActionEvent event) {
        switchToUserCourseScene(event);
    }

    @FXML
    protected void handleButtonActionFaculty(ActionEvent event) {
        switchToUserFacultyScene(event);
    }

    @FXML
    protected void handleButtonActionEvent(ActionEvent event) {
        switchToUserEventScene(event);
    }

    @FXML
    private void switchToUserDashboardScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Main_User.fxml")); // Update if needed
            Parent subjectRoot = loader.load();
            Scene subjectScene = new Scene(subjectRoot);

            // Get the stage from any existing node (e.g., the menu button's parent window)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(subjectScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToUserSubjectScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Subject_User.fxml")); // Update if needed
            Parent subjectRoot = loader.load();
            Scene subjectScene = new Scene(subjectRoot);

            // Get the stage from any existing node (e.g., the menu button's parent window)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(subjectScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToUserCourseScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Course_User.fxml")); // Update if needed
            Parent subjectRoot = loader.load();
            Scene subjectScene = new Scene(subjectRoot);

            // Get the stage from any existing node (e.g., the menu button's parent window)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(subjectScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToUserFacultyScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Faculty_User.fxml")); // Update if needed
            Parent subjectRoot = loader.load();
            Scene subjectScene = new Scene(subjectRoot);

            // Get the stage from any existing node (e.g., the menu button's parent window)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(subjectScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToUserEventScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Event_User.fxml")); // Update if needed
            Parent subjectRoot = loader.load();
            Scene subjectScene = new Scene(subjectRoot);

            // Get the stage from any existing node (e.g., the menu button's parent window)
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(subjectScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void handleButtonAction(ActionEvent actionEvent) {
    }



    @FXML
    private void displayStudentProfile() {
        Optional<Student> studentOptional = students.stream()
                .filter(s -> s.getId().equalsIgnoreCase(LoginController.GlobalVariables.userId)) // Search by Student ID
                .findFirst();

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            studentInfo.setText(student.getName());
            studentAddress.setText(student.getAddress());
            studentAcademicLevel.setText(student.getAcademicLevel());
            studentCurrentSemester.setText(student.getCurrentSemester());
            studentSubject.setText(student.getSubject());
            studentGrade.setText("Grade: " + student.getGrade());
            studentEmail.setText(student.getEmail());
            studentTelephone.setText(student.getTelephone());
        } else {
            System.out.println("Student not found!");
        }
        }
    }

