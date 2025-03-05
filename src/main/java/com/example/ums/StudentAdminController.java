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

public class StudentAdminController {

    // Menu items for navigation (existing code)
    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;

    // TextField for student name search and other labels for student info display
    @FXML
    public TextField studentName;
    public Label studentInfo, studentAddress, studentAcademicLevel, studentCurrentSemester, studentSubject, studentGrade, studentEmail, studentTelephone;

    // ListView for showing student name suggestions
    @FXML
    private ListView<String> studentSuggestionsList;

    @FXML
    protected void handleButtonActionDashboard(ActionEvent event) {
        switchToAdminDashboardScene(event);
    }

    @FXML
    protected void handleButtonActionSubject(ActionEvent event) {
        switchToAdminSubjectScene(event);
    }

    @FXML
    protected void handleButtonActionCourse(ActionEvent event) {
        switchToAdminCourseScene(event);
    }

    @FXML
    protected void handleButtonActionFaculty(ActionEvent event) {
        switchToAdminFacultyScene(event);
    }

    @FXML
    protected void handleButtonActionEvent(ActionEvent event) {
        switchToAdminEventScene(event);
    }

    @FXML
    private void switchToAdminDashboardScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Main_Admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToAdminSubjectScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Subject_Admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToAdminCourseScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Course_Admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToAdminFacultyScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Faculty_Admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToAdminEventScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Event_Admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // New method to handle dynamic student search and recommendation
    @FXML
    public void studentSearchRecommendations() {
        String searchText = studentName.getText().trim().toLowerCase();

        // If search text is empty, hide the suggestions list
        if (searchText.isEmpty()) {
            studentSuggestionsList.setVisible(false);
            return; // Don't do any filtering if the search field is empty
        }

        // Filter students based on the search input
        List<String> filteredStudentNames = students.stream()
                .map(Student::getName)
                .filter(name -> name.toLowerCase().contains(searchText))
                .collect(Collectors.toList());

        // Show filtered names in the ListView and make sure it is visible
        studentSuggestionsList.getItems().setAll(filteredStudentNames);
        studentSuggestionsList.setVisible(true);

        // Add a listener to handle selection of a student from the ListView
        studentSuggestionsList.setOnMouseClicked(event -> {
            String selectedStudentName = studentSuggestionsList.getSelectionModel().getSelectedItem();
            if (selectedStudentName != null) {
                displayStudentInfo(selectedStudentName);
                studentSuggestionsList.setVisible(false); // Hide the list once a student is selected
            }
        });
    }


    // Method to display student information when a student is selected
    private void displayStudentInfo(String studentNameInput) {
        Optional<Student> studentOptional = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(studentNameInput))
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
            studentInfo.setText("Student not found");
            studentAddress.setText("");
            studentAcademicLevel.setText("");
            studentCurrentSemester.setText("");
            studentSubject.setText("");
            studentGrade.setText("");
            studentEmail.setText("");
            studentTelephone.setText("");
        }
    }

    // Empty main method (if needed)
    public void main() {
    }

    public void handleButtonAction(ActionEvent event) {
    }
}
