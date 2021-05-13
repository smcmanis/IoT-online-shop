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
        <a href="/IoTBay/addItem.jsp" class="btn btn-primary">Add Item</a>
        <h1 class="align-middle">Item List</h1>
        <div class="container">
            <table class="table">
                <tr>
                    <th>Item ID</th>
                    <th>Item Name</th>
                    <th>Item Price</th>
                    <th>Item Quantity</th>
                    <th>Item Category</th>
                </tr>
                <c:forEach items="${itemList}" var="item">
                    <tr class="align-middle" >
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.category}</td>
                        <td>
                            <div>
                                <c:url value="" var="editURL"/>
                                <a href="${editURL}">Edit Item </a>
                            </div>
                            <div>
                                <c:url value="" var="deleteURL"/>
                                <a href="${deleteURL}" >Delete Item</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>