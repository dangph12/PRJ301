/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.SubjectDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class Student {

    private String studentID;
    private String studentName;
    private Date birthDate;
    private boolean gender;
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    

    public Student(String studentID, String subjectName) {
        this.studentID = studentID;
        this.subjectName = subjectName;
    }

    public Student() {
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Student(String studentID, String studentName, Date birthDate, boolean gender, String subjectName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.subjectName = subjectName;
    }
    
    public ArrayList<Student> getStudentsBySubject(String subjectName) {
        SubjectDAO subjectDAO = new SubjectDAO();
        ArrayList<Student> students = new ArrayList<>();
        try {
            ResultSet studentsBySubject = subjectDAO.queryStudentsBySubject(subjectName);
            while (studentsBySubject.next()) {     
                String studentID = studentsBySubject.getString("StudentID");
                String studentName = studentsBySubject.getString("StudentName");
                Date birthDate = studentsBySubject.getDate("BirthDate");
                boolean gender = studentsBySubject.getBoolean("Gender");
                Student student = new Student(studentID, studentName, birthDate, gender, subjectName);
                students.add(student);
            }
        } catch (Exception e) {
        }
        return students;
    }
    
    public Student getStudentByID(String studentID) {
        SubjectDAO subjectDAO = new SubjectDAO();
        Student student = new Student();
        try {
            ResultSet studentByID = subjectDAO.queryStudentByID(studentID);
            while (studentByID.next()) {
                student.setStudentID(studentByID.getString("StudentID"));
            }
        } catch (SQLException e) {
        }
        return student;
    }

    public ArrayList<Student> getAllStudents() {
        SubjectDAO subjectDAO = new SubjectDAO();
        ArrayList<Student> allStudents = new ArrayList<>();
        try {
            ResultSet allStudentsResultSet = subjectDAO.queryAllStudents();
            while (allStudentsResultSet.next()) {
                String studentID = allStudentsResultSet.getString("StudentID");
                String studentName = allStudentsResultSet.getString("StudentName");
                Date birthDate = allStudentsResultSet.getDate("BirthDate");
                boolean gender = allStudentsResultSet.getBoolean("Gender");
                String subjectName = allStudentsResultSet.getString("SubjectName");
                Student student = new Student(studentID, studentName, birthDate, gender, subjectName);
                allStudents.add(student);
            }
        } catch (SQLException e) {
        }
        return allStudents;
    }
    
    
}
