package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.ums.FileProcessing.*;

public class CourseAdminController implements Initializable {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public ListView<String> CourseList;
    public Button DeleteButton;


    @FXML
    protected void handleButtonActionDashboard(ActionEvent event) {
        switchToAdminDashboardScene(event);
    }
    @FXML
    protected void handleButtonActionSubject(ActionEvent event) {
        switchToAdminSubjectScene(event);
    }
    @FXML
    protected void handleButtonActionStudent(ActionEvent event) {
        switchToAdminStudentScene(event);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Main_Admin.fxml")); // Update if needed
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
    private void switchToAdminSubjectScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Subject_Admin.fxml")); // Update if needed
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
    private void switchToAdminStudentScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Student_Admin.fxml")); // Update if needed
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
    private void switchToAdminFacultyScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Faculty_Admin.fxml")); // Update if needed
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
    private void switchToAdminEventScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Event_Admin.fxml")); // Update if needed
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

    public void handleAddCourse(ActionEvent event) {
        // Function to prompt user for input
        String courseCode = getInput("Enter Course Code:");
        if (courseCode == null) return;

        String courseName = getInput("Enter Course Name:");
        if (courseName == null) return;

        String sectionNumber = getInput("Enter Section Number:");
        if (sectionNumber == null) return;

        String subjectCode = getInput("Enter Subject Code:");
        if (subjectCode == null) return;

        String capacity = getInput("Enter Course Capacity:");
        if (capacity == null) return;

        String lectureTime = getInput("Enter Lecture Time:");
        if (lectureTime == null) return;

        String finalExamDateTime = getInput("Enter Final Exam Date & Time:");
        if (finalExamDateTime == null) return;

        String location = getInput("Enter Course Location:");
        if (location == null) return;

        String teacherName = getInput("Enter Teacher's Name:");
        if (teacherName == null) return;

        // Create a new course object (assuming a constructor exists)
        Course newCourse = new Course(courseCode, courseName, sectionNumber, subjectCode, capacity, lectureTime, finalExamDateTime, location, teacherName);

        // Add to list and refresh UI
        courses.add(newCourse);
        int indexnum = 1;
        addData(newCourse,null,null, null, null, indexnum);
        refreshCourseList();
    }



    // Helper method to display a TextInputDialog
    private String getInput(String prompt) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Course Input");
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);

        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }

    private void refreshCourseList() {
        CourseList.getItems().clear();
        for (Course course : courses) {
            CourseList.getItems().add(course.toString());
        }
    }

    public void handleEditCourse(ActionEvent event) {
        // Get the selected course from the ListView
        int indexnum = 1;
        int selectedIndex = CourseList.getSelectionModel().getSelectedIndex();

        if (selectedIndex == -1) {
            showAlert("No Course Selected", "Please select a course to edit.");
            return;
        }

        // Get the existing course object
        Course selectedCourse = courses.get(selectedIndex);

        // Ask for new values using TextInputDialogs
        String newCourseCode = showInputDialog("Edit Course Code", "Enter new course code:", selectedCourse.getCourseCode());
        String newCourseName = showInputDialog("Edit Course Name", "Enter new course name:", selectedCourse.getCourseName());
        String newSectionNumber = showInputDialog("Edit Section Number", "Enter new section number:", selectedCourse.getSectionNumber());
        String newSubjectCode = showInputDialog("Edit Subject Code", "Enter new subject code:", selectedCourse.getSubjectCode());
        String newCapacity = showInputDialog("Edit Capacity", "Enter new capacity:", String.valueOf(selectedCourse.getCapacity()));
        String newLectureTime = showInputDialog("Edit Lecture Time", "Enter new lecture time:", selectedCourse.getLectureTime());
        String newFinalExamDateTime = showInputDialog("Edit Final Exam Date", "Enter new final exam date/time:", selectedCourse.getFinalExamDateTime());
        String newLocation = showInputDialog("Edit Location", "Enter new location:", selectedCourse.getLocation());
        String newTeacherName = showInputDialog("Edit Teacher Name", "Enter new teacher name:", selectedCourse.getTeacherName());

        // Update the course object
        selectedCourse.setCourseCode(newCourseCode);
        selectedCourse.setCourseName(newCourseName);
        selectedCourse.setSectionNumber(newSectionNumber);
        selectedCourse.setSubjectCode(newSubjectCode);
        selectedCourse.setCapacity(newCapacity);
        selectedCourse.setLectureTime(newLectureTime);
        selectedCourse.setFinalExamDateTime(newFinalExamDateTime);
        selectedCourse.setLocation(newLocation);
        selectedCourse.setTeacherName(newTeacherName);

        editData(selectedCourse,null,null, null, null, indexnum, selectedIndex);
        // Refresh the list to reflect changes
        refreshCourseList();
    }

    // Helper method to show input dialog
    private String showInputDialog(String title, String message, String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        Optional<String> result = dialog.showAndWait();
        return result.orElse(defaultValue); // Return existing value if nothing is entered
    }

    public void handleDeleteCourse(ActionEvent event) {
        // Get the selected course from the ListView
        int selectedIndex = CourseList.getSelectionModel().getSelectedIndex();

        if (selectedIndex == -1) {
            showAlert("No Course Selected", "Please select a course to delete.");
            return;
        }

        // Confirmation alert before deletion
        Course selectedCourse = courses.get(selectedIndex);
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirm Deletion");
        confirmation.setHeaderText("Are you sure you want to delete this course?");
        confirmation.setContentText(selectedCourse.toString());

        // Check if user confirmed deletion
        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Remove from list and refresh UI
            int indexnum = 1;
            int totalrows = 0;

            for(Course tempcourse : courses) {

                totalrows++;
            }
System.out.println("Total rows: " + totalrows);
            courses.remove(selectedIndex);
            removeData(indexnum,selectedIndex,totalrows);

            refreshCourseList();



        }
    }

    // Helper method to show an alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the subjectList as a new ArrayList
        ArrayList<String> courseList = new ArrayList<>();

        // Assuming 'subjects' is already defined and contains a list of subject objects
        for (int i = 0; i < courses.size(); i++) {
            courseList.add(courses.get(i).toString());  // Add each subject to the list
        }

        // Assuming 'subjectListView' is your ListView or appropriate control
        CourseList.getItems().addAll(courseList);
    }
}
