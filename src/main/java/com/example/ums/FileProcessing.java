package com.example.ums;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

class Faculty {
    String id, name, degree, researchInterest, email, officeLocation, coursesOffered, password;

    public Faculty(String id, String name, String degree, String researchInterest, String email, String officeLocation, String coursesOffered, String password) {
        this.id = id;
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
        return String.format("Faculty[ID=%s, Name=%s, Degree=%s, Research=%s, Email=%s, Office=%s, Courses=%s]", id, name, degree, researchInterest, email, officeLocation, coursesOffered);
    }
}

class Student {
    String id, name, dob, email, phone, address, department, course, year, semester, gpa, password;

    public Student(String id, String name, String dob, String email, String phone, String address, String department, String course, String year, String semester, String gpa, String password) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.course = course;
        this.year = year;
        this.semester = semester;
        this.gpa = gpa;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%s, Name=%s, DOB=%s, Email=%s, Phone=%s, Address=%s, Dept=%s, Course=%s, Year=%s, Semester=%s, GPA=%s]", id, name, dob, email, phone, address, department, course, year, semester, gpa);
    }
}

class Course {
    String code, name, description, faculty, credits, schedule, prerequisites, department, semester;

    public Course(String code, String name, String description, String faculty, String credits, String schedule, String prerequisites, String department, String semester) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.faculty = faculty;
        this.credits = credits;
        this.schedule = schedule;
        this.prerequisites = prerequisites;
        this.department = department;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return String.format("Course[Code=%s, Name=%s, Faculty=%s, Credits=%s, Schedule=%s, Dept=%s, Semester=%s]", code, name, faculty, credits, schedule, department, semester);
    }
}

class Event {
    String id, name, date, time, location, description, organizer, participants, status;

    public Event(String id, String name, String date, String time, String location, String description, String organizer, String participants, String status) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.organizer = organizer;
        this.participants = participants;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Event[ID=%s, Name=%s, Date=%s, Time=%s, Location=%s, Organizer=%s, Status=%s]", id, name, date, time, location, organizer, status);
    }
}

class Subject {
    String code, name;

    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Subject[Code=%s, Name=%s]", code, name);
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
    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream(new File("src/main/resources/UMS_Data.xlsx").getAbsolutePath());
             Workbook workbook = new XSSFWorkbook(file)) {

            List<Faculty> faculties = processFile.parseFaculties(workbook.getSheetAt(3));
            List<Student> students = processFile.parseStudents(workbook.getSheetAt(2));
            List<Course> courses = processFile.parseCourses(workbook.getSheetAt(1));
            List<Event> events = processFile.parseEvents(workbook.getSheetAt(4));
            List<Subject> subjects = processFile.parseSubjects(workbook.getSheetAt(0));

            faculties.forEach(System.out::println);
            students.forEach(System.out::println);
            courses.forEach(System.out::println);
            events.forEach(System.out::println);
            subjects.forEach(System.out::println);

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
