<%-- 
    Document   : editPaymentDetails
    Created on : 16 May 2021, 5:15:03 am
    Author     : josephmant
--%>
<%@page import="com.iotbay.shop.model.CreditCard"%>
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
        <title>Edit Customer Card</title>
    </head>

    <%@include file="common/navbar.jsp" %>

    <%
        CreditCard creditCard = (CreditCard) session.getAttribute("CreditCard");
        String updated = (String) session.getAttribute("updated");
    %>
    <body>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form method="post" action="/IoTBay/UpdateCreditCardServlet">
                        <h2>Edit Card Information<span class="message"><%=(updated != null ? updated : "")%></span></h2>

                        <div class="form-group">
                            <label>Card Number</label>
                            <input type="text"
                                   placeholder="Card Number"
                                   name="card-number"
                                   value="${creditCard.getCardNumber()}"
                                   class="form-control form-control-m2em"
                                   required autofocus>
                        </div>

                        <div class="form-group">
                            <label>Expiration month</label> 
                            <input type="text"
                                   placeholder="Expiration Month"
                                   name="expiration-month"
                                   value="${creditCard.getExpirationMonth()}"
                                   class="form-control" 
                                   required autofocus>
                        </div>

                        <div class="form-group">
                            <label>Expiration Year</label> 
                            <input type="text"
                                   placeholder="Expiration Year"
                                   name="expiration-year"
                                   value="${creditCard.getExpirationYear()}"
                                   class="form-control" 
                                   required autofocus>
                        </div>

                        <div class="form-group">
                            <label>Card Owner</label> 
                            <input type="text"
                                   placeholder="Card Owner"
                                   name="card-owner" 
                                   value="${creditCard.getCardOwner()}"
                                   class="form-control"
                                   required autofocus>
                        </div>

                        <div class="form-group">
                            <label>CCV</label> 
                            <input type="text" 
                                   placeholder="Card Verification Value"
                                   name="card-verification-value"
                                   value="${creditCard.getCardVerificationValue()}"
                                   class="form-control" 
                                   required autofocus>
                        </div>
                        <br>
                        <input type="submit" value="Update" class="btn btn-success btn-block btn-lg"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>