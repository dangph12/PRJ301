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
        <form action="update" method="POST">
            <table border="0">
                    <tr>
                        <td>
                            <input type="text" name="username" value="${ndata.tensudung}" readonly/>
                        </td>
                        <td>
                            <input type="password" name="password" value="${ndata.matkhau}" />
                        </td>
                        <td>
                            <input type="text" name="code" value="${ndata.masinhvien}" />
                        </td>
                        <td>
                            <input type="text" name="class" value="${ndata.lop}" />
                        </td>
                    </tr>   
            </table>
            <input type="submit" value="Update" />
        </form>
    </body>
</html>
