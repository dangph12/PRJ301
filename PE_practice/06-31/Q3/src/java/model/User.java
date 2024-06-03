/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.UserDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class User {

    public User getUser(String userid, String password) {
        User user = null;
        try {
            UserDAO userDAO = new UserDAO();
            ResultSet rs = userDAO.queryUser(userid, password);
            if (rs.next()) {
                user = new User(rs.getString("userid"), rs.getString("password"), rs.getString("displayname"));
            }
        } catch (SQLException e) {
        }
        return user;
    }

    private String userid;

    /**
     * Get the value of userid
     *
     * @return the value of userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Set the value of userid
     *
     * @param userid new value of userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private String displayName;

    /**
     * Get the value of displayName
     *
     * @return the value of displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the value of displayName
     *
     * @param displayName new value of displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public User(String userid, String password, String displayName) {
        this.userid = userid;
        this.password = password;
        this.displayName = displayName;
    }

    public User() {
    }

}
