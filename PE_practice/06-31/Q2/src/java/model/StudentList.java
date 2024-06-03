/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.StudentDAO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class StudentList {

    private ArrayList<Student> studentList;

    public ArrayList<Student> getAllStudentFromDatabase() {
        try {
            StudentDAO studentDAO = new StudentDAO();
            ResultSet rs = studentDAO.queryAllStudent();
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                Date dob = rs.getDate("dob");
                Student student = new Student(sid, name, gender, dob);
                studentList.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentList;
    }

    public ArrayList<Student> getStudentByNameFromDatabase(String name) {
        try {
            StudentDAO studentDAO = new StudentDAO();
            ResultSet rs = studentDAO.queryStudentByName(name);
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String studentName = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                Date dob = rs.getDate("dob");
                Student student = new Student(sid, studentName, gender, dob);
                studentList.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentList;
    }

    /**
     * Get the value of studentList
     *
     * @return the value of studentList
     */
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    /**
     * Set the value of studentList
     *
     * @param studentList new value of studentList
     */
    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentList() {
        try {
            studentList = new ArrayList<>();
        } catch (Exception e) {
        }
    }
}
