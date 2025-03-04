package com.example.ums;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.awt.event.ActionEvent;

public class MainAdminController {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;

    @FXML
    protected void handleButtonAction(javafx.event.ActionEvent actionEvent) {
        System.out.println("clicked");
    }
}
