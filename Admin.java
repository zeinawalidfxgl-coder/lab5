/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Eman
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Admin {

    private ArrayList<Student> students;

    // Constructor
    public Admin() {
        students = new ArrayList<>();
    }

    // 1. Add Student
    public void addStudent(Student student) {
        // TODO: Validate input (no empty fields, valid age, numeric GPA)
        // TODO: Add student to the list
        // TODO: Display confirmation message
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.print("Do you want the Students to be sorted?");
        System.out.print("1)Yes \t 2)No");
        System.out.print("Enter your choice: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (choice.equals("2")) {
            for (Student student : students) {
                System.out.println(student);
            }
        } else if (choice.equals("1")) {
            System.out.print("1)by name \t 2)by ID");
            System.out.print("Enter your choice: ");
            String sortBy = input.nextLine();
            if (sortBy.equals("1")) {
                Collections.sort(students, Comparator.comparing(Student::getFullName));
                System.out.println("Students sorted by name:");
            } else if (sortBy.equals("2")) {
                Collections.sort(students, Comparator.comparingInt(Student::getStudentID));
                System.out.println("Students sorted by ID:");
            } else {
                System.out.println("Invalid sort option. Showing unsorted list:");
            }
            System.out.println("ID\tName\tAge\tGender\tDepartment\tGPA");
            for (Student student : students) {
                System.out.println(student);
            }
            // TODO: Display all students (e.g., print to console or show in table)
            // TODO: Optional: Allow sorting by name or ID
        } else {
            System.out.print("Invalide Choice");
        }
    }
    // 3. Update Student

    public void updateStudent(int studentID, Student updatedStudent) {
        // TODO: Find student by ID
        // TODO: Update details
        // TODO: Save changes
    }

    // 4. Delete Student
    public void deleteStudent(int studentID) {
        for (int i = 0; i < students.size(); i++) {
            System.out.print("Are you sure you want to delete the user with the id" + studentID + "? (Y/N): ");
            Scanner input=new Scanner(System.in);
            String confirmation = input.nextLine();
             if (students.get(i).getStudentID() == studentID){
            if (confirmation.equalsIgnoreCase("Y"))  {
                students.remove(i);
                i--;
                System.out.println("Student with ID " + studentID + " has been deleted.");
            }
            else{
                System.out.println("Deletion cancelled.");
                return;
            }
                // TODO: Find and remove student by ID
                // TODO: Show confirmation before deletion
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }
        // 5. Search Student
    public ArrayList<Student> searchStudent(String keyword) {
        

    System.out.println("Search student by:");
    System.out.println("1) ID");
    System.out.println("2) Name");
    System.out.print("Enter your choice: ");
    Scanner input = new Scanner(System.in);
    String choice = input.nextLine();
    ArrayList<Student> results = new ArrayList<>();

    if (choice.equals("1")) {
        System.out.print("Enter student ID to search: ");
        
        String id = input.nextLine();
        for (Student student : students) {
            if (String.valueOf(student.getStudentID()).equals(id)) {
                results.add(student);
            }
        }
    } else if (choice.equals("2")) {
        System.out.print("Enter student name to search: ");
        String nameKeyword = input.nextLine().toLowerCase();
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(nameKeyword)) {
                results.add(student);
            }
        }
    } else {
        System.out.println("Invalid choice.");
        return null;
    }

    if (results.isEmpty()) {
        System.out.println("No students found.");
    } else {
        System.out.println("Search results:");
        System.out.println("ID\tName\tAge\tGender\tDepartment\tGPA");
        for (Student student : results) {
            System.out.println(student);
        }
    }
        // TODO: Search by name or ID
        // TODO: Return list of matching students
        return new ArrayList<>();
    }
}
