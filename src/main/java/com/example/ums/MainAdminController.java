package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Table;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.ums.FileProcessing.courses;
import static com.example.ums.FileProcessing.students;
import static com.example.ums.FileProcessing.subjects;
import static com.example.ums.FileProcessing.faculties;
import static com.example.ums.FileProcessing.events;

public class MainAdminController {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public ListView<String> TableSubjects;
    public ListView<String> CourseList;
    public ListView<String> StudentsList;
    public ListView<String> FacultyList;
    public ListView<String> EventsList;
    public Button LoadData;

    @FXML
    protected void handleButtonActionSubject(javafx.event.ActionEvent event) {
        switchToAdminSubjectScene(event);
    }
    @FXML
    protected void handleButtonActionCourse(javafx.event.ActionEvent event) {
        switchToAdminCourseScene(event);
    }
    @FXML
    protected void handleButtonActionStudent(javafx.event.ActionEvent event) {
        switchToAdminStudentScene(event);
    }
    @FXML
    protected void handleButtonActionFaculty(javafx.event.ActionEvent event) {
        switchToAdminFacultyScene(event);
    }
    @FXML
    protected void handleButtonActionEvent(javafx.event.ActionEvent event) {
        switchToAdminEventScene(event);
    }

    @FXML
    private void handleLoadButton(ActionEvent event) {
        ArrayList<String> courseList = new ArrayList<>();
        ArrayList<String> studentList = new ArrayList<>();
        ArrayList<String> facultyList = new ArrayList<>();
        ArrayList<String> eventList = new ArrayList<>();
        ArrayList<String> subjectList = new ArrayList<>();

        // Assuming 'subjects' is already defined and contains a list of subject objects
        for (int i = 0; i < courses.size(); i++) {
            courseList.add(courses.get(i).toString());  // Add each subject to the list
        }
        for (int i = 0; i < students.size(); i++) {
            studentList.add(students.get(i).toString());
        }
        for (int i = 0; i < faculties.size(); i++) {
            facultyList.add(faculties.get(i).toString());
        }
        for (int i = 0; i < events.size(); i++) {
            eventList.add(events.get(i).toString());
        }
        for (int i = 0; i < subjects.size(); i++) {
            subjectList.add(subjects.get(i).toString());
        }


        // Assuming 'subjectListView' is your ListView or appropriate control
        CourseList.getItems().addAll(courseList);
        StudentsList.getItems().addAll(studentList);
        FacultyList.getItems().addAll(facultyList);
        EventsList.getItems().addAll(eventList);
        TableSubjects.getItems().addAll(subjectList);
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
    private void switchToAdminCourseScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Course_Admin.fxml")); // Update if needed
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
}
