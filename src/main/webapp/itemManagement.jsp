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
        <title>Item Management</title>
    </head>
    <body>
        <%@include file="common/navbar.jsp" %>

        <c:if test="${noAccess}">
            <h2 class="text-center"> You do not have permission to access this page. Please login with admin privileges. </h2>
            <a class="btn btn-primary" href="/IoTBay/admin" role="button">Go to Admin Login</a>
        </c:if>
        <br>
        <c:if test="${!noAccess}">
            <div class="container" >
                <h3 class="text-center" >Item List</h3>
                <hr>
                <div class="container text-right" >
                    <a href="/IoTBay/addItem.jsp" class="btn btn-primary">Add New Item</a>
                </div>
                <br>
                <table class="table table-bordered" >
                    <thead>
                        <tr>
                            <th>Item ID</th>
                            <th>Item Name</th>
                            <th>Item Price</th>
                            <th>Item Quantity</th>
                            <th>Item Category</th>
                            <th>Manage</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${itemList}" var="item">
                            <tr class="align-middle" >
                                <td>${item.id}</td>
                                <td>${item.name}</td>
                                <td>${item.price}</td>
                                <td>${item.quantity}</td>
                                <td>${item.category}</td>
                                <td>
                                    <div>
                                        <a href="/IoTBay/editItem?itemId=${item.id}">Edit Item </a>
                                    </div>
                                    <div>
                                        <a href="/IoTBay/deleteItem?itemId=${item.id}" >Delete Item</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>