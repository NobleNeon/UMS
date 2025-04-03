package com.example.ums;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ums.CalendarEvent;

import static com.example.ums.FileProcessing.events;

public class EventUserController {

    LocalDateTime dateFocus = LocalDateTime.now();
    LocalDateTime today = LocalDateTime.now();

    public MenuItem dashboardButton;
    public MenuItem subjectButton;
    public MenuItem courseButton;
    public MenuItem studentButton;
    public MenuItem facultyButton;
    public MenuItem eventButton;
    public Label year;
    public Label month;
    public FlowPane calendar;

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
    protected void handleButtonActionStudent(ActionEvent event) {
        switchToUserStudentScene(event);
    }
    @FXML
    protected void handleButtonActionFaculty(ActionEvent event) {
        switchToUserFacultyScene(event);
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


    public void handleButtonAction(ActionEvent actionEvent) {
    }

    @FXML
    private void loadCalendar(ActionEvent event){
        drawCalendar();
    }

    @FXML
    void nextMonth(ActionEvent event){
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void previousMonth(ActionEvent event) {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    private void drawCalendar(){
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        //List of events for a given month
        Map<Integer, List<CalendarEvent>> calendarEventMap = getCalendarEventsMonth(dateFocus);

        int monthMaxDate = dateFocus.getMonth().maxLength();
        //Check for leap year
        if(dateFocus.getYear() % 4 != 0 && monthMaxDate == 29){
            monthMaxDate = 28;
        }
        int dateOffset = LocalDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1,0,0,0,0).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();

                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth =(calendarWidth/7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight/6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j+1)+(7*i);
                if(calculatedDate > dateOffset){
                    int currentDate = calculatedDate - dateOffset; //
                    if(currentDate <= monthMaxDate){
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = - (rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);

                        List<CalendarEvent> calendarEvents = calendarEventMap.get(currentDate);
                        if(calendarEvents != null){
                            createCalendarEvent(calendarEvents, rectangleHeight, rectangleWidth, stackPane);
                        }
                    }
                    if(today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate){
                        rectangle.setStroke(Color.BLUE);
                    }
                }
                calendar.getChildren().add(stackPane);
            }
        }
    }

    private void createCalendarEvent(List<CalendarEvent> calendarEvent, double rectangleHeight, double rectangleWidth, StackPane stackPane) {
        VBox calendarEventBox = new VBox();
        for (int k = 0; k < calendarEvent.size(); k++) {
            if(k >= 2) {
                Text moreEvents = new Text("...");
                calendarEventBox.getChildren().add(moreEvents);
                moreEvents.setOnMouseClicked(mouseEvent -> { //On ... click print all events for given date
                    System.out.println(calendarEvent);
                });
                break;
            }
            Text text = new Text(" " + calendarEvent.get(k).getEventName() + " \n " + calendarEvent.get(k).getDate().toLocalTime());
            calendarEventBox.getChildren().add(text);
            text.setOnMouseClicked(mouseEvent -> {
                //On Text clicked
                System.out.println(calendarEvent);
            });
        }
        calendarEventBox.setTranslateY((rectangleHeight / 2) * 0.20);
        calendarEventBox.setMaxWidth(rectangleWidth * 0.6);
        calendarEventBox.setMaxHeight(rectangleHeight * 0.65);
        calendarEventBox.setStyle("-fx-background-color:GRAY");
        stackPane.getChildren().add(calendarEventBox);
    }

    private Map<Integer, List<CalendarEvent>> createCalendarMap(List<CalendarEvent> calendarEvents) {
        Map<Integer, List<CalendarEvent>> calendarEventMap = new HashMap<>();

        for (CalendarEvent event : calendarEvents) {
            int eventDate = event.getDate().getDayOfMonth();
            if(!calendarEventMap.containsKey(eventDate)){
                calendarEventMap.put(eventDate, List.of(event));
            } else {
                List<CalendarEvent> OldListByDate = calendarEventMap.get(eventDate);

                List<CalendarEvent> newList = new ArrayList<>(OldListByDate);
                newList.add(event);
                calendarEventMap.put(eventDate, newList);
            }
        }
        return calendarEventMap;
    }

    private Map<Integer, List<CalendarEvent>> getCalendarEventsMonth(LocalDateTime dateFocus) {
        List<CalendarEvent> calendarEvents = new ArrayList<>();
        int year = dateFocus.getYear();
        int month = dateFocus.getMonth().getValue();

        for(int i = 0; i<events.size(); i++) {
            LocalDateTime eventDate = convertFromExcelSerial(events.get(i).dateAndTime);
            String eventName = events.get(i).eventName;
            String eventLocation = events.get(i).location;

            if(eventDate.getMonthValue() == month && eventDate.getYear() == year) {
                calendarEvents.add(new CalendarEvent(eventDate, eventName, eventLocation));
            }
        }
        return createCalendarMap(calendarEvents);
    }

    private static LocalDateTime convertFromExcelSerial(String excelSerialString) {
        try{
            double excelSerial = Double.parseDouble(excelSerialString);
        } catch (NumberFormatException e) {
            excelSerialString = String.valueOf(convertToExcelSerial(excelSerialString));
        }
        double excelSerial = Double.parseDouble(excelSerialString);
        LocalDate EXCEL_EPOCH = LocalDate.of(1899, 12, 30);
        long days = (long) excelSerial;

        LocalDate date = EXCEL_EPOCH.plusDays(days);

        double timeFraction = excelSerial - (long) excelSerial;
        long nanos = (long) (timeFraction * 24 * 60 * 60 * 1_000_000_000L);
        LocalTime time = LocalTime.ofNanoOfDay(1 + nanos).truncatedTo(ChronoUnit.MINUTES);

        return LocalDateTime.of(date, time);
    }

    private static double convertToExcelSerial(String dateString) {
        LocalDate EXCEL_EPOCH = LocalDate.of(1899, 12, 30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter); // Parse the input string

        long days = ChronoUnit.DAYS.between(EXCEL_EPOCH, dateTime.toLocalDate()); // Calculate days since Excel epoch
        double timeFraction = dateTime.getHour() / 24.0 + dateTime.getMinute() / (24.0 * 60); // Calculate time fraction (portion of 24 hours)

        return days + timeFraction;
    }
}
