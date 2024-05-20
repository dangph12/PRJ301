/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.sql.*;
import dal.DBContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class PracticeWithDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBContext dbContext = new DBContext();
        Connection connection = dbContext.getConnection();

        // Display
        //show(connection);
        // Insert
        /*String sql = "insert Human values (7, 'Kais01','2020-07-08','False',1)";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PracticeWithDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Delete
        sql = "Delete From Human where humanname = 'Dang01'";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PracticeWithDatabase.class.getName()).log(Level.SEVERE, null, ex);

        }*/
        
        // Update
        String sql = "Update Human Set humanname = 'Dang01', humandob = '2004-05-13', humangender = 'False', typeid = 1 Where humanid = 6";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PracticeWithDatabase.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void show(Connection connection) {
        try {
            String sql = """
                         SELECT [humanid]
                               ,[humanname]
                               ,[humandob]
                               ,[humangender]
                               ,[typeid]
                           FROM [Human].[dbo].[Human]""";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("\"Human{\" + \"humanID=\" + humanID + \", humanName=\" + humanName + \", humanDob=\" + humanDob + \", humanGender=\" + humanGender + \", typeID=\" + typeID + '}'");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PracticeWithDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
