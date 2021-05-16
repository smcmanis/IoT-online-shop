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
        <title>Admin Login</title>
    </head>

    <body>




        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form class="form" method="post" action="/IoTBay/admin/login">
                         <h2>Admin Login </h2>                        
                         <div class="form-group mb-3">
                            <input type="email" 
                                   class="form-control"
                                   name="email" 
                                   placeholder="Admin email"                                    
                                   required>
                            </input>
                        </div>
                        <div class="form-group mb-3">
                            <input type="password"
                                   class="form-control "
                                   name="password" 
                                    placeholder="Admin password"                                   
                                    required>
                            </input>
                        </div>
                        <div class="form-group mb-3">
                            <button type="submit" class="btn btn-primary btn-block btn-lg">
                                Sign In 
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>
