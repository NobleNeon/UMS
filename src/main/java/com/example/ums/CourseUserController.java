package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.ums.FileProcessing.courses;
import static com.example.ums.FileProcessing.students;
import static com.example.ums.LoginController.GlobalVariables.currentFaculty;
import static com.example.ums.LoginController.GlobalVariables.currentStudent;

public class CourseUserController implements Initializable {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public ListView<String> CourseList;
    public Button LoadStudentsButton;

    @FXML
    protected void handleButtonActionDashboard(ActionEvent event) {
        switchToUserDashboardScene(event);
    }
    @FXML
    protected void handleButtonActionSubject(ActionEvent event) {
        switchToUserSubjectScene(event);
    }
    @FXML
    protected void handleButtonActionStudent(ActionEvent event) {
        switchToUserStudentScene(event);
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
    private void switchToUserStudentScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Student_User.fxml")); // Update if needed
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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the subjectList as a new ArrayList
        ArrayList<String> courseList = new ArrayList<>();

        if (currentStudent != null) {
          List<String> subjectsStudent = splitString(currentStudent.subjectsRegistered);
          System.out.println(subjectsStudent);
          for (String subject : subjectsStudent) {
              for (Course course : courses) {
                  if (subject.equals(course.getSubjectCode())) {
                      courseList.add(course.toString());
                  }
              }
          }
          LoadStudentsButton.setVisible(false);
        }
        else{
            courseList.addAll(splitString(currentFaculty.coursesOffered));
        }

        // Assuming 'subjectListView' is your ListView or appropriate control
        CourseList.getItems().addAll(courseList);
    }

    public void LoadStudents(ActionEvent event) {
        List<Student> enrolledStudents = new ArrayList<>();

        // Get the selected course name from the CourseList ListView
        String selectedCourseName = CourseList.getSelectionModel().getSelectedItem();
        if (selectedCourseName == null) {
            return; // Exit if no course is selected
        }

        // Find the subject that corresponds to the selected course
        String selectedCourseSubject = null;
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(selectedCourseName)) {
                selectedCourseSubject = course.getSubjectCode();// Get the subject for the selected course
                System.out.println(selectedCourseSubject);
                System.out.println(course);
                break;
            }
        }

        // If no matching course is found, exit
        if (selectedCourseSubject == null) {
            return;
        }

        // Loop through all students to find those enrolled in the selected subject
        for (Student student : students) {
            // Get student's registered subjects (comma-separated)
            String studentSubjects = student.getSubject();
            if (studentSubjects == null || studentSubjects.isEmpty()) {
                continue; // Skip if no subjects are registered
            }

            // Split subjects by comma and check if student is enrolled in the selected subject
            String[] subjects = studentSubjects.split(",\\s*");
            for (String subject : subjects) {
                if (subject.equalsIgnoreCase(selectedCourseSubject)) {
                    enrolledStudents.add(student); // Add student if subject matches
                    break; // No need to check further subjects
                }
            }
        }

        // Build content string to display in the alert dialog
        StringBuilder content = new StringBuilder();
        if (enrolledStudents.isEmpty()) {
            content.append("No students are enrolled in this course.");
        } else {
            for (Student student : enrolledStudents) {
                content.append("Name: " + student.getName() + " ");
                content.append("ID: " + student.getId());// Add student name to content
            }
        }

        // Create and configure the alert dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Enrolled Students");
        alert.setHeaderText("Students Enrolled in " + selectedCourseName);

        // Use a TextArea to display the content for better formatting
        TextArea textArea = new TextArea(content.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        // Set the preferred size of the TextArea
        textArea.setPrefSize(350, 150);

        // Set the content of the alert dialog
        alert.getDialogPane().setContent(textArea);

        // Adjust the size of the alert dialog
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

        // Show the alert dialog
        alert.showAndWait();
    }

    public static List<String> splitString(String input) {
        List<String> resultList = new ArrayList<>();

        if (input == null || input.isEmpty()) {
            return resultList; // Return an empty list if the input is null or empty
        }

        // Split the input string by commas
        String[] parts = input.split(",");

        // Process each part
        for (String part : parts) {
            // Trim leading and trailing spaces but preserve spaces within words
            String trimmedPart = part.trim();
            if (!trimmedPart.isEmpty()) {
                resultList.add(trimmedPart);
            }
        }

        return resultList;
    }
}
