/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Student {

    private int sid;

    /**
     * Get the value of sid
     *
     * @return the value of sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * Set the value of sid
     *
     * @param sid new value of sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    private boolean gender;

    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    private Date dob;

    /**
     * Get the value of dob
     *
     * @return the value of dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Set the value of dob
     *
     * @param dob new value of dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Student() {
    }

    public Student(int sid, String name, boolean gender, Date dob) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
}
