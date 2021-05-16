
<%-- 
    Document   : adminhome
    Created on : 30/04/2021, 2:32:51 PM
    Author     : trees
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet"
              href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
        <script src="<c:url value="/resources/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/css/style.css"/>">
        <title>Admin Home</title>
    </head>
    <body>
        <header class="header">
            <nav class="navbar bg-light navbar-expand-lg navbar-light">
                <a class="navbar-brand" href="#">
                    <img  width="30" height="30" class="d-inline-block align-top" alt="">
                    IOT BAY
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="productadd.jsp">Add New Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Manage Orders</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Manage Users</a>
                        </li>
                       
                    </ul>
                </div>
            </nav>
        </header>
        <h1>Hello Admin!</h1>
    </body>
</html>