package backend;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dell
 */
import java.io.*;
import java.util.*;

public class Database {

    private ArrayList<Student> students;

    public Database() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    // Load students from file
    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int studentID = Integer.parseInt(parts[0].trim());
                    String fullName = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String gender = parts[3].trim();
                    String department = parts[4].trim();
                    double gpa = Double.parseDouble(parts[5].trim());

                    Student s = new Student(studentID, fullName, age, gender, department, gpa);
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                bw.write(s.lineRepresenation()); // Use existing method
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // 4. Delete Student
    public void deleteStudent(int studentID) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == studentID) {
                students.remove(i);
                break;
            }
            // TODO: Find and remove student by ID
            // TODO: Show confirmation before deletion

        }
    }
    // 5. Search Student

    public ArrayList<Student> searchStudent(String keyword) {

        ArrayList<Student> results = new ArrayList<>();

        for (Student student : students) {
            if (String.valueOf(student.getStudentID()).equals(keyword)) {
                results.add(student);
            }
        }
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(keyword)) {
                results.add(student);
            }
        }

        return results;
    }

    public void update(int studentID, String Name, int age, String gender, String department, double gpa) {
        Student s = null;
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                s = student;
                break;
            }
        }
        if (s != null) {
            s.setFullName(Name);
            s.setAge(age);
            s.setDepartment(department);
            s.setGpa(gpa);
            s.setGender(gender);
        }
    }
}
