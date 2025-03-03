package com.example.ums;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

class Faculty {
    String facultyID, name, degree, researchInterest, email, officeLocation, coursesOffered, password;

    public Faculty(String facultyID, String name, String degree, String researchInterest, String email, String officeLocation, String coursesOffered, String password) {
        this.facultyID = facultyID;
        this.name = name;
        this.degree = degree;
        this.researchInterest = researchInterest;
        this.email = email;
        this.officeLocation = officeLocation;
        this.coursesOffered = coursesOffered;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Faculty[ID=%s, Name=%s, Degree=%s, Research Interest=%s, Email=%s, Office=%s, Courses Offered=%s]",
                facultyID, name, degree, researchInterest, email, officeLocation, coursesOffered);
    }
}


class Student {
    String id, name, address, telephone, email, academicLevel, currentSemester, profilePhoto, subjectsRegistered, thesisTitle, progress, password;

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
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%s Name=%s, Address=%s, Telephone=%s, Email=%s, Academic Level=%s, Current Semester=%s, Profile Photo=%s, Subjects Registered=%s, Thesis Title=%s, Progress=%s]",
                id, name, address, telephone, email, academicLevel, currentSemester, profilePhoto, subjectsRegistered, thesisTitle, progress);
    }
}


class Course {
    String courseName, subjectCode, sectionNumber, capacity, lectureTime, finalExamDateTime, location, teacherName;

    public Course(String courseName, String subjectCode, String sectionNumber, String capacity, String lectureTime, String finalExamDateTime, String location, String teacherName) {
        this.courseName = courseName;
        this.subjectCode = subjectCode;
        this.sectionNumber = sectionNumber;
        this.capacity = capacity;
        this.lectureTime = lectureTime;
        this.finalExamDateTime = finalExamDateTime;
        this.location = location;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return String.format("Course[Name=%s, Subject Code=%s, Section=%s, Capacity=%s, Lecture Time=%s, Final Exam=%s, Location=%s, Teacher=%s]",
                courseName, subjectCode, sectionNumber, capacity, lectureTime, finalExamDateTime, location, teacherName);
    }
}


class Event {
    String eventCode, eventName, description, location, dateAndTime, capacity, cost, headerImage, registeredStudents;

    public Event(String eventCode, String eventName, String description, String location, String dateAndTime, String capacity, String cost, String headerImage, String registeredStudents) {
        this.eventCode = eventCode;
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
        return String.format("Subject[Code=%s, Name=%s]", subjectCode, subjectName);
    }
}



class processFile {
    public static List<Faculty> parseFaculties(Sheet sheet) {
        List<Faculty> faculties = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            List<String> values = getRowValues(row, 8);
            if (values.stream().allMatch(String::isEmpty)) continue;

            faculties.add(new Faculty(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7)));
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

            courses.add(new Course(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7)));
        }
        return courses;
    }

    public static List<Event> parseEvents(Sheet sheet) {
        List<Event> events = new ArrayList<>();
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;

            List<String> values = getRowValues(row, 9);
            if (values.stream().allMatch(String::isEmpty)) continue;

            events.add(new Event(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7), values.get(8)));
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
}
