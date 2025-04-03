package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.Optional;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.ums.FileProcessing.*;

public class SubjectAdminController implements Initializable {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public ListView<String> SubjectList;
    public Button DeleteButton;

    @FXML
    protected void handleButtonActionDashboard(ActionEvent event) {
        switchToAdminDashboardScene(event);
    }
    @FXML
    protected void handleButtonActionCourse(ActionEvent event) {
        switchToAdminCourseScene(event);
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

    @FXML
    private void handleAddSubject(ActionEvent event) {
        int indexnum = 0;
        // Create a TextInputDialog for getting the subject code
        TextInputDialog subjectCodeDialog = new TextInputDialog();
        subjectCodeDialog.setTitle("Add New Subject");
        subjectCodeDialog.setHeaderText("Enter Subject Code:");
        subjectCodeDialog.setContentText("Subject Code:");

        // Show the dialog and capture the result for subject code
        Optional<String> subjectCodeResult = subjectCodeDialog.showAndWait();
        if (subjectCodeResult.isPresent()) {
            String subjectCode = subjectCodeResult.get();

            // Now, ask for the subject name
            TextInputDialog subjectNameDialog = new TextInputDialog();
            subjectNameDialog.setTitle("Add New Subject");
            subjectNameDialog.setHeaderText("Enter Subject Name:");
            subjectNameDialog.setContentText("Subject Name:");

            // Show the dialog and capture the result for subject name
            Optional<String> subjectNameResult = subjectNameDialog.showAndWait();
            if (subjectNameResult.isPresent()) {
                String subjectName = subjectNameResult.get();

                // Create a new Subject object
                Subject newSubject = new Subject(subjectCode, subjectName);

                // Add the new Subject to the List<Subject>
                subjects.add(newSubject);
                addData(null,null,newSubject,indexnum);;
                // Add the new Subject to the ListView (using toString() to display)
                SubjectList.getItems().add(newSubject.toString());

                // Optionally, refresh the ListView to ensure it reflects the change
                SubjectList.refresh();
            } else {
                // If the user cancels or does not provide a subject name
                showAlert("Input Error", "Subject Name is required.");
            }
        } else {
            // If the user cancels or does not provide a subject code
            showAlert("Input Error", "Subject Code is required.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    private void handleEditSubject(ActionEvent event) {
        int indexnum = 0;
        // Get the currently selected subject from the ListView
        String selectedSubjectString = SubjectList.getSelectionModel().getSelectedItem();

        if (selectedSubjectString != null) {
            // Extract the subject code and name from the selected subject string
            String[] parts = selectedSubjectString.split(", ");
            String subjectCode = parts[0].split(": ")[1];  // Extract code part (e.g., "CS101")
            String subjectName = parts[1].split(": ")[1];  // Extract name part (e.g., "Computer Science 101")

            // Create dialogs to edit the subject code and name
            TextInputDialog subjectCodeDialog = new TextInputDialog(subjectCode);
            subjectCodeDialog.setTitle("Edit Subject");
            subjectCodeDialog.setHeaderText("Edit Subject Code:");
            subjectCodeDialog.setContentText("Subject Code:");

            Optional<String> newSubjectCodeResult = subjectCodeDialog.showAndWait();
            if (newSubjectCodeResult.isPresent()) {
                String newSubjectCode = newSubjectCodeResult.get();

                // Now, ask for the new subject name
                TextInputDialog subjectNameDialog = new TextInputDialog(subjectName);
                subjectNameDialog.setTitle("Edit Subject");
                subjectNameDialog.setHeaderText("Edit Subject Name:");
                subjectNameDialog.setContentText("Subject Name:");

                Optional<String> newSubjectNameResult = subjectNameDialog.showAndWait();
                if (newSubjectNameResult.isPresent()) {
                    String newSubjectName = newSubjectNameResult.get();

                    // Update the selected subject in the List<Subject>
                    Subject selectedSubject = getSubjectByCode(subjectCode);
                    if (selectedSubject != null) {
                        selectedSubject.subjectCode = newSubjectCode;
                        selectedSubject.subjectName = newSubjectName;


                        int selectedIndex = subjects.indexOf(selectedSubject);
                        editData(null,selectedSubject,null,indexnum,selectedIndex);
                        // Refresh the ListView to reflect the changes
                        SubjectList.getItems().clear();  // Clear current items
                        for (Subject subject : subjects) {
                            SubjectList.getItems().add(subject.toString());  // Add updated subjects
                        }
                    }
                } else {
                    // If the user cancels or does not provide a new subject name
                    showAlert("Input Error", "Subject Name is required.");
                }
            } else {
                // If the user cancels or does not provide a new subject code
                showAlert("Input Error", "Subject Code is required.");
            }
        } else {
            // If no subject is selected
            showAlert("Selection Error", "Please select a subject to edit.");
        }
    }

    private Subject getSubjectByCode(String subjectCode) {
        for (Subject subject : subjects) {
            if (subject.subjectCode.equals(subjectCode)) {
                return subject;
            }
        }
        return null;
    }

    @FXML
    private void handleDeleteSubject(ActionEvent event) {
        // Get the selected subject from the ListView
        int indexnum = 0;
        String selectedSubject = SubjectList.getSelectionModel().getSelectedItem();

        if (selectedSubject != null) {
            // Confirm deletion (Optional: use a dialog to confirm)
            boolean confirm = showConfirmationDialog("Are you sure you want to delete the subject: " + selectedSubject + "?");
            if (confirm) {


                // Remove from the List<Subject>
                removeSubjectFromList(selectedSubject);

                // Remove from the ListView
                SubjectList.getItems().remove(selectedSubject);

                // Optionally, refresh the ListView
                SubjectList.refresh();
            }
        }
    }

    private void removeSubjectFromList(String subject) {
        // Assuming subjects is a List<Subject>, find and remove the subject
        for (Subject s : subjects) {
            if (s.toString().equals(subject)) {
                int indexnum = 0;
                int selectedIndex = subjects.indexOf(s);
                removeData(indexnum,selectedIndex);
                subjects.remove(s);
                break;
            }
        }
    }

    private boolean showConfirmationDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Deletion");
        alert.setHeaderText("Delete Subject");
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }


    @Override
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
