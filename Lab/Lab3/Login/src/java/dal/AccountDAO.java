/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author admin
 */
public class AccountDAO {

    Connection connection;

    public AccountDAO() {
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Account";
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccount(String username, String password) {
        Account account = null;
        String sql = """
                     SELECT [username]
                           ,[password]
                       FROM [Account].[dbo].[account]""";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String dbUsername = rs.getNString("username");
                String dbPassword = rs.getNString("password");
                if (username.equals(dbUsername) && password.equals(dbPassword)) {
                    account = new Account(dbUsername, dbPassword);
                }
            }
        } catch (SQLException e) {

        }
        return account;
    }
}
