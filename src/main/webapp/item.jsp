<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet"
              href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
        <script src="<c:url value="/resources/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/css/style.css"/>">
        <title>{item.name} </title>
    </head>

    <body>
        <%@include file="common/navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col product">

                    <h1>${item.name}</h1>
                    <img src="${item.imageUrl}"/>
                    <h3>Price: $ ${item.price}</h3>
                    <h3>Stock: ${item.quantity}</h3>
                    <a href="/IoTBay/addCartItem?itemId=${item.id}&quantity=1" class="btn btn-primary">Add to Cart</a>
                    <a href="/IoTBay/catalogue" class="btn btn-primary">Back to Catalogue</a>


                </div>
            </div>
        </div>





        <footer class=footer>
        </footer>


    </body>
</html>