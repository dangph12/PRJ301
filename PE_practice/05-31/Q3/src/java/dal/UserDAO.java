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
public class UserDAO {
    public ResultSet queryUser(String userid, String password) throws SQLException {
        Connection conn = DBContext.getInstance().getConnection();
        String query = "Select * from Account where userid = ? and password = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, userid);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public UserDAO() {
    }
    
}
