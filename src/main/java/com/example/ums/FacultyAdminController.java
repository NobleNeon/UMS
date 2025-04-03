package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.ums.FileProcessing.*;
import static com.example.ums.FileProcessing.addData;

public class FacultyAdminController {

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public Button DeleteButton;
    public Button AddButton;
    public Button NameEdit;
    public Button DegreeEdit;
    public Button IdEdit;
    public Button ResearchEdit;
    public Button EmailEdit;
    public Button OfficeEdit;
    public Button CoursesOfferedEdit;
    public RadioButton IsAdmin;
    public String newselected =null;
    public String selectedName =null;
    public boolean isedited =false;
    int globalindex = 0;
    public boolean isAdminedited =false;
    public String Changeadmin =null;
    int indexnum =3;
    @FXML
    public TextField TeacherName;
    public Label TeachNameTXTloc, TeachIdTXTloc, DegreeTXTloc, ResearchTXTloc, EmailTXTloc, OfficeTXTloc,CoursesOfferedTXTloc;
    @FXML
    private ListView<String> TeacherListSuggestions;
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
    protected void handleButtonActionStudent(ActionEvent event) {
        switchToAdminStudentScene(event);
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
    public void searchbutton(ActionEvent event){
        FacultySearch(null);
    };
    public void addbutton(ActionEvent event){AddFaculty(null);};
    public void removebutton(ActionEvent event){
        DeleteFaculty(null);
    };
    public void editnamebutton(ActionEvent event){
        int localindex = 1;
        if(globalindex != localindex){
            selectedName = newselected;

            globalindex = localindex;
        };
        NameEdit(null);
    };
    public void editidbutton(ActionEvent event){
        int localindex = 2;
        if(globalindex != localindex){
            selectedName = newselected;

            globalindex = localindex;
        };
        IdEdit(null);
    };
    public void editdegreebutton(ActionEvent event){
        int localindex = 3;
        if(globalindex != localindex){
            selectedName = newselected;

            globalindex = localindex;
        };
        DegreeEdit(null);
    };
    public void editresearchebutton(ActionEvent event){
        int localindex = 4;
        if(globalindex != localindex){
            selectedName = newselected;

            globalindex = localindex;
        };
        ResearchEdit(null);
    };
    public void editemailbutton(ActionEvent event){
        int localindex = 5;
        if(globalindex != localindex){
            selectedName = newselected;

            globalindex = localindex;
        };
        EmailEdit(null);
    };
    public void editofficeebutton(ActionEvent event){
        int localindex = 6;
        if(globalindex != localindex){
            selectedName = newselected;

            globalindex = localindex;
        };
        OfficeEdit(null);
    };
    public void editcoursesebutton(ActionEvent event){
        int localindex = 7;
        if(globalindex != localindex){
            selectedName = newselected;

            globalindex = localindex;
        };
        CourseOfferedEdit(null);
    };

    @FXML
    public String FacultySearch(String selectedName) {
        String searchText;
        if(selectedName == null) {
            searchText = TeacherName.getText().trim().toLowerCase();
        } else {
            searchText = selectedName;
            System.out.println(searchText);
        }
        TeacherListSuggestions.setVisible(true);
        // If search text is empty, hide the suggestions list
        if (searchText.isEmpty()) {
            List<String> unfilteredTeacherNames = faculties.stream()
                    .map(Faculty::getName)
                    .collect(Collectors.toList());
            //TeacherListSuggestions.setVisible(false);
            return null; // Don't do any filtering if the search field is empty
        }

        // Filter Teachers based on the search input
        List<String> filteredTeacherNames = faculties.stream()
                .map(Faculty::getName)
                .filter(name -> name.toLowerCase().contains(searchText))
                .collect(Collectors.toList());

        // Show filtered names in the ListView and make sure it is visible
        TeacherListSuggestions.getItems().setAll(filteredTeacherNames);
        TeacherListSuggestions.setVisible(true);

        // Add a listener to handle selection of a Teacher from the ListView
        TeacherListSuggestions.setOnMouseClicked(event -> {
            String selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            if (selectedTeacherName != null) {
                displayTeacherInfo(selectedTeacherName);
                //System.out.println(selectedTeacherName);
                newselected =selectedTeacherName;
                isedited = false;
                System.out.println(newselected);
                System.out.println(isedited);


                //selectedName=newselected;

                //TeacherListSuggestions.setVisible(false); // Hide the list once a teacher is selected

            }
        });
//System.out.println(searchText);
        return searchText;
    }
    private void displayTeacherInfo(String TeacherNameInput) {
        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(TeacherNameInput))
                .findFirst();

        if (facultyOptional.isPresent()) {
            Faculty faculty = facultyOptional.get();
            TeachNameTXTloc.setText(faculty.getName());
            TeachIdTXTloc.setText(faculty.getId());
            DegreeTXTloc.setText(faculty.getDegree());
            ResearchTXTloc.setText(faculty.getresearchInterest());
            EmailTXTloc.setText(faculty.getEmail());
            OfficeTXTloc.setText(faculty.getOffice());
            CoursesOfferedTXTloc.setText(faculty.getCoursesOffered());

        } else {
            TeachNameTXTloc.setText("Faculty not found");
            TeachIdTXTloc.setText("");
            DegreeTXTloc.setText("");
            ResearchTXTloc.setText("");
            EmailTXTloc.setText("");
            OfficeTXTloc.setText("");
            CoursesOfferedTXTloc.setText("");

        }
    }

    public void AddFaculty(ActionEvent event) {

        boolean canceladd = false;
        String newteacherName = getInput("Enter Faculty Name:");
        if (newteacherName == "") {
            canceladd = true;

        }else{
            String newId = "N/A";
            String newdegree = "N/A";
            String newresearchInterest = "N/A";
            String newemail = "N/A";
            String newofficeLocation = "N/A";
            String newcoursesOffered = "N/A";
            String newpassword = "N/A";
            String isAdmin = "Not Admin";
            Faculty newFaculty = new Faculty(newId, newteacherName, newdegree, newresearchInterest, newemail, newofficeLocation, newcoursesOffered,newpassword,isAdmin);
            faculties.add(newFaculty);
            addData(null,null,null,newFaculty,null,indexnum);
            FacultySearch(null);
        };

    }
    public void NameEdit(ActionEvent event) {


        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find a person name Simon


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Name", "Enter new name:", selectedFaculty.getName());
        selectedFaculty.setName(newedit);
        editData(null, null, null,selectedFaculty, null, indexnum, selectedIndex);
        newselected = FacultySearch(newedit);
        displayTeacherInfo(newedit);

    }
    public void DegreeEdit(ActionEvent event) {
        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find a person name Simon


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Degree", "Enter new Degree:", selectedFaculty.getDegree());
        selectedFaculty.setdegree(newedit);
        editData(null, null, null,selectedFaculty, null, indexnum, selectedIndex);
        newselected = FacultySearch(selectedName);
        displayTeacherInfo(selectedName);

    }
    public void IdEdit(ActionEvent event) {
        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find a person name Simon


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Id", "Enter new Id:", selectedFaculty.getId());
        selectedFaculty.setId(newedit);
        editData(null, null, null,selectedFaculty, null, indexnum, selectedIndex);
        newselected = FacultySearch(selectedName);
        displayTeacherInfo(selectedName);

    }
    public void ResearchEdit(ActionEvent event) {
        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find a person name Simon


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Name", "Enter new name code:", selectedFaculty.getresearchInterest());
        selectedFaculty.setresearch(newedit);
        editData(null, null, null,selectedFaculty, null, indexnum, selectedIndex);
        newselected = FacultySearch(selectedName);
        displayTeacherInfo(selectedName);

    }
    public void EmailEdit(ActionEvent event) {
        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find a person name Simon


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Email", "Enter new Email:", selectedFaculty.getEmail());
        selectedFaculty.setemail(newedit);
        editData(null, null, null,selectedFaculty, null, indexnum, selectedIndex);

        newselected = FacultySearch(selectedName);
        displayTeacherInfo(selectedName);

    }
    public void OfficeEdit(ActionEvent event) {
        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find a person name Simon


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Office Location", "Enter new Location:", selectedFaculty.getOffice());
        selectedFaculty.setofficeLoc(newedit);
        editData(null, null, null,selectedFaculty, null, indexnum, selectedIndex);
        newselected = FacultySearch(selectedName);
        displayTeacherInfo(selectedName);

    }
    public void CourseOfferedEdit(ActionEvent event) {
        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find the equivalent teacher name


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Courses", "Enter new Courses:", selectedFaculty.getCoursesOffered());
        selectedFaculty.setcoursesOffered(newedit);
        editData(null, null, null,selectedFaculty, null, indexnum, selectedIndex);
        newselected = FacultySearch(selectedName);
        displayTeacherInfo(selectedName);
    }
    public void IsAdmin(ActionEvent event) {
        String selectedTeacherName;
        if (isedited == false) {
            selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();
            isedited = true;
        }else{

            selectedTeacherName = newselected;

        };
        System.out.println(selectedTeacherName);


        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find a person name Simon


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }

        Faculty selectedFaculty = faculties.get(selectedIndex);
        String newedit = showInputDialog("Edit Name", "Enter new name code:", selectedFaculty.getName());
        selectedFaculty.setName(newedit);

        newselected = FacultySearch(newedit);
        displayTeacherInfo(newedit);

    }
    public void DeleteFaculty(ActionEvent event) {

        String selectedTeacherName = TeacherListSuggestions.getSelectionModel().getSelectedItem();

        Optional<Faculty> facultyOptional = faculties.stream()
                .filter(s -> s.getName().equalsIgnoreCase(selectedTeacherName))
                .findFirst();
        Faculty faculty = facultyOptional.get();
        int indexCount = 0;
        int selectedIndex = 0;
        for (Faculty tempFaculty : faculties) {//Iterating the list to find the equivalent teacher name


            if (Objects.equals(tempFaculty, faculty)) {
                selectedIndex = indexCount;


            }
            indexCount++;
        }
        Faculty selectedFaculty = faculties.get(selectedIndex);
        faculties.remove(selectedFaculty);
        removeData(indexnum,selectedIndex);
        newselected = FacultySearch(selectedName);
        displayTeacherInfo(selectedName);
    }


    private String getInput(String prompt) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Faculty Input");
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);

        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }
    private String showInputDialog(String title, String message, String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        Optional<String> result = dialog.showAndWait();
        return result.orElse(defaultValue); // Return existing value if nothing is entered
    }
}
