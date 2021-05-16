<%-- 
    Document   : ViewPaymentDetails
    Created on : 27 Apr 2021, 4:25:35 pm
    Author     : josephmant
--%>
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
        <title>Customer Cards</title>
    </head>

    <%@include file="common/navbar.jsp" %>

    <body>
        <br>
        <div class="container">
            <h3 class="text-center">List of Cards</h3>
            <hr>
            <div class="container text-left">

                <a href="/IoTBay/createPaymentDetails.jsp" class="btn btn-success">Add New Card</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Card Number</th>
                        <th>Expiration Month</th>
                        <th>Expiration Year</th>
                        <th>Card Owner</th>
                        <th>CCV</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!--   for (Todo todo: todos) {  -->
                    <c:forEach items="${userCreditCards}" var="creditCard"> 
                        <tr class="align-middle">
                            <td>${creditCard.cardNumber}</td>
                            <td>${creditCard.expirationMonth}</td>
                            <td>${creditCard.expirationYear}</td>
                            <td>${creditCard.cardOwner}</td>
                            <td>${creditCard.cardVerificationValue}</td>
                            <td>
                                <a href="/IoTBay/editAccount?creditCardNumber=${creditCard.cardNumber}" class="btn btn-success mb-3">Edit</a>
                                <a class="btn btn-success btn-block" href="/IoTBay/deleteCreditCard?creditCardId=${creditCard.id}">Delete</a>                     
                            </td>

                        </tr>
                    </c:forEach>
                    <!-- } -->
                </tbody>

            </table>
            <br>
            <div>
                <h3 class="text-center">Transactions</h3>
                <hr>
            </div>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Card Number</th>
                        <th>Payment Total</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${userPayments}" var="payment"> 
                        <tr class="align-middle">
                            <td>${payment.id}</td>
                            <td>${payment.cardNumber}</td>
                            <td>${payment.paymentAmount}</td>
                            <td>${payment.date}</td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>

    </body>

</html>