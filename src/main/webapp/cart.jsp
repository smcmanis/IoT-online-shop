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
                    <th></th>
                    <th class="text-center">Qty</th>
                    <th class="text-center">Price</th>
                    <th class="text-center">Subtotal</th>
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
                        <td>
                            <div class=" btn-group btn-group-sm">
                                <a href="/IoTBay/removeCartItem?cartItemId=${cartItem.id}&quantity=${cartItem.quantity - 1}" 
                                   role="button" 
                                   class="btn btn-light col">
                                    -
                                </a>
                                <div class="col-6 px-2 
                                     d-flex justify-content-around align-items-center">
                                    <div>${cartItem.quantity}</div>
                                </div>
                                <a href="/IoTBay/addCartItem?itemId=${cartItem.item.id}&quantity=1" 
                                   role="button" 
                                   class="col btn btn-light">
                                    +
                                </a>
                            </div>
                        </<td>
                        <td>$${cartItem.price}</td>
                        <td>$${cartItem.subtotal}</td>
                        <td>
                            <div class="input-group">
                                <div class="input-group-prepend d-flex">
                                    <a href="/IoTBay/removeCartItem?cartItemId=${cartItem.id}&quantity=0">
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
            <div class="d-flex justify-content-between">
                <div>
                    <c:url value="/catalogue" var="catalogueUrl"></c:url>
                    <a href="${catalogueUrl}" class="btn btn-primary">
                        Continue Shopping
                    </a>
                </div>
                <c:if test="${cart.cartItems != null && cart.cartItems.size() > 0}">
                    <div>
                        <a href="/IoTBay/removeCartItem?removeAll=true" class="btn btn-danger">
                            Empty cart
                        </a>
                    </div>
                </c:if>

            </div>
        </div>
    </body>
</html>

