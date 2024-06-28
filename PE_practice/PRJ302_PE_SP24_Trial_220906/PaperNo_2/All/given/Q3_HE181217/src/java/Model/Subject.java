/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.SubjectDAO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author admin
 */
public class Subject {

    private String subjectID;
    private String subjectName;
    private ArrayList<Student> students;

    public ArrayList<Subject> getAllSubjectsWithStudents() {
        SubjectDAO subjectDAO = new SubjectDAO();
        Student student = new Student();
        ArrayList<Subject> allSubjects = new ArrayList<>();
        try {
            ResultSet allSubjectsResultSet = subjectDAO.queryAllSubjects();
            while (allSubjectsResultSet.next()) {
                String subjectID = allSubjectsResultSet.getString("SubjectID");
                String subjectName = allSubjectsResultSet.getString("SubjectName");
                ArrayList<Student> students = student.getStudentsBySubject(subjectName);
                Subject subject = new Subject(subjectID, subjectName, students);
                allSubjects.add(subject);
            }
        } catch (SQLException e) {
        }
        return allSubjects;
    }

    public Subject() {
    }

    public Subject(String subjectID, String subjectName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Subject(String subjectID, String subjectName, ArrayList<Student> students) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.students = students;
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        //Subject selectedSubject = subject.getSubjectByName("Connecting to CS");
    }
}
