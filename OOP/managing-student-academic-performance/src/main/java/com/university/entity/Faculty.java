package com.university.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Faculty {
    private String facultyName;
    private List<Student> students;

    public Faculty() {
        this("Unknown", new ArrayList<>());
    }

    public Faculty(String facultyName, List<Student> students) {
        setFacultyName(facultyName);
        setStudents(students);
    }

    public Faculty(Faculty other) {
        if (other == null) {
            throw new IllegalArgumentException("Faculty cannot be null.");
        }
        this.facultyName = other.facultyName;
        setStudents(other.students);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }

        boolean duplicated = students.stream()
                .anyMatch(existing ->
                        existing.getStudentCode() == student.getStudentCode());

        if (duplicated) {
            throw new IllegalArgumentException(
                    "Student code already exists in this faculty.");
        }
        students.add(student.copy());
    }

    public long countRegularStudents() {
        return students.stream()
                .filter(Student::isRegular)
                .count();
    }

    public List<Student> findStudentsWithHighestEntranceScore() {
        if (students.isEmpty()) {
            return new ArrayList<>();
        }

        double maxScore = students.stream()
                .mapToDouble(Student::getInputScore)
                .max()
                .orElseThrow();

        return students.stream()
                .filter(student ->
                        Double.compare(student.getInputScore(), maxScore) == 0)
                .map(Student::copy)
                .collect(Collectors.toList());
    }

    public List<InServiceStudent> findInServiceStudentsByLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be empty.");
        }

        return students.stream()
                .filter(student -> student instanceof InServiceStudent)
                .map(student -> (InServiceStudent) student)
                .filter(student -> student.getTrainingPartnershipLocation()
                        .equalsIgnoreCase(location.trim()))
                .map(student -> (InServiceStudent) student.copy())
                .collect(Collectors.toList());
    }

    public List<Student> findStudentsWithLatestGpaAtLeast(double threshold) {
        if (!Double.isFinite(threshold) || threshold < 0 || threshold > 10) {
            throw new IllegalArgumentException("Threshold must be between 0 and 10.");
        }

        return students.stream()
                .filter(student -> !student.getAcademicResults().isEmpty())
                .filter(student -> {
                    List<AcademicResult> results = student.getAcademicResults();
                    return results.get(results.size() - 1).getGpa() >= threshold;
                })
                .map(Student::copy)
                .collect(Collectors.toList());
    }

    public List<Student> findStudentsWithHighestSemesterGpa() {
        double maxGpa = students.stream()
                .flatMap(student -> student.getAcademicResults().stream())
                .mapToDouble(AcademicResult::getGpa)
                .max()
                .orElse(-1.0);

        if (maxGpa < 0) {
            return new ArrayList<>();
        }

        return students.stream()
                .filter(student -> student.getAcademicResults().stream()
                        .anyMatch(result ->
                                Double.compare(result.getGpa(), maxGpa) == 0))
                .map(Student::copy)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByTypeThenEnrollmentYear() {
        Comparator<Student> comparator = Comparator
                .comparingInt((Student student) ->
                        student.isRegular() ? 0 : 1)
                .thenComparing(
                        Comparator.comparingInt(Student::getStudentYear).reversed())
                .thenComparing(Student::getFullName,
                        String.CASE_INSENSITIVE_ORDER);

        return students.stream()
                .sorted(comparator)
                .map(Student::copy)
                .collect(Collectors.toList());
    }

    public Map<Integer, Long> countStudentsByEnrollmentYear() {
        Map<Integer, Long> statistics = new TreeMap<>();
        for (Student student : students) {
            statistics.merge(student.getStudentYear(), 1L, Long::sum);
        }
        return statistics;
    }

    public List<Student> getStudents() {
        return students.stream()
                .map(Student::copy)
                .collect(Collectors.toList());
    }

    public void displayStudents() {
        System.out.println("\nFaculty: " + facultyName);
        if (students.isEmpty()) {
            System.out.println("No students in this faculty.");
            return;
        }
        for (Student student : students) {
            student.output();
        }
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        if (facultyName == null || facultyName.isBlank()) {
            throw new IllegalArgumentException("Faculty name cannot be empty.");
        }
        this.facultyName = facultyName.trim();
    }

    public void setStudents(List<Student> students) {
        this.students = new ArrayList<>();
        if (students == null) {
            return;
        }

        for (Student student : students) {
            if (student == null) {
                throw new IllegalArgumentException("Student cannot be null.");
            }
            this.students.add(student.copy());
        }
    }
}