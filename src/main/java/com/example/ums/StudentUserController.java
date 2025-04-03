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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import java.io.File;

import static com.example.ums.FileProcessing.students;

public class StudentUserController {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;

    @FXML
    public Label studentInfo, studentAddress, studentAcademicLevel, studentCurrentSemester, studentSubject, studentGrade, studentEmail, studentTelephone, studentTuition;

    @FXML
    private ImageView imageView;


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
    public void displayStudentProfile() {
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


            // Update labels with student information
            studentInfo.setText(student.getName());
            studentAddress.setText(student.getAddress());
            studentAcademicLevel.setText(student.getAcademicLevel());
            studentCurrentSemester.setText(student.getCurrentSemester());
        } else {
            System.out.println("Student not found for ID: " + LoginController.GlobalVariables.userId);
        }
    }


    @FXML
    private void handleSetProfilePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Picture");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // User selects the file
        File selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());

        if (selectedFile != null) {
            // Display the selected image in the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);

            // Retrieve the current student (replace with the correct logic for the logged-in student)
            Optional<Student> studentOptional = students.stream()
                    .filter(student -> student.getId().equals(LoginController.GlobalVariables.userId))
                    .findFirst();

            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();

                // Save the image to the "profile_pictures" directory
                File targetDirectory = new File("profile_pictures");
                String absolutePath = targetDirectory.getAbsolutePath();
                if (!targetDirectory.exists()) {
                    targetDirectory.mkdir(); // Create the directory if it doesn't exist
                }

                // Use the student's ID to name the image file
                File targetFile = new File(absolutePath, student.getId() + ".png");

                try {
                    // Copy the selected file to the target directory
                    java.nio.file.Files.copy(
                            selectedFile.toPath(),
                            targetFile.toPath(),
                            java.nio.file.StandardCopyOption.REPLACE_EXISTING
                    );

                    // Update the student's profile picture path
                    student.setProfilePicturePath(targetFile.getAbsolutePath());


                    // Persist the updated student data
                    FileProcessing.saveStudents(students);

                    System.out.println("Profile picture set and saved: " + student.getprofilePicturePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Logged-in student not found.");
            }
        } else {
            System.out.println("No file was selected.");
        }
    }


}






