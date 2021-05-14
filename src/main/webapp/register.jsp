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
        <title>Register</title>
    </head>

    <body>
        
        <%@include file="common/navbar.jsp" %>
        
        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="post" action="register">
                        <h2>Register</h2>
                        <div class="form-group mb-2">
                            <input type="text"
                                   placeholder="First Name"
                                   name="first-name"
                                   class="form-control form-control-m2em"
                                   required autofocus>
                            
                        </div>
                        <div class="form-group mb-2">
                            <input type="text"
                                   placeholder="Last Name"
                                   name="last-name"
                                   class="form-control form-control-m2em"
                                   required autofocus>
                            
                        </div>
                        <div class="form-group mb-2">
                            <input type="email"
                                   placeholder="Email"
                                   name="email"
                                   class="form-control form-control-m2em"
                                   required autofocus>
                            </input>
                        </div>
                        <div class="form-group mb-2">
                            <input type="password"
                                   placeholder="Password"
                                   name="password"
                                   class="form-control form-control-m2em"
                                   required>
                            
                        </div>
                        <div class="form-group mb-2">
                            <input type="password"
                                   placeholder="Confirm Password"
                                   name="confirm-password"
                                   class="form-control form-control-m2em"
                                   required>
                            
                        </div>
                        <div class="form-group mb-2">
                            <input type="submit" value="Sign Up" class="btn btn-success btn-block btn-lg">
                        </div>
                    </form>
                    <div>
                        Have an account?
                        <a href="login.jsp">Sign in</a>                            
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
