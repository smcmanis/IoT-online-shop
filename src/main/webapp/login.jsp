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
        <title>Login</title>
    </head>

    <body>

        <%@include file="common/navbar.jsp" %>

        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        %>

        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form class="form" method="post" action="login">
                         <h2>Sign In <span class="message"><%=(existErr != null ? existErr : "")%></span></h2>                        
                         <div class="form-group mb-3">
                            <input type="email" 
                                   class="form-control form-control-m2em"
                                   name="email" 
                                   placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>"                                    
                                   required>
                            </input>
                        </div>
                        <div class="form-group mb-3">
                            <input type="password"
                                   class="form-control form-control-m2em"
                                   name="password" 
                                    placeholder="<%=(passErr != null ? passErr : "Enter password")%>"                                   
                                    required>
                            </input>
                        </div>
                        <div class="form-group mb-3">
                            <button type="submit" class="btn btn-success btn-block btn-lg">
                                Sign In 
                            </button>
                        </div>
                    </form>
                    <div class="sign-in-actions">
                        <a href="">Forgot Password?</a>
                        <a href="register.jsp">Sign up</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
