<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                <form action="search">
                    <input type="text" name="username" value="" />
                    <input type="submit" value="search" />
                </form>
                <tr>
                    <td>ten</td>
                    <td>mk</td>
                    <td>masv</td>
                    <td>lop</td>
                </tr>   
                <%int i = 1; %>
                <c:forEach items="${requestScope.ndata}" var="n">
                    <tr>
                        <td>
                            <span><%= i%></span>
                            ${n.tensudung}
                        </td>
                        <td>
                            ${n.matkhau}
                        </td>
                        <td>
                            ${n.masinhvien}
                        </td>
                        <td>
                            ${n.lop}
                        </td>
                        <td>
                            <a href="update?tensudung=${n.tensudung}">Update</a>
                        </td>
                        <td>
                            <a href="remove?tensudung=${n.tensudung}">Remove</a>
                        </td>
                    </tr>
                    <%i++;%>
                </c:forEach>       
            </table>
            <a href="add.jsp">Add</a>
        </div>
    </body>
</html>
