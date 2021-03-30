<%-- 
    Document   : welcome
    Created on : 30/03/2021, 2:14:09 PM
    Author     : hlong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String password = request.getParameter("password");
            
        %>
        <h1>Welcome <%= name %></h1>
        <div>
            <p>Your email is: <%= email %></p>
            <p>Your password is: <%= password %></p>
            <p>Your dob is: <%= dob %></p>
            
        </div>
        <a class="button" href="main">Main</a>
    </body>
</html>
