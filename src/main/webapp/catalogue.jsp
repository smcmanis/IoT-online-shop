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
                    <form method="post" action="/IoTBay/item/search">
                        <div class="input-group rounded">
                            <input type="search" class="form-control rounded"  
                           name="searchItem" 
                           placeholder="Search.." 
                           title="Type in a category"
                           aria-label="Search"
                           aria-describedby="search-addon">
                            <button type="submit" class="input-group-text border-0" id="search-addon">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </form>  
                    <ul id="myMenu">
                        <li><a href="/IoTBay/catalogue?itemCategory=Adapters">Adapters</a></li> 
                        <li><a href="/IoTBay/catalogue?itemCategory=Communications">Communications</a></li>
                        <li><a href="/IoTBay/catalogue?itemCategory=Controllers">Controllers</a></li>
                        <li><a href="/IoTBay/catalogue?itemCategory=Converters">Converters</a></li>
                        <li><a href="/IoTBay/catalogue?itemCategory=Raspberry Pi">Raspberry Pi</a></li>
                        <li><a href="/IoTBay/catalogue?itemCategory=Sensors">Sensors</a></li>
                    </ul>
                </div>
                <h1 class="center">Products</h1>
                <c:if test="${itemCategory != null}" >
                <h2>Category : ${itemCategory}</h2> 
                </c:if>
                <c:if test="${searchItem != null}">
                    <h2>Search Results for : ${searchItem}</h2> 
                </c:if>
                <c:if test="${noSearchResults}">
                    No matching results found
                </c:if>
                <div class = "d-flex flex-wrap ">
                    <c:forEach items="${catalogue}" var="item" >
                        <div class="card col-3">
                            <img class="card-img-top" src="${item.imageUrl}" alt="Card image cap" width="200" height="300">
                            <div class="card-body">
                                <h5 class="card-title">${item.name}</h5>
                                <p class="card-text">Price: $ ${item.price}</p>
                                <c:if test="${item.quantity > 0} " >
                                    <p class="card-text">Stock:   ${item.quantity}</p>
                                </c:if>
                                <c:if test="${item.quantity == 0} " >
                                    <p class="card-text">Stock: OUT OF STOCK </p>
                                </c:if>
                                <a class="btn btn-primary" href="/IoTBay/item?itemId=${item.id}" role="button">View Details</a>
                                <a href="/IoTBay/addCartItem?itemId=${item.id}&quantity=1" class="btn btn-primary">Add to Cart</a>
                            </div>
                        </div>
                    </c:forEach>

                </div>

            </div>
        </div>





        <footer class=footer>
        </footer>


    </body>

</html>

