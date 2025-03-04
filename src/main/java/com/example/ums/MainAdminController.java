package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAdminController {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;

    @FXML
    protected void handleButtonActionSubject(javafx.event.ActionEvent event) {
        switchToAdminSubjectScene(event);
    }
    @FXML
    protected void handleButtonActionCourse(javafx.event.ActionEvent actionEvent) {
        switchToAdminSubjectScene(actionEvent);
    }
    @FXML
    protected void handleButtonActionStudent(javafx.event.ActionEvent actionEvent) {
        switchToAdminSubjectScene(actionEvent);
    }
    @FXML
    protected void handleButtonActionFaculty(javafx.event.ActionEvent actionEvent) {
        switchToAdminSubjectScene(actionEvent);
    }
    @FXML
    protected void handleButtonActionEvent(javafx.event.ActionEvent actionEvent) {
        switchToAdminSubjectScene(actionEvent);
    }

    private void switchToAdminSubjectScene(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ums/Subject_Admin.fxml")); // Update this path as needed
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

    public void handleButtonAction(ActionEvent actionEvent) {
    }
}
