package com.example.ums;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;
import java.io.Serializable;

class Faculty {
    String facultyID, name, degree, researchInterest, email, officeLocation, coursesOffered, password, role;

    public Faculty(String facultyID, String name, String degree, String researchInterest, String email, String officeLocation, String coursesOffered, String password, String role) {
        this.facultyID = facultyID;
        this.name = name;
        this.degree = degree;
        this.researchInterest = researchInterest;
        this.email = email;
        this.officeLocation = officeLocation;
        this.coursesOffered = coursesOffered;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Faculty[ID=%s, Name=%s, Degree=%s, Research Interest=%s, Email=%s, Office=%s, Courses Offered=%s, Role=%s]",
                facultyID, name, degree, researchInterest, email, officeLocation, coursesOffered, role);
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return facultyID;
    }
    public String getDegree() {
        return degree;
    }
    public String getresearchInterest() {
        return researchInterest;
    }
    public String getEmail() {
        return email;
    }
    public String getOffice() {
        return officeLocation;
    }
    public String getCoursesOffered() {
        return coursesOffered;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    };
    public void setId(String facultyID) {
        this.facultyID = facultyID;
    };
    public void setdegree(String degree) {
        this.degree = degree;
    };
    public void setresearch(String researchInterest) {
        this.researchInterest = researchInterest;
    };
    public void setemail(String email) {
        this.email = email;
    };

    public void setofficeLoc(String officeLocation) {
        this.officeLocation = officeLocation;
    };
    public void setcoursesOffered(String coursesOffered) {
        this.coursesOffered = coursesOffered;
    };
}


class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    String id, name, address, telephone, email, academicLevel, currentSemester, profilePhoto, subjectsRegistered, thesisTitle, progress, password, tuition, profilePicturePath;

    public Student(String id, String name, String address, String telephone, String email, String academicLevel, String currentSemester, String profilePhoto, String subjectsRegistered, String thesisTitle, String progress, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.academicLevel = academicLevel;
        this.currentSemester = currentSemester;
        this.profilePhoto = profilePhoto;
        this.subjectsRegistered = subjectsRegistered;
        this.thesisTitle = thesisTitle;
        this.progress = progress;
        this.password = password;
        this.tuition = tuition;
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%s Name=%s, Address=%s, Telephone=%s, Email=%s, Academic Level=%s, Current Semester=%s, Profile Photo=%s, Subjects Registered=%s, Thesis Title=%s, Progress=%s, Tuition=%s]",
                id, name, address, telephone, email, academicLevel, currentSemester, profilePhoto, subjectsRegistered, thesisTitle, progress, tuition);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public String getCurrentSemester() {
        return currentSemester;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSubject() {
        return subjectsRegistered;
    }

    public String getGrade() {
        return progress;
    }

    public String getTuition() {
        return tuition;
    }

    public String getId() {
        return id;
    }

    public void setProfilePicturePath(String profilePicturePath){
        this.profilePicturePath = profilePicturePath;
    }

    public String getprofilePicturePath() {
        return profilePicturePath;
    }
}


class Course {
    String courseCode, courseName, sectionNumber, subjectCode, capacity, lectureTime, finalExamDateTime, location, teacherName;

    public Course(String courseCode, String courseName, String sectionNumber, String subjectCode, String capacity, String lectureTime, String finalExamDateTime, String location, String teacherName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.sectionNumber = sectionNumber;
        this.subjectCode = subjectCode;
        this.capacity = capacity;
        this.lectureTime = lectureTime;
        this.finalExamDateTime = finalExamDateTime;
        this.location = location;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return String.format("Course Code: %s Course Name: %s  Section: %s Subject Code: %s Capacity: %s Lecture Time: %s Final Exam Date/Time: %s Location: %s Teacher Name: %s",
                courseCode, courseName, sectionNumber, subjectCode, capacity, lectureTime, finalExamDateTime, location, teacherName);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getCapacity() {  // Updated to return String
        return capacity;
    }

    public String getLectureTime() {
        return lectureTime;
    }

    public String getFinalExamDateTime() {
        return finalExamDateTime;
    }

    public String getLocation() {
        return location;
    }

    public String getTeacherName() {
        return teacherName;
    }

    // Setters
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setCapacity(String capacity) {  // Updated to accept String
        this.capacity = capacity;
    }

    public void setLectureTime(String lectureTime) {
        this.lectureTime = lectureTime;
    }

    public void setFinalExamDateTime(String finalExamDateTime) {
        this.finalExamDateTime = finalExamDateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}


class Event {
    String eventCode, eventName, description, location, dateAndTime, capacity, cost, headerImage, registeredStudents;
    public static int count;

    public Event(String eventName, String description, String location, String dateAndTime, String capacity, String cost, String headerImage, String registeredStudents) {
        count++;
        this.eventCode = "EV00" + count;
        this.eventName = eventName;
        this.description = description;
        this.location = location;
        this.dateAndTime = dateAndTime;
        this.capacity = capacity;
        this.cost = cost;
        this.headerImage = headerImage;
        this.registeredStudents = registeredStudents;
    }

    @Override
    public String toString() {
        return String.format("Event[Code=%s, Name=%s, Description=%s, Location=%s, Date and Time=%s, Capacity=%s, Cost=%s, Header Image=%s, Registered Students=%s]",
                eventCode, eventName, description, location, dateAndTime, capacity, cost, headerImage, registeredStudents);
    }
}


class Subject {
    String subjectCode, subjectName;

    public Subject(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return String.format("Code: %s, Name: %s", subjectCode, subjectName);
    }
}



class processFile {
    public static List<Faculty> parseFaculties(Sheet sheet) {
        List<Faculty> faculties = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            List<String> values = getRowValues(row, 9);
            if (values.stream().allMatch(String::isEmpty)) continue;

            faculties.add(new Faculty(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8)));
        }
        return faculties;
    }

    public static List<Student> parseStudents(Sheet sheet) {
        List<Student> students = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            List<String> values = getRowValues(row, 12);
            if (values.stream().allMatch(String::isEmpty)) continue;

            students.add(new Student(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8), values.get(9), values.get(10), values.get(11)));
        }
        return students;
    }

    public static List<Course> parseCourses(Sheet sheet) {
        List<Course> courses = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            List<String> values = getRowValues(row, 9);
            if (values.stream().allMatch(String::isEmpty)) continue;

            courses.add(new Course(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8)));
        }
        return courses;
    }

    public static List<Event> parseEvents(Sheet sheet) {
        List<Event> events = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            List<String> values = getRowValues(row, 9);
            if (values.stream().allMatch(String::isEmpty)) continue;

            events.add(new Event(values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8)));
        }
        return events;
    }

    public static List<Subject> parseSubjects(Sheet sheet) {
        List<Subject> subjects = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            List<String> values = getRowValues(row, 2);
            if (values.stream().allMatch(String::isEmpty)) continue;

            subjects.add(new Subject(values.get(0), values.get(1)));
        }
        return subjects;
    }

    private static List<String> getRowValues(Row row, int numCells) {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < numCells; i++) {
            values.add(getCellValue(row.getCell(i)));
        }
        return values;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue()).trim();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()).trim();
            case FORMULA:
                return cell.getCellFormula().trim();
            default:
                return "";
        }
    }
}


public class FileProcessing {
    public static List<Faculty> faculties = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();
    public static List<Subject> subjects = new ArrayList<>();


    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students_data.ser"))) {
            oos.writeObject(students); // Serialize the entire list of students
            System.out.println("Students data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error while saving students data: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students_data.ser"))) {
            students = (List<Student>) ois.readObject(); // Deserialize the list of students
            System.out.println("Students data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while loading students data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadStudent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.ser"))) {
            students = (List<Student>) ois.readObject(); // Deserialize the list of students
            System.out.println("Students data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while loading students data: " + e.getMessage());
        }
    }

    public static void loadData() {
        try (FileInputStream file = new FileInputStream(new File("src/main/resources/UMS_Data.xlsx").getAbsolutePath());
             Workbook workbook = new XSSFWorkbook(file)) {


            faculties = processFile.parseFaculties(workbook.getSheetAt(3));
            students = processFile.parseStudents(workbook.getSheetAt(2));
            courses = processFile.parseCourses(workbook.getSheetAt(1));
            events = processFile.parseEvents(workbook.getSheetAt(4));
            subjects = processFile.parseSubjects(workbook.getSheetAt(0));

            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addData(Course newCourse, Subject newSubject, Student newStudent, Faculty newFaculty, Event newEvent, int indexnum) {


        try (FileInputStream file = new FileInputStream(new File("src/main/resources/UMS_Data.xlsx").getAbsolutePath());// Reading the workbook
             Workbook workbook = new XSSFWorkbook(file)) {//creates a work book from the xlsx
            XSSFSheet subjectdata = (XSSFSheet) workbook.getSheetAt(0);
            XSSFSheet coursedata = (XSSFSheet) workbook.getSheetAt(1);
            XSSFSheet studentdata = (XSSFSheet) workbook.getSheetAt(2);
            XSSFSheet facultydata = (XSSFSheet) workbook.getSheetAt(3);
            XSSFSheet eventdata = (XSSFSheet) workbook.getSheetAt(4);



            switch (indexnum) {
                case 0:
                    subjectdata.createRow(subjects.indexOf(newSubject) + 1);//creates new row
                    Row subjectdatarow = subjectdata.getRow(subjects.indexOf(newSubject) + 1);
                    for (int cellcount = 0; cellcount <= 8; cellcount++) {
                        Cell subjectdatacell = subjectdatarow.createCell(cellcount);
                        if (cellcount == 0) {
                            subjectdatacell.setCellValue(newSubject.subjectCode);
                        }
                        if (cellcount == 1) {
                            subjectdatacell.setCellValue(newSubject.subjectName);
                        }
                    }
                    break;
                case 1:
                    coursedata.createRow(courses.indexOf(newCourse) + 1);//creates new row
                    Row coursedatarow = coursedata.getRow(courses.indexOf(newCourse) + 1);
                    for (int cellcount = 0; cellcount <= 8; cellcount++) {
                        Cell coursedatacell = coursedatarow.createCell(cellcount);
                        if (cellcount == 0) {
                            coursedatacell.setCellValue(newCourse.courseCode);
                        }
                        if (cellcount == 1) {
                            coursedatacell.setCellValue(newCourse.courseName);
                        }
                        if (cellcount == 2) {
                            coursedatacell.setCellValue(newCourse.sectionNumber);
                        }
                        if (cellcount == 3) {
                            coursedatacell.setCellValue(newCourse.subjectCode);
                        }
                        if (cellcount == 4) {
                            coursedatacell.setCellValue(newCourse.capacity);
                        }
                        if (cellcount == 5) {
                            coursedatacell.setCellValue(newCourse.lectureTime);
                        }
                        if (cellcount == 6) {
                            coursedatacell.setCellValue(newCourse.finalExamDateTime);
                        }
                        if (cellcount == 7) {
                            coursedatacell.setCellValue(newCourse.location);
                        }
                        if (cellcount == 8) {
                            coursedatacell.setCellValue(newCourse.teacherName);
                        }
                    }


                    break;
                case 2:

                    break;
                case 3:
                    facultydata.createRow(faculties.indexOf(newFaculty) + 1);
                    Row facultydatarow = facultydata.getRow(faculties.indexOf(newFaculty) + 1);
                    for (int cellcount = 0; cellcount <= 8; cellcount++) {
                        Cell facultydataCell = facultydatarow.createCell(cellcount);
                        if (cellcount == 0) {
                            facultydataCell.setCellValue(newFaculty.facultyID);
                        }
                        if (cellcount == 1) {
                            facultydataCell.setCellValue(newFaculty.name);
                        }
                        if (cellcount == 2) {
                            facultydataCell.setCellValue(newFaculty.degree);
                        }
                        if (cellcount == 3) {
                            facultydataCell.setCellValue(newFaculty.researchInterest);
                        }
                        if (cellcount == 4) {
                            facultydataCell.setCellValue(newFaculty.email);
                        }
                        if (cellcount == 5) {
                            facultydataCell.setCellValue(newFaculty.officeLocation);
                        }
                        if (cellcount == 6) {
                            facultydataCell.setCellValue(newFaculty.coursesOffered);
                        }
                        if (cellcount == 7) {
                            facultydataCell.setCellValue(newFaculty.password);
                        }
                        if (cellcount == 8) {
                            facultydataCell.setCellValue(newFaculty.role);
                        }
                    }
                    break;
                case 4:
                    eventdata.createRow(events.indexOf(newEvent) + 1);
                    Row eventdatarow = eventdata.getRow(events.indexOf(newEvent) + 1);
                    for (int cellcount = 0; cellcount <= 8; cellcount++) {
                        Cell eventdatacell = eventdatarow.createCell(cellcount);
                        switch(cellcount) {
                            case 0: eventdatacell.setCellValue(newEvent.eventCode); break;
                            case 1: eventdatacell.setCellValue(newEvent.eventName); break;
                            case 2: eventdatacell.setCellValue(newEvent.description); break;
                            case 3: eventdatacell.setCellValue(newEvent.location); break;
                            case 4: eventdatacell.setCellValue(newEvent.dateAndTime); break;
                            case 5: eventdatacell.setCellValue(newEvent.capacity); break;
                            case 6: eventdatacell.setCellValue(newEvent.cost); break;
                            case 7: eventdatacell.setCellValue(newEvent.headerImage); break;
                            case 8: eventdatacell.setCellValue(newEvent.registeredStudents); break;
                        }
                    }
                    break;
            }


//System.out.println(courses);

            try {
                FileOutputStream out = new FileOutputStream(new File("src/main/resources/UMS_Data.xlsx"));
                workbook.write(out);// Writing the workbook
                out.close();// Closing file output connections
                System.out.println("src/main/resources/UMS_Data.xlsx written successfully on disk.");// Console message for successful execution of the program
            }
            // Catch block to handle exceptions
            catch (Exception e) {// Display exceptions along with line number
                e.printStackTrace();// using printStackTrace() method
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    };

    public static void removeData(int indexnum,int selectedIndex,int totalrows) {
        try (FileInputStream file = new FileInputStream(new File("src/main/resources/UMS_Data.xlsx").getAbsolutePath());// Reading the workbook
             Workbook workbook = new XSSFWorkbook(file)) {//creates a work book from the xlsx
            XSSFSheet subjectdata = (XSSFSheet) workbook.getSheetAt(0);
            XSSFSheet coursedata = (XSSFSheet) workbook.getSheetAt(1);
            XSSFSheet studentdata = (XSSFSheet) workbook.getSheetAt(2);
            XSSFSheet facultydata = (XSSFSheet) workbook.getSheetAt(3);
            XSSFSheet eventdata = (XSSFSheet) workbook.getSheetAt(4);
            switch (indexnum) {
                case 0:
                    Row subjectdatarow = subjectdata.getRow(totalrows);
                    subjectdata.removeRow(subjectdatarow);
                    for(Row rowiter : subjectdata){
                        int cellcounter = 0;

                        for(Cell celliter: rowiter){
                            //System.out.println("row" + facultyrowiter.getRowNum());
                            if(rowiter.getRowNum() < totalrows) {
                                if(rowiter.getRowNum() > 0) {
                                    //System.out.println(faculties.get(facultyrowiter.getRowNum()-1));
                                    Subject selectedsubject = subjects.get(rowiter.getRowNum()-1);
                                    //System.out.println(selectedsubject);

                                    switch(cellcounter) {
                                        case 0:celliter.setCellValue(selectedsubject.subjectCode);
                                            break;
                                        case 1:celliter.setCellValue(selectedsubject.subjectName);
                                            break;

                                    }
                                    cellcounter++;     }     }

                            //System.out.println("cell:" + cellcounter);


                        }


                    }
                    break;
                case 1:
                    Row coursedatarow = coursedata.getRow(totalrows);
                    coursedata.removeRow(coursedatarow);
                    for(Row rowiter : coursedata){
                        int cellcounter = 0;

                        for(Cell celliter: rowiter){
                            //System.out.println("row" + facultyrowiter.getRowNum());
                            if(rowiter.getRowNum() < totalrows) {
                                if(rowiter.getRowNum() > 0) {
                                    //System.out.println(faculties.get(facultyrowiter.getRowNum()-1));
                                    Course selectedcourse = courses.get(rowiter.getRowNum()-1);
                                    //System.out.println(selectedcourse);

                                    switch(cellcounter) {
                                        case 0:celliter.setCellValue(selectedcourse.courseCode);
                                            break;
                                        case 1:celliter.setCellValue(selectedcourse.courseName);
                                            break;
                                        case 2:celliter.setCellValue(selectedcourse.sectionNumber);
                                            break;
                                        case 3:celliter.setCellValue(selectedcourse.subjectCode);
                                            break;
                                        case 4:celliter.setCellValue(selectedcourse.capacity);
                                            break;
                                        case 5:celliter.setCellValue(selectedcourse.lectureTime);
                                            break;
                                        case 6:celliter.setCellValue(selectedcourse.finalExamDateTime);
                                            break;
                                        case 7:celliter.setCellValue(selectedcourse.location);
                                            break;
                                        case 8:celliter.setCellValue(selectedcourse.teacherName);
                                            break;
                                    }
                                    cellcounter++;     }     }

                            //System.out.println("cell:" + cellcounter);


                        }


                    }

                    break;
                case 2:

                    break;
                case 3:
                    Row facultydatarow = facultydata.getRow(totalrows);
                    facultydata.removeRow(facultydatarow);
                    for(Row facultyrowiter : facultydata){
                      int cellcounter = 0;

                        for(Cell facultycelliter: facultyrowiter){
                            //System.out.println("row" + facultyrowiter.getRowNum());
                            if(facultyrowiter.getRowNum() < totalrows) {
                                if(facultyrowiter.getRowNum() > 0) {
                                    //System.out.println(faculties.get(facultyrowiter.getRowNum()-1));
                                    Faculty selectedfaculty = faculties.get(facultyrowiter.getRowNum()-1);
                                    System.out.println(selectedfaculty);

switch(cellcounter) {
    case 0:facultycelliter.setCellValue(selectedfaculty.facultyID);
        break;
    case 1:facultycelliter.setCellValue(selectedfaculty.name);
        break;
    case 2:facultycelliter.setCellValue(selectedfaculty.degree);
        break;
    case 3:facultycelliter.setCellValue(selectedfaculty.researchInterest);
        break;
    case 4:facultycelliter.setCellValue(selectedfaculty.email);
        break;
    case 5:facultycelliter.setCellValue(selectedfaculty.officeLocation);
        break;
    case 6:facultycelliter.setCellValue(selectedfaculty.coursesOffered);
        break;
    case 7:facultycelliter.setCellValue(selectedfaculty.password);
        break;
    case 8:facultycelliter.setCellValue(selectedfaculty.role);
        break;
}
                                    cellcounter++;     }     }

                       //System.out.println("cell:" + cellcounter);


                  }


                  }
                    break;
                case 4:

                    break;
            }



            try {
                FileOutputStream out = new FileOutputStream(new File("src/main/resources/UMS_Data.xlsx"));
                workbook.write(out);// Writing the workbook
                out.close();// Closing file output connections
                System.out.println("src/main/resources/UMS_Data.xlsx written successfully on disk.");// Console message for successful execution of the program
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void editData(Course selectedCourse, Subject selectedSubject, Student selectedStudent, Faculty selectedFaculty, Event selectedEvent, int indexnum, int selectedIndex) {
        try (FileInputStream file = new FileInputStream(new File("src/main/resources/UMS_Data.xlsx").getAbsolutePath());// Reading the workbook
        Workbook workbook = new XSSFWorkbook(file)) {//creates a work book from the xlsx
            XSSFSheet subjectdata = (XSSFSheet) workbook.getSheetAt(0);
            XSSFSheet coursedata = (XSSFSheet) workbook.getSheetAt(1);
            XSSFSheet studentdata = (XSSFSheet) workbook.getSheetAt(2);
            XSSFSheet facultydata = (XSSFSheet) workbook.getSheetAt(3);
            XSSFSheet eventdata = (XSSFSheet) workbook.getSheetAt(4);
            switch (indexnum) {
                case 0:
                    Row subjectdataRow = subjectdata.getRow(subjects.indexOf(selectedSubject) + 1);
                    for (int cellcount = 0; cellcount <= 8; cellcount++) {
                        Cell subjectdatacell = subjectdataRow.getCell(cellcount);
                        if (cellcount == 0) {
                            subjectdatacell.setCellValue(selectedSubject.subjectCode);
                        }
                        if (cellcount == 1) {
                            subjectdatacell.setCellValue(selectedSubject.subjectName);
                        }
                    }

                    break;
                case 1:

                    Row coursedataRow = coursedata.getRow(courses.indexOf(selectedCourse) + 1);
                    for (int cellcount = 0; cellcount <= 8; cellcount++) {
                        Cell coursedatacell = coursedataRow.getCell(cellcount);
                        if (cellcount == 0) {
                            coursedatacell.setCellValue(selectedCourse.courseCode);
                        }
                        if (cellcount == 1) {
                            coursedatacell.setCellValue(selectedCourse.courseName);
                        }
                        if (cellcount == 2) {
                            coursedatacell.setCellValue(selectedCourse.sectionNumber);
                        }
                        if (cellcount == 3) {
                            coursedatacell.setCellValue(selectedCourse.subjectCode);
                        }
                        if (cellcount == 4) {
                            coursedatacell.setCellValue(selectedCourse.capacity);
                        }
                        if (cellcount == 5) {
                            coursedatacell.setCellValue(selectedCourse.lectureTime);
                        }
                        if (cellcount == 6) {
                            coursedatacell.setCellValue(selectedCourse.finalExamDateTime);
                        }
                        if (cellcount == 7) {
                            coursedatacell.setCellValue(selectedCourse.location);
                        }
                        if (cellcount == 8) {
                            coursedatacell.setCellValue(selectedCourse.teacherName);
                        }
                    }


                    break;
                case 2:

                    break;
                case 3:
                    Row facultydatarow = facultydata.getRow(faculties.indexOf(selectedFaculty) + 1);
                    for (int cellcount = 0; cellcount <= 8; cellcount++) {
                        Cell facultydataCell = facultydatarow.getCell(cellcount);
                        if (cellcount == 0) {
                            facultydataCell.setCellValue(selectedFaculty.facultyID);
                        }
                        if (cellcount == 1) {
                            facultydataCell.setCellValue(selectedFaculty.name);
                        }
                        if (cellcount == 2) {
                            facultydataCell.setCellValue(selectedFaculty.degree);
                        }
                        if (cellcount == 3) {
                            facultydataCell.setCellValue(selectedFaculty.researchInterest);
                        }
                        if (cellcount == 4) {
                            facultydataCell.setCellValue(selectedFaculty.email);
                        }
                        if (cellcount == 5) {
                            facultydataCell.setCellValue(selectedFaculty.officeLocation);
                        }
                        if (cellcount == 6) {
                            facultydataCell.setCellValue(selectedFaculty.coursesOffered);
                        }
                        if (cellcount == 7) {
                            facultydataCell.setCellValue(selectedFaculty.password);
                        }
                        if (cellcount == 8) {
                            facultydataCell.setCellValue(selectedFaculty.role);
                        }}
                    break;
                case 4:

                    break;
            }
            try {
                FileOutputStream out = new FileOutputStream(new File("src/main/resources/UMS_Data.xlsx"));
                workbook.write(out);// Writing the workbook
                out.close();// Closing file output connections
                System.out.println("src/main/resources/UMS_Data.xlsx written successfully on disk.");// Console message for successful execution of the program
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void serializeStudents() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("students.ser"))) {
            out.writeObject(students);
            System.out.println("Students successfully serialized to students.ser");
        } catch (IOException e) {
            System.err.println("Error serializing students: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean deserializeStudents() {
        File file = new File("students.ser");
        if (!file.exists()) {
            System.out.println("Serialized students file not found");
            return false;
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            List<Student> loadedStudents = (List<Student>) in.readObject();
            students = loadedStudents;
            System.out.println("Successfully loaded " + students.size() + " students from serialized file");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing students: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }



}
