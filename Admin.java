package backend;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dell
 */
import java.util.ArrayList;

public class Admin {

    private Database database;

    // Constructor
    public Admin() {
        database = new Database();
        database.loadFromFile();
    }

    // 1. Add Student
    public void addStudent(Student student) {
        // TODO: Validate input (no empty fields, valid age, numeric GPA)
        // TODO: Add student to the list
        // TODO: Display confirmation message
        database.addStudent(student);
        database.saveToFile();
    }

    public ArrayList<Student> viewStudents() {
        return database.getStudents();
    }

    public void deleteStudent(int studentID) {
        database.deleteStudent(studentID);
        database.saveToFile();
    }

    // 3. Update Student
    public ArrayList<Student> searchStudent(String keyword) {
        return database.searchStudent(keyword);
    }

    public void updateStudent(int studentID, String Name, int age, String gender, String department, double gpa) {
        database.update(studentID, Name, age, gender, department, gpa);
        database.saveToFile();
    }
}
