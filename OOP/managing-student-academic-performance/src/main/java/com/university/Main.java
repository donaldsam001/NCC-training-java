package com.university;

import com.university.entity.Faculty;
import com.university.entity.InServiceStudent;
import com.university.entity.RegularStudent;
import com.university.entity.Student;
import com.university.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StudentService SERVICE = new StudentService();

    public static void main(String[] args) {
        List<Faculty> faculties = new ArrayList<>();
        System.out.println("===== STUDENT ACADEMIC PERFORMANCE MANAGEMENT =====");

        while (true) {
            printMenu();
            int choice = readInt("Your choice: ");

            try {
                switch (choice) {
                    case 1:
                        createFaculty(faculties);
                        break;
                    case 2:
                        addStudent(faculties, true);
                        break;
                    case 3:
                        addStudent(faculties, false);
                        break;
                    case 4:
                        selectFaculty(faculties).displayStudents();
                        break;
                    case 5:
                        runFacultyReports(selectFaculty(faculties));
                        break;
                    case 6:
                        findGpaBySemester(selectFaculty(faculties));
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid menu option.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=============== MAIN MENU ===============");
        System.out.println("1. Create faculty");
        System.out.println("2. Add regular student");
        System.out.println("3. Add in-service student");
        System.out.println("4. Display students in a faculty");
        System.out.println("5. Faculty reports (all required statistics)");
        System.out.println("6. Find a student's GPA by semester");
        System.out.println("0. Exit");
        System.out.println("=========================================");
    }

    private static void createFaculty(List<Faculty> faculties) {
        String name = readNonBlank("Faculty name: ");
        boolean exists = faculties.stream()
                .anyMatch(f -> f.getFacultyName().equalsIgnoreCase(name));
        if (exists) {
            throw new IllegalArgumentException("Faculty already exists.");
        }
        faculties.add(new Faculty(name, new ArrayList<>()));
        System.out.println("Faculty created successfully.");
    }

    private static void addStudent(List<Faculty> faculties, boolean regular) {
        Faculty faculty = selectFaculty(faculties);
        Student student = regular ? new RegularStudent() : new InServiceStudent();
        student.input(SCANNER);
        faculty.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static Faculty selectFaculty(List<Faculty> faculties) {
        if (faculties.isEmpty()) {
            throw new IllegalArgumentException("Please create a faculty first.");
        }

        System.out.println("\nAvailable faculties:");
        for (int i = 0; i < faculties.size(); i++) {
            System.out.printf("%d. %s%n", i + 1,
                    faculties.get(i).getFacultyName());
        }

        int index = readInt("Select faculty: ") - 1;
        if (index < 0 || index >= faculties.size()) {
            throw new IllegalArgumentException("Invalid faculty selection.");
        }
        return faculties.get(index);
    }

    private static void runFacultyReports(Faculty faculty) {
        System.out.println("\n===== REPORT: " + faculty.getFacultyName() + " =====");

        System.out.println("\n1. Number of regular students:");
        System.out.println(SERVICE.countRegularStudents(faculty));

        System.out.println("\n2. Student(s) with highest entrance score:");
        printStudents(SERVICE.findHighestEntranceScoreStudents(faculty));

        System.out.println("\n3. Search in-service students by training location:");
        String location = readNonBlank("Enter location (e.g. Dong Nai): ");
        List<InServiceStudent> inService =
                SERVICE.findInServiceStudentsByLocation(faculty, location);
        if (inService.isEmpty()) {
            System.out.println("No matching in-service students.");
        } else {
            inService.forEach(Student::output);
        }

        System.out.println("\n4. Students whose latest semester GPA >= 8.0:");
        printStudents(SERVICE.findStudentsWithLatestGpaAtLeast(faculty, 8.0));

        System.out.println("\n5. Student(s) with the highest GPA in any semester:");
        printStudents(SERVICE.findStudentsWithHighestSemesterGpa(faculty));

        System.out.println("\n6. Students sorted by type ascending, enrollment year descending:");
        printStudents(SERVICE.sortStudents(faculty));

        System.out.println("\n7. Number of students by enrollment year:");
        Map<Integer, Long> statistics = SERVICE.countByEnrollmentYear(faculty);
        if (statistics.isEmpty()) {
            System.out.println("No students.");
        } else {
            statistics.forEach((year, count) ->
                    System.out.println(year + ": " + count));
        }
    }

    private static void findGpaBySemester(Faculty faculty) {
        int studentCode = readInt("Student code: ");
        Student student = faculty.getStudents().stream()
                .filter(s -> s.getStudentCode() == studentCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found: " + studentCode));

        int semester = readInt("Semester: ");
        double gpa = student.getGpaBySemester(semester);
        System.out.printf("GPA of %s in semester %d: %.2f%n",
                student.getFullName(), semester, gpa);
    }

    private static void printStudents(List<? extends Student> students) {
        if (students.isEmpty()) {
            System.out.println("No matching students.");
            return;
        }
        for (Student student : students) {
            student.output();
        }
    }

    private static String readNonBlank(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = SCANNER.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}