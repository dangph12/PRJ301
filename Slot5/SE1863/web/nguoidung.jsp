<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int i = 1; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="box">
            <h2>Danh sách sinh viên</h2>
            <table border="0">
                <c:forEach items="${requestScope.ndata}" var="n">
                    <tr>
                        <td>
                            <span><%= i%></span>
                            ${n.tensudung}</td>
                    </tr>
                    <%i++;%>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
