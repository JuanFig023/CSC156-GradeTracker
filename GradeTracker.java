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


        // print a welcome message when the program starts
        // then we could run a while loop that keeps showing the menu until the user exits
        // inside the loop we could use if/else to call the right method based on what the user picks
    }

    // Possible work breakdown
    // Juan: create method that prints the menu options for the user to choose from

    // Juan: create method that asks the user for a name, id, and grades, then creates a Student and adds it to the list

    // Juan: create the method that prints out every student currently in the list

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
    // Myat: create the method that goes through all students and prints the overall class average

    // Myat: create the method that finds the student with the highest average and prints their info

}