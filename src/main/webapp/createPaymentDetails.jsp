<%-- 
    Document   : CreatePaymentDetails
    Created on : 27 Apr 2021, 4:26:45 pm
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
         <title>Add Card</title>
    </head>

    <%@include file="common/navbar.jsp" %>

    <body>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form method="post" action="CreditCardServlet" >
                        <h2>New Card</h2>
                        <div class="form-group">
                            <label>Card Number</label>
                            <input type="text" 
                                   name="card-number" 
                                   class="form-control"  
                                   required>
                        </div>

                        <div class="form-group">
                            <label>Expiration month</label> 
                            <input type="text"
                                   name="expiration-month" 
                                   class="form-control" 
                                   required>
                        </div>

                        <div class="form-group">
                            <label>Expiration Year</label> 
                            <input type="text"  
                                   name="expiration-year" 
                                   class="form-control" 
                                   required>
                        </div>

                        <div class="form-group">
                            <label>Card Owner</label> 
                            <input type="text"
                                   name="card-owner" 
                                   class="form-control"
                                   required>
                        </div>
                        
                        <div class="form-group">
                            <label>CCV</label> 
                            <input type="text" 
                                   name="card-verification-value" 
                                   class="form-control" 
                                   required>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-success btn-block btn-lg">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>