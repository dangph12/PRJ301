<%-- 
    Document   : discuss
    Created on : Jun 3, 2024, 3:55:08 PM
    Author     : admin
--%>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="threadList" items="${threadList}">
            <form action="comment" method="POST">
                Thread: ${threadList.tcontext}
                <br>
                <c:forEach var="comment" items="${threadList.comments}">
                    ${comment.displayName}: ${comment.ctext}
                    <br>
                </c:forEach>
                <input type="text" name="comment" value="" />
                <input type="hidden" name="tid" value="${threadList.tid}"/>
                <input type="submit" value="Save" />
                <br>
            </form>
        </c:forEach>
    </body>
</html>
