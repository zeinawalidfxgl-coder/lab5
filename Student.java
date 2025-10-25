package backend;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class Student {
    private int studentID;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    // Constructor
    public Student(int studentID, String fullName, int age, String gender, String department, double gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }

    // Getters
    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    // Setters
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    //Line representation
    public String lineRepresenation() {
      return studentID + "," + fullName + "," + age + "," + gender + "," + department + "," + gpa;
  }
@Override
    public String toString() {
        return studentID + "\t" + fullName + "\t" + age + "\t" + gender + "\t" + department + "\t" + gpa ;
    }
 
    
}
