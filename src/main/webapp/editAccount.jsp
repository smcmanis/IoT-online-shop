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
        <title>Edit Page</title>
    </head>
    <body>
        <%@include file="common/navbar.jsp" %>
        
        <%
            User user = (User) session.getAttribute("user");
            String updated = (String) session.getAttribute("updated");
        %>
        <div class="mt-3 mb-3"> 
            <a class="btn btn-lg btn-primary btn-block" href="/main.jsp?email='<%=user.getEmail()%>">Main</a>
            <a class="btn btn-lg btn-primary btn-block" href="LogoutServlet"> Sign out </a>
            <a class="btn btn-lg btn-danger btn-block pull-right" href="CancelAccountServlet"> Cancel Registration </a>
        </div>

        <h1>Edit User Information: <span class="message"><%=(updated != null ? updated : "")%></span></h1>
        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="POST" action="UpdateAccountServlet">
                        <h2>Edit Details</h2>
                        <div class="form-group mb-2">
                            <input type="text"
                                   placeholder="First Name"
                                   name="first-name"
                                   value="${user.getFirstName()}"
                                   class="form-control"
                                   required autofocus>

                        </div>
                        <div class="form-group mb-2">
                            <input type="text"
                                   placeholder="Last Name"
                                   name="last-name"
                                   value="${user.getLastName()}"
                                   class="form-control"
                                   required autofocus>

                        </div>
                        <div class="form-group mb-2">
                            <input type="email"
                                   placeholder="Email"
                                   name="email"
                                   value="${user.getEmail()}"
                                   class="form-control "
                                   required autofocus>
                            </input>
                        </div>
                        <div class="form-group mb-2">
                            <input type="password"
                                   placeholder="Password"
                                   name="password"
                                   value="${user.getPasswordPlaintext()}"
                                   class="form-control"
                                   required>

                        </div>
                        <div class="form-group">
                            <input type="submit" value="Update" class="btn btn-success btn-block btn-lg"/>
                                
                        </div>
                    </form>        
                </div>
            </div>
        </div>    
    </body>
</html>