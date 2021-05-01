<%-- 
    Document   : order
    Created on : 27 Apr 2021, 7:40:02 pm
    Author     : simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/resources/css/style.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" 
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" 
              crossorigin="anonymous">
        <title>Orders</title>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Total</th>
                    <th>Order Status</th>
                    <th></th>
                </tr>
                <c:forEach items="${orders}" var="order"> 
                    <tr class="align-middle">
                        <td>${order.id}</td>
                        <td>${order.orderDate}</td>
                        <td>$${order.totalPrice}</td>
                        <td>${order.orderStatus}</td>
                        <td>
                            <div class="">
                                <c:url value="/order?orderId=${order.id}" var="orderUrl"/>
                                <a href="${orderUrl}">View Order</a>
                            </div>
                            <div>
                                <c:url value="/track/order-${order.id}" var="trackingUrl"/>
                                <a href="${trackingUrl}">Track order</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
