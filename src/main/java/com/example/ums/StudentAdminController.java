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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.example.ums.FileProcessing.*;

public class StudentAdminController {

    // Menu items for navigation (existing code)
    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public ListView<String> StudentList;

    // TextField for student name search and other labels for student info display
    @FXML
    public TextField studentName;
    public Label studentInfo, studentAddress, studentAcademicLevel, studentCurrentSemester, studentSubject, studentGrade, studentEmail, studentTelephone, studentTuition;

    @FXML
    private ImageView imageView;
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
        List<String> filteredStudents = students.stream()
                .map(Student::getName)
                .filter(name -> name.toLowerCase().contains(searchText))
                .collect(Collectors.toList());



        // Show filtered names in the ListView and make sure it is visible
        studentSuggestionsList.getItems().clear();
        studentSuggestionsList.getItems().addAll(filteredStudents);

        // Ensure visibility
        studentSuggestionsList.setVisible(!filteredStudents.isEmpty());

    }
    @FXML
    public void initialize() {
        // Initially hide the suggestions list
        studentSuggestionsList.setVisible(false);

        // Set up listener for text changes
        studentName.textProperty().addListener((observable, oldValue, newValue) -> {
            studentSearchRecommendations();
        });

        // Set up selection behavior for the suggestions list
        studentSuggestionsList.setOnMouseClicked(event -> {
            String selectedStudent = studentSuggestionsList.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                studentName.setText(selectedStudent);
                displayStudentInfo(selectedStudent);
                studentSuggestionsList.setVisible(false);
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
            studentTuition.setText(student.getTuition());
            String profilePicturePath = student.getprofilePicturePath();
            if (profilePicturePath != null && !profilePicturePath.isEmpty()) {
                File file = new File(profilePicturePath);
                if (file.exists()) {
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image); // Set to ImageView
                } else {
                    System.err.println("Profile picture file not found: " + profilePicturePath);
                }
            } else {
                System.out.println("No profile picture path found for student: " + LoginController.GlobalVariables.userId);
            }
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
    @FXML
    public void handleEditStudent(ActionEvent event) {
        // Get the currently selected student name from the studentInfo label
        String currentStudentName = studentInfo.getText();

        // Find the selected student in the students list
        Optional<Student> studentOptional = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(currentStudentName))
                .findFirst();

        if (!studentOptional.isPresent()) {
            showAlert("Error", "No student selected or student not found.");
            return;
        }

        Student selectedStudent = studentOptional.get();

        // Collect new information through input dialogs
        String newId = showInputDialog("Edit Student ID", "Enter new student ID:", selectedStudent.getId());
        if (newId == null) return; // User canceled

        String newName = showInputDialog("Edit Student Name", "Enter new student name:", selectedStudent.getName());
        if (newName == null) return;

        String newAddress = showInputDialog("Edit Address", "Enter new address:", selectedStudent.getAddress());
        if (newAddress == null) return;

        String newTelephone = showInputDialog("Edit Telephone", "Enter new telephone:", selectedStudent.getTelephone());
        if (newTelephone == null) return;

        String newEmail = showInputDialog("Edit Email", "Enter new email:", selectedStudent.getEmail());
        if (newEmail == null) return;

        String newAcademicLevel = showInputDialog("Edit Academic Level", "Enter new academic level:", selectedStudent.getAcademicLevel());
        if (newAcademicLevel == null) return;

        String newCurrentSemester = showInputDialog("Edit Current Semester", "Enter new current semester:", selectedStudent.getCurrentSemester());
        if (newCurrentSemester == null) return;

        String newSubjectsRegistered = showInputDialog("Edit Subjects Registered", "Enter new subjects registered:", selectedStudent.getSubject());
        if (newSubjectsRegistered == null) return;

        String newProgress = showInputDialog("Edit Grade/Progress", "Enter new grade/progress:", selectedStudent.getGrade());
        if (newProgress == null) return;

        // Update the student object with new values
        selectedStudent.id = newId;
        selectedStudent.name = newName;
        selectedStudent.address = newAddress;
        selectedStudent.telephone = newTelephone;
        selectedStudent.email = newEmail;
        selectedStudent.academicLevel = newAcademicLevel;
        selectedStudent.currentSemester = newCurrentSemester;
        selectedStudent.subjectsRegistered = newSubjectsRegistered;
        selectedStudent.progress = newProgress;

        // Call the editData method to save changes to the Excel file
        // The constant value 2 represents the student data sheet index
        int studentSheetIndex = 2;
        int selectedIndex = students.indexOf(selectedStudent);
        editData(null, null, selectedStudent, null, null, studentSheetIndex, selectedIndex);

        // Refresh the displayed student information
        displayStudentInfo(newName);

        // Refresh the student list if available
        if (StudentList != null && StudentList.getItems() != null) {
            // Clear and repopulate the student list
            StudentList.getItems().clear();
            for (Student student : students) {
                StudentList.getItems().add(student.getName());
            }
        }
        FileProcessing.serializeStudents();
        // Show confirmation message
        showAlert("Success", "Student information updated successfully.");
    }
    private String showInputDialog(String title, String message, String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }





    // Empty main method (if needed)
    public void main() {
    }

    public void handleButtonAction(ActionEvent event) {
    }
}
