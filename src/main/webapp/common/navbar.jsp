<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" 
              href="<c:url value="/resources/css/navbar.css"/>">
    </head>
    <body>
        <header class="header">
            <nav class="navbar bg-light navbar-expand-lg navbar-light">
                <div class="container-fluid">
                    <a class="navbar-brand d-flex align-items-center " href="/IoTBay/Main">
                        <img src="resources/images/page/logo.png" alt="" class="logo">
                        IOT BAY
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto">
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
                            <c:if test="${user != null}">

                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        My account
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                        <li>
                                            <a class="dropdown-item" href="/IoTBay/customer/order/list">My Orders</a>
                                        </li>
                                        <li><a class="dropdown-item" href="/IoTBay/editAccount.jsp">My Details</a></li>
                                        <li><a class="dropdown-item" href="/IoTBay/customer/creditCards">My Payment Details</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <li class="nav-item">
                                <a class="nav-link" href="/IoTBay/cart">
                                    Cart
                                    <c:if test="${cart != null && cart.getCartItems().size() > 0}">
                                        <span class="badge bg-danger">${cart.getCartItems().size()}</span>
                                    </c:if>
                                </a>
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