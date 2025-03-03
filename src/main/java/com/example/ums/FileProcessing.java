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
}

class Subject {
    String code;
    String name;

    public Subject(String code, String name) {
        this.code = code;
        this.name = name;
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
}

class processFile {
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

    public static List<Subject> parseSubjects(String filePath) throws IOException {
        List<Subject> subjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    subjects.add(new Subject(values[0], values[1]));
                }
            }
        }
        return subjects;
    }

    public static List<Course> parseCourses(String filePath) throws IOException {
        List<Course> courses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 9) {
                    courses.add(new Course(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]));
                }
            }
        }
        return courses;
    }

    public static List<Event> parseEvents(String filePath) throws IOException {
        List<Event> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 9) {
                    events.add(new Event(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]));
                }
            }
        }
        return events;
    }
}

public class FileProcessing {
    public static void main(String[] args) {
        try {
            List<Faculty> faculties = processFile.parseFaculties("faculty.csv");
            List<Student> students = processFile.parseStudents("students.csv");
            List<Course> courses = processFile.parseCourses("faculty.csv");
            List<Event> events = processFile.parseEvents("students.csv");
            List<Subject> subjects = processFile.parseSubjects("faculty.csv");

            // Print parsed data
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
