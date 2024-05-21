<%-- 
    Document   : login
    Created on : May 21, 2024, 7:42:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "model.Account" %>
<html>
    <head>
        <title>Login Status</title>
    </head>
    <body>
        <% Account account = (Account) request.getAttribute("account"); %>
        <% if (account != null) { %>
        <p>Successful</p>
        <% } else { %>
        <p>Fail</p>
        <% } %>
    </body>
</html>
