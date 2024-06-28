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
public class SubjectDAO {

    public ResultSet queryStudentsBySubject(String subjectName) throws SQLException {
        DBContext dBContext = new DBContext();
        Connection connection = dBContext.connection;
                String query = """
                       SELECT [StudentID]
                             ,[StudentName]
                             ,[BirthDate]
                             ,[Gender]
                       	  ,[SubjectName]
                         FROM [PE_Example].[dbo].[Students], [PE_Example].[dbo].[Subjects]
                         where [Students].SubjectID = [Subjects].SubjectID
                               and [Subjects].SubjectName = ?
                       """;
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, subjectName);
        return pstmt.executeQuery();
    }
    
    public ResultSet querySubjectsByName(String subjectName) throws SQLException {
        DBContext dBContext = new DBContext();
        Connection connection = dBContext.connection;
        String query = """
                       SELECT [SubjectID]
                             ,[SubjectName]
                         FROM [PE_Example].[dbo].[Subjects]
                         where [Subjects].SubjectName = ?
                       """;
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, subjectName);
        return pstmt.executeQuery();        
    }
    
    
    public ResultSet queryAllSubjects() throws SQLException {
        DBContext dBContext = new DBContext();
        Connection connection = dBContext.connection;
        String query = """
                       SELECT [SubjectID]
                             ,[SubjectName]
                         FROM [PE_Example].[dbo].[Subjects]
                       """;
        PreparedStatement pstmt = connection.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public ResultSet queryAllStudents() throws SQLException {
        DBContext dBContext = new DBContext();
        Connection connection = dBContext.connection;
        String query = """
                       SELECT [StudentID]
                             ,[StudentName]
                             ,[BirthDate]
                             ,[Gender]
                       	  ,[SubjectName]
                         FROM [PE_Example].[dbo].[Students], [PE_Example].[dbo].[Subjects]
                         where [Students].SubjectID = [Subjects].SubjectID
                       """;
        PreparedStatement pstmt = connection.prepareStatement(query);
        return pstmt.executeQuery();
    }
        public ResultSet queryStudentByID(String studentID) throws SQLException {
        DBContext dBContext = new DBContext();
        Connection connection = dBContext.connection;
        String query = """
                       SELECT [StudentID]
                             ,[StudentName]
                             ,[BirthDate]
                             ,[Gender]
                         FROM [PE_Example].[dbo].[Students]
                         where [Students].StudentID = ?
                       """;
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, studentID);
        return pstmt.executeQuery();
    }
    

}
