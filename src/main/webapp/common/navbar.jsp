<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <body>
        <header class="header">
            <nav class="navbar bg-light navbar-expand-lg navbar-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img  width="30" height="30" class="d-inline-block align-top" alt="">
                        IOT BAY
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="/IoTBay/main">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/IoTBay/catalogue">Catalogue</a>
                            </li>
                            <c:if test="${user == null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="login.jsp">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="register.jsp">Register</a>
                                </li>
                            </c:if>
                            <li class="nav-item">
                                <a class="nav-link" href="/IoTBay/cart">Cart</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/IoTBay/orderList">My Orders</a>
                            </li>
                            <c:if test="${user != null}">
                                <li class="nav-item">
                                    <a class="nav-link" href="/IoTBay/LogoutServlet">Logout</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    </body>
</html>