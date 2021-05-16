<%@page import="com.iotbay.shop.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet"
              href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
        <script src="<c:url value="/resources/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/css/style.css"/>">
        <title>Welcome!</title>
    </head>

    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>

        <%@include file="common/navbar.jsp" %>

        <div class="container"> 
            <div class="center">
                <div class="form" method="post" >
                    <div>
                        <h1 class="mb-3">Welcome <% out.print(user.getFirstName()); %>!</h1>
                    </div>
                    <div> Name: <% out.print(user.getFirstName() + " " + user.getLastName()); %>!</div>
                    <div> Email: <% out.print(user.getEmail());%>!</div>

                    <div class="mt-3"> 
                         <a class="btn btn-lg btn-primary btn-block" href="editAccount.jsp">Account Settings</a>                        
                         <a class="btn btn-lg btn-primary btn-block" href="/IoTBay/catalogue"> Proceed to store </a>
                    </div>           
                </div>
            </div>
        </div>
    </body>
</html>
