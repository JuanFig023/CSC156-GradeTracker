// CSC156 - Java Computer Science 1
// Members: Juan Figueroa, Myat Min Htoo, Nicholas Korsak

// This class represents a single student.
// Each student has a name, student ID, and an array of grades.

public class Student {

    // Student information
    private String name;
    private int studentID;
    private double[] grades;

    // Constructor
    public Student(String name, int studentID, double[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public double[] getGrades() {
        return grades;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    // Calculates and returns the student's average grade
    public double calculateAverage() {

        if (grades == null || grades.length == 0) {
            return 0;
        }

        double total = 0;

        for (int i = 0; i < grades.length; i++) {
            total += grades[i];
        }

        return total / grades.length;
    }

    // Finds the highest grade of a student
    public double getHighestGrade() {

        if (grades == null || grades.length == 0) {
            return 0;
        }

        double highest = grades[0];

        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }

        return highest;
    }

    // Finds the lowest grade of a student
    public double getLowestGrade() {
        if (grades == null || grades.length == 0) {
            return 0;
        }

        double lowest = grades[0];

        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }

        return lowest;
    }

    // Determines the student's letter grade
    public String getLetterGrade() {

        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Display GPA grade point from the alphabetical GPA
    public double getGPA() {

        String letter = getLetterGrade();

        switch (letter) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case  "D":
                return 1.0;
            default:
                return 0.0;
        }
    }


    // Displays all student information
    public void displayStudent() {

        System.out.println("----------------------------");
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentID);

        System.out.print("Grades: ");

        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i]);

            if (i < grades.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.printf("Average: %.2f%n", calculateAverage());
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println("GPA: " + getGPA());
        System.out.println("Highest Grade: " +  getHighestGrade());
        System.out.println("Lowest Grade: " +  getLowestGrade());
        System.out.println("----------------------------");
    }
}