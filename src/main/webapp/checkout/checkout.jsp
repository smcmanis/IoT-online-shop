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

        <title>Order - Checkout</title>
    </head>

    <body>
        <%@include file="/common/navbar.jsp" %>

        <div class="container">
<form class="form" method="post" action="/IoTBay/ProcessOrderServlet">
            <div class="row">

                <!--Shipping details-->
                <div class="col-sm">
                    
                        <h2>Contact Details </h2>                  
                        <div class="form-group mb-3">
                            <input type="text" 
                                   class="form-control"
                                   id="name"
                                   name="name" 
                                   placeholder="Name"                                    
                                   required>
                            </input>
                        </div>
                        <div class="form-group mb-3">
                            <input type="email" 
                                   class="form-control"
                                   name="email" 
                                   placeholder=""                                    
                                   >
                            </input>
                        </div>
<!--                    </form>-->
                </div>

                <!--Payment details-->
                <div class="col-sm">
                    <!--<form class="form">-->
                        <h2>Payment</h2>                  
                        <div class="form-group mb-3">
                            <input type="email" 
                                   class="form-control"
                                   name="email" 
                                   placeholder=""                                    
                                   >
                            </input>
                        </div>
                        <div class="form-group mb-3">
                            <input type="email" 
                                   class="form-control"
                                   name="email" 
                                   placeholder=""                                    
                                   >
                            </input>
                        </div>
<!--                    </form>-->
                </div>

                <!--Order summary-->
                <div class="col-sm">
                    <div class="card card-body">
                        <h4 class="mb-3">Order total</h4>
                        <!--Items-->
                        <div>
                            <table class="table">
                                <c:forEach items="${cart.cartItems}" var="cartItem">
                                    <tr class="align-middle">
                                        <td>${cartItem.item.name}</td>
                                        <td>${cartItem.quantity}</td>
                                        <td>$${cartItem.subtotal}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <ul class="list-group">
                            <!--Cart total-->
                            <li class="list-group-item d-flex justify-content-between 
                                align-items-center border-0 pb-0">
                                ${cart.cartItems.size()} items
                                <span>$${cart.totalPrice}</span>
                            </li>
                            <!--Shipping Fee etc.-->
                            <li class="list-group-item d-flex justify-content-between 
                                align-items-center border-0 border-bottom">
                                Shipping Fee
                                <span>FREE</span>
                            </li>
                            <!--Order total-->
                            <li class="list-group-item d-flex justify-content-between 
                                align-items-center mb-3 border-0">
                                Order total (inc. GST)
                                <span>$${cart.totalPrice}</span>
                            </li>
                        </ul>
                        <div class="d-grid gap-2">
                            <button 
                                class="btn btn-success" type="submit">
                                Place Your Order
                            </button>

                        </div> 

                    </div>
                </div>
                                         </form>
       
            </div>

        </div
    </body>

</html>
