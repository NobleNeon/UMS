package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.ums.FileProcessing.subjects;

public class SubjectUserController implements Initializable {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public ListView SubjectList;

    @FXML
    protected void handleButtonActionDashboard(ActionEvent event) {
        switchToUserDashboardScene(event);
    }
    @FXML
    protected void handleButtonActionCourse(ActionEvent event) {
        switchToUserCourseScene(event);
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
        ArrayList<String> subjectList = new ArrayList<>();

        // Assuming 'subjects' is already defined and contains a list of subject objects
        for (int i = 0; i < subjects.size(); i++) {
            subjectList.add(subjects.get(i).toString());  // Add each subject to the list
        }

        // Assuming 'subjectListView' is your ListView or appropriate control
        SubjectList.getItems().addAll(subjectList);
    }
}
