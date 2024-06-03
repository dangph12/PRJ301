/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import model.Comment;

/**
 *
 * @author admin
 */
public class DiscussDAO {
    
    public void insertNewComment(String ctext, String userid, int tid) throws SQLException {
        Connection conn = DBContext.getInstance().getConnection();
        String query = "insert Comment values ((select count(*) from Comment) + 1,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, ctext);
        statement.setString(2, userid);
        statement.setInt(3, tid);
        statement.executeUpdate();
    }

    public ResultSet queryAllThread() throws SQLException {
        Connection conn = DBContext.getInstance().getConnection();
        String query = "Select * from Thread";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public ResultSet queryAllCommentEachThread(int tid) throws SQLException {
        Connection conn = DBContext.getInstance().getConnection();
        String query = """
                       Select a.displayname, c.ctext from Comment c
                       left join Account a on c.userid = a.userid
                       left join Thread t on c.tid = t.tid
                       where t.tid = ?""";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, tid);
        ResultSet rs = statement.executeQuery();
        return rs;
    }
    
    public static void main(String[] args) {
        int a = 20;
        Integer b = Integer.compare(a, a);
        if (a == b) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
