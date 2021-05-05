<%-- 
    Document   : cart
    Created on : 4 May 2021, 2:13:24 pm
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
        <title>Cart</title>
    </head>
    <body>

        <%@include file="common/navbar.jsp" %>

        <div class="container">
            <div>
                <h2>Cart (${cart.cartItems.size()} items)</h1>
            </div>
            <table class="table">
                <tr>
                    <th></th>
                    <th>Item</th>
                    <th>Qty</th>
                    <th>Price</th>
                    <th>Subtotal</th>
                    <th></th>
                </tr>
                <c:forEach items="${cart.cartItems}" var="cartItem">
                    <tr class="align-middle">
                        <td>
                            <img 
                                src="${cartItem.item.imageUrl}"
                                class=""
                                width="150" height="150">
                        </td>
                        <td>${cartItem.item.name}</td>
                        <td>${cartItem.quantity}</<td>
                        <td>$${cartItem.price}</td>
                        <td>$${cartItem.subtotal}</td>
                        <td>
                            <div class="input-group">
                                <div class="input-group-prepend d-flex">
                                    <c:url value="/cartItem?cartItemId=${cartItem.id}&action=remove" var="removeCartItemUrl"></c:url>
                                    <a href="${removeCartItemUrl}">
                                        X
                                    </a>
                                    
                                </div>

                            </div>

                        </td>
                    </tr>
                </c:forEach>


            </table>
            <div class="card">
                <div class="card-body">
                    <h4 class="mb-3">Order total</h4>
                    <ul class="list-group">
                        <!--Cart total-->
                        <li class="list-group-item d-flex justify-content-between 
                            align-items-center border-0 pb-0">
                            Cart total
                            <span>${cart.totalPrice}</span>
                        </li>
                        <!--Shipping Fee etc.-->
                        <li class="list-group-item d-flex justify-content-between 
                            align-items-center border-0 border-bottom">
                            Shipping Fee
                            <span>-</span>
                        </li>
                        <!--Order total-->
                        <li class="list-group-item d-flex justify-content-between 
                            align-items-center mb-3 border-0">
                            Order total (inc. GST)
                            <span>$${cart.totalPrice}</span>
                        </li>
                    </ul>
                    <button class="btn btn-primary">Checkout</button>
                </div>
            </div>
            <div>
                <c:url value="/getAllProducts" var="catalogueUrl"></c:url>
                <a href="${catalogueUrl}" class="btn btn-primary">
                    Continue Shopping
                </a>
            </div>
        </div>
    </body>
</html>

