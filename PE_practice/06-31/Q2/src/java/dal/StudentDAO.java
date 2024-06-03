/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;

/**
 *
 * @author admin
 */
public class StudentDAO {

    public ResultSet queryAllStudent() throws SQLException {
        Connection conn = DBContext.getInstance().getConnection();
        String query = "Select * from Student";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public ResultSet queryStudentByName(String name) throws SQLException {
        Connection conn = DBContext.getInstance().getConnection();
        String query = " Select * from Student where name like '%".concat(name).concat("%'");
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return rs;
    }
}
