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
        <title>Order</title>
    </head>
    <body>

        <%@include file="common/navbar.jsp" %>

        <div class="container">
            <div>
                <h1>Order #${order.id}</h1>
            </div>
            <div>
                <p>
                    <b>Customer: </b>${order.user.firstName} ${order.user.lastName}
                </p>
            </div>
            <div>
                <p>
                    <b>Order Date: </b>${order.orderDate}
                </p>
            </div>
            <div>
                <p>
                    <b>Order Status: </b>${order.orderStatus}
                </p>
            </div>

            <h3>Order Items</h3>
            <table class="table">
                <tr>
                    <th></th>
                    <th>Item</th>
                    <th>Quantity</th>
                    <th>Item Price</th>
                    <th>Subtotal</th>
                    <th></th>
                </tr>
                <c:forEach items="${order.cart.cartItems}" var="cartItem">
                    <tr class="align-middle">
                        <td>
                            <img 
                                src="resources/images/${cartItem.item.imageUrl}"
                                class=""
                                width="150" height="150">
                        </td>
                        <td>${cartItem.item.name}</td>
                        <td>${cartItem.quantity}</td>
                        <td>$${cartItem.price}</td>
                        <td>$${cartItem.subtotal}</td>
                    </tr>
                </c:forEach>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <div>
                        <b>Order Total:</b>
                    </div>
                </td>
                <td>
                    <div>
                        $${order.totalPrice}
                    </div>

                </td>

            </table>
        </div>
    </body>
</html>
