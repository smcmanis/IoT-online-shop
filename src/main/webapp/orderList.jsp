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
        <title>Orders</title>
    </head>

    <%@include file="common/navbar.jsp" %>

    <body>
        <div class="container">
            <h5 class="mb-3">
                <b>Customer: </b>${customer.firstName} ${customer.lastName}
            </h5>
            <a href="/addOrder" role="button" class="btn btn-primary">Start new order</a>
        </div>
        <div class="container">
            <h4>Orders (${customerOrders.size()})</h4>

            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Total</th>
                    <th>Order Status</th>
                    <th></th>
                </tr>
                <c:forEach items="${customerOrders}" var="order"> 
                    <tr class="align-middle">
                        <td>${order.id}</td>
                        <td>${order.orderDate}</td>
                        <td>$${order.cart.totalPrice}</td>
                        <td>${order.orderStatus}</td>
                        <td>
                            <div class="">
                                <c:url value="/order?orderId=${order.id}" var="orderUrl"/>
                                <a href="${orderUrl}">View Order</a>
                            </div>
                            <div>
                                <c:url value="/track/order?orderId=${order.id}" var="trackingUrl"/>
                                <a href="${trackingUrl}">Track order</a>
                            </div>
                            <c:if test="${!order.paid}">
                                <div>
                                    <c:url value="/order/edit?orderId=${order.id}" var="editUrl"/>
                                    <a href="${editUrl}">Continue order</a>
                                </div>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
