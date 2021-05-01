<%-- 
    Document   : order.jsp
    Created on : 1 May 2021, 2:27:04 pm
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
        <title>Order</title>
    </head>
    <body>
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
