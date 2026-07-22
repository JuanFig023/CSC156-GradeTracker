// main class that runs the program
// it would show a menu and let the user manage a list of students

import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    //a ArrayList to hold all our Student objects
    private static ArrayList<Student> students = new ArrayList<>();
    // a Scanner to read input from the user
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     Welcome to the Grade Tracker");
        System.out.println("========================================");

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                displayAllStudents();
            } else if (choice == 3) {
                searchStudent(students, input);
            } else if (choice == 4) {
                removeStudent(students, input);
            } else if (choice == 5) {
                displayClassAverage();
            } else if (choice == 6) {
                displayTopStudent();
            } else if (choice == 7) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }

    // Juan: prints the menu options for the user to choose from
    public static void displayMenu() {

        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by Name");
        System.out.println("4. Remove Student by ID");
        System.out.println("5. View Class Average");
        System.out.println("6. View Top Student");
        System.out.println("7. Exit");
    }

    // Juan: asks the user for a name, id, and grades, then creates a Student and adds it to the list
    public static void addStudent() {

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student ID: ");
        int studentID = input.nextInt();
        input.nextLine();

        System.out.print("Enter number of grades: ");
        int numGrades = input.nextInt();

        double[] grades = new double[numGrades];

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = input.nextDouble();
        }

        input.nextLine();

        Student newStudent = new Student(name, studentID, grades);
        students.add(newStudent);

        System.out.println("Student added successfully.");
    }

    // Juan: prints out every student currently in the list
    public static void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students on record.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Nick: create the method that asks for a name and searches the list for any student that matches
    public static void searchStudent(ArrayList<Student> students, Scanner input) {

        System.out.print("Enter student name to search: ");
        String searchName = input.nextLine();

        boolean found = false;

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Student found:");
                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    // Nick: create the method that asks for an id and removes that student from the list
    public static void removeStudent(ArrayList<Student> students, Scanner input) {

        System.out.print("Enter student ID to remove: ");
        int removeID = input.nextInt();

        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentID() == removeID) {

                students.remove(i);

                System.out.println("Student removed successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("No student found with that ID.");
        }
    }
    
    // Myat: goes through all students and prints the overall class average
    public static double displayClassAverage() {

        if (students.isEmpty()) {
            System.out.println("No students on record.");
            return 0;
        }

        double total = 0;

        for (Student student : students) {
            total += student.calculateAverage();
        }

        double classAverage = total / students.size();
        System.out.printf("Class Average: %.2f%n", classAverage);
        return classAverage;
    }

    // Myat: finds the student with the highest average and prints their info
    public static void displayTopStudent() {

        if (students.isEmpty()) {
            System.out.println("No students on record.");
            return;
        }

        Student top = students.get(0);

        for (int i = 1; i < students.size(); i++) {

            if (students.get(i).calculateAverage() > top.calculateAverage()) {
                top = students.get(i);
            }
        }

        System.out.println("Top Student:");
        top.displayStudent();
    }
}