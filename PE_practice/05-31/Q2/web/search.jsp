<%-- 
    Document   : newjsp
    Created on : Jun 2, 2024, 9:39:23 AM
    Author     : admin
--%>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>sid</th>
                    <th>name</th>
                    <th>gender</th>
                    <th>dob</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="studentList" items="${requestScope.studentListToDisplay}">
                    <tr>
                        <td>${studentList.sid}</td>
                        <td>${studentList.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${studentList.gender == true}">
                                    1
                                </c:when>
                                <c:otherwise>
                                    0
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${studentList.dob}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
