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

        <title>IoTBay Catalogue</title>
    </head>

    <body>
        <%@include file="common/navbar.jsp" %>

        <div class = "container" > 
            <div class="row">
                <div class="sidebar-header" style="background-color:#bbb;">
                    <h2>NAVIGATION</h2>
                    <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="Search.." title="Type in a category">
                    <ul id="myMenu">
                        <li><a href="/catalogue?itemCategory=Communications">Communications</a></li>
                        <li><a href="#">Converters</a></li>
                        <li><a href="#">Sensors</a></li>
                        <li><a href="#">Raspberry Pi</a></li>
                        <li><a href="#">Adapters</a></li>
                    </ul>
                </div>
                <h1 class="center"></h1>
                <h2>Products</h2> 

                <div class = "row row-cols-4 ">
                    <c:forEach items="${catalogue}" var="item" >
                        <%--<c:if test="$(item.getCategory() == itemCategory)">--%> 
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm">
                                        <div class="card" style="width: 18rem;">
                                            <img class="card-img-top" src="${item.imageUrl}" alt="Card image cap" width="200" height="300">
                                            <div class="card-body">
                                                <h5 class="card-title">${item.name}</h5>
                                                <p class="card-text">Price: $ ${item.price}</p>
                                                <p class="card-text">Stock:   ${item.quantity}</p>
                                                <a class="btn btn-primary" href="/IoTBay/item?itemId=${item.id}" role="button">View Details</a>
                                                <a href="/IoTBay/addCartItem?itemId=${item.id}&quantity=1" class="btn btn-primary">Add to Cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <%--</c:if>--%>
                    </c:forEach>

                </div>

            </div>
        </div>





        <footer class=footer>
        </footer>


    </body>

</html>

