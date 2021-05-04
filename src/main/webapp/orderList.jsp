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

    <%@include file="common/navbar.jsp" %>

    <body>
        <div class="container">
            <div class="container">
                <a class="btn btn-primary" href="/order/new" role="button">New Order</a>
            </div>
            <div class="container">
                <label for="orderIdList" class="form-label">Search Orders</label>
                <div class="row g-3">
                    <div class="col">
                        <input class="form-control" list="orderIdList" id="orderIdInput" placeholder="Id...">
                        <datalist id="orderIdList">
                            <c:forEach items="${userOrders}" var="order"> 
                                <option value="Order# ${order.id}">
                                </c:forEach>
                        </datalist>
                    </div>
                    <div class="col">
                        <button class="btn btn-primary">Search</button>
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col">
                        <input class="form-control" list="orderDateList" id="orderDateInput" placeholder="Date...">
                        <datalist id="orderDateList">
                            <c:forEach items="${userOrders}" var="order"> 
                                <option value="Date: ${order.orderDate}">
                                </c:forEach>
                        </datalist>
                    </div>
                    <div class="col">
                        <button class="btn btn-primary">Search</button>
                    </div>
                </div>
            </div>

            <table class="table">
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Total</th>
                    <th>Order Status</th>
                    <th></th>
                </tr>
                <c:forEach items="${userOrders}" var="order"> 
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
