package com.example.ums;

import java.io.*;
import java.util.*;

class Faculty {
    String id;
    String name;
    String degree;
    String researchInterest;
    String email;
    String officeLocation;
    String coursesOffered;
    String password;

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
        return "Faculty{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", degree='" + degree + '\'' + ", researchInterest='" + researchInterest + '\'' + ", email='" + email + '\'' + ", officeLocation='" + officeLocation + '\'' + ", coursesOffered='" + coursesOffered + '\'' + ", password='" + password + '\'' + '}';
    }
}

class Student {
    String id;
    String name;
    String address;
    String telephone;
    String email;
    String academicLevel;
    String currentSemester;
    String profilePhoto;
    String subjectsRegistered;
    String thesisTitle;
    String progress;
    String password;

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
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", address='" + address + '\'' + ", telephone='" + telephone + '\'' + ", email='" + email + '\'' + ", academicLevel='" + academicLevel + '\'' + ", currentSemester='" + currentSemester + '\'' + ", profilePhoto='" + profilePhoto + '\'' + ", subjectsRegistered='" + subjectsRegistered + '\'' + ", thesisTitle='" + thesisTitle + '\'' + ", progress='" + progress + '\'' + ", password='" + password + '\'' + '}';
    }
}

class Subject {
    String code;
    String name;

    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
    }
}

class Course {
    String code;
    String name;
    String subjectCode;
    String sectionNumber;
    String capacity;
    String lectureTime;
    String finalExamDateTime;
    String location;
    String teacherName;

    public Course(String code, String name, String subjectCode, String sectionNumber, String capacity, String lectureTime, String finalExamDateTime, String location, String teacherName) {
        this.code = code;
        this.name = name;
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
        return "Course{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", subjectCode='" + subjectCode + '\'' + ", sectionNumber='" + sectionNumber + '\'' + ", capacity='" + capacity + '\'' + ", lectureTime='" + lectureTime + '\'' + ", finalExamDateTime='" + finalExamDateTime + '\'' + ", location='" + location + '\'' + ", teacherName='" + teacherName + '\'' + '}';
    }
}

class Event {
    String code;
    String name;
    String description;
    String location;
    String dateTime;
    String capacity;
    String cost;
    String headerImage;
    String registeredStudents;

    public Event(String code, String name, String description, String location, String dateTime, String capacity, String cost, String headerImage, String registeredStudents) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
        this.capacity = capacity;
        this.cost = cost;
        this.headerImage = headerImage;
        this.registeredStudents = registeredStudents;
    }

    @Override
    public String toString() {
        return "Event{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", description='" + description + '\'' + ", location='" + location + '\'' + ", dateTime='" + dateTime + '\'' + ", capacity='" + capacity + '\'' + ", cost='" + cost + '\'' + ", headerImage='" + headerImage + '\'' + ", registeredStudents='" + registeredStudents + '\'' + '}';
    }
}

public class FileProcessing {
    public static List<Faculty> parseFaculties(String filePath) throws IOException {
        List<Faculty> faculties = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    faculties.add(new Faculty(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]));
                }
            }
        }
        return faculties;
    }

    public static List<Student> parseStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 12) {
                    students.add(new Student(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11]));
                }
            }
        }
        return students;
    }

    public static void main(String[] args) {
        try {
            List<Faculty> faculties = parseFaculties("C:\\Users\\Brodin's Thinkpad\\IdeaProjects\\UMS\\src\\main\\java\\com\\example\\ums\\Faculties.csv");
            List<Student> students = parseStudents("C:\\Users\\Brodin's Thinkpad\\IdeaProjects\\UMS\\src\\main\\java\\com\\example\\ums\\Students.csv");

            System.out.println("Faculties:");
            faculties.forEach(System.out::println);

            System.out.println("\nStudents:");
            students.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}
