<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bootstrap 5-->
        <link rel="stylesheet"
              href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
        <script src="<c:url value="/resources/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

        <!--Font Awesome 5-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">

        <!--Local CSS-->
        <title>Orders</title>
    </head>

    <body>

        <c:if test="${filterDateStart != null && filterDateEnd != null}" var="isFiltered"></c:if>

        <%@include file="common/navbar.jsp" %>

        <!--Page title-->
        <h1 class="display-4 p-3">Order History</h1>

        <!--Page content-->
        <div clas="container">
            ]
            <div class="container">
                <h5 class="mb-3">
                    <b>Customer: </b>${customer.firstName} ${customer.lastName}
                </h5>
            </div>

            <div class="container">

                <!--// Search & filter form-->
                <div>
                    <!--Search & filter bar-->
                    <div class="row">
                        <div class="col-5">
                            <form method="POST" action="/IoTBay/customer/order/search">
                                <div class="input-group rounded">
                                    <input type="search" class="form-control rounded" 
                                           name="searchOrderId"
                                           placeholder="Search order #" aria-label="Search"
                                           aria-describedby="search-addon" />
                                    <button type="submit" class="input-group-text border-0" id="search-addon">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="col flex-grow-1">
                        </div>
                        <div class="col-3 d-flex justify-content-end">
                            <button class="btn btn-danger mb-2" type="button" 
                                    data-bs-toggle="collapse" data-bs-target="#collapseFilter"  
                                    aria-controls="collapseFilter"
                                    aria-expanded="${isFiltered}">
                                <i class="fab fa-filter"></i>
                                Filter
                            </button>
                        </div>
                    </div>

                    <!--Filter drop-down-->

                    <div id="collapseFilter"
                         <c:if test="${!isFiltered}" >
                             class="collapse" 
                         </c:if>>

                        <div class="card card-body">
                            <form method="POST" action="/IoTBay/customer/order/list">
                                <div class="row align-items-center">
                                    <div class="col-sm-4">
                                        <div class="form-floating mb-2">
                                            <input type="date" id="filterDateStart" name="filterDateStart"
                                                   class="form-control"
                                                   <c:if test="${isFiltered}">
                                                       value="${filterDateStart.toString()}"
                                                   </c:if>
                                                   min="2020-01-01" max="2023-01-01">
                                            <label for="filterDateStart" >From</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-floating mb-2">
                                            <input type="date" id="filterDateEnd" name="filterDateEnd"   
                                                   class="form-control"
                                                   <c:if test="${isFiltered}">
                                                       value="${filterDateEnd.toString()}"
                                                   </c:if>
                                                   min="2020-01-01" max="2023-01-01">
                                            <label for="filterDateEnd" >To</label>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <input type="submit" value="Search" class="btn form-control">

                                    </div>
                                </div>
                            </form> 
                            <c:if test="${isFiltered}">
                                <div class="d-flex justify-content-end">
                                    <a href="/IoTBay/customer/order/list" >Reset</a>
                                </div>
                            </c:if>
                        </div>

                    </div>
                </div>

                <!--Order history table-->
                <table class="table">
                    <tr>
                        <th>Order ID</th>
                        <th>Order Date</th>
                        <th>Total</th>
                        <th>Order Status</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${customerOrders}" var="order"> 
                        <tr class="align-middle">
                            <td>${order.id}</td>
                            <td>${order.orderDate}</td>
                            <td>$${order.cart.totalPrice}</td>
                            <td>${order.orderStatus}</td>
                            <td>
                                <div class="">
                                    <a href="/IoTBay/customer/order/view?orderId=${order.id}">View Order</a>
                                </div>
                                <div>
                                    <c:url value="/track/order?orderId=${order.id}" var="trackingUrl"/>
                                    <a href="${trackingUrl}">Track order</a>
                                </div>

                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${noSearchResults || (isFiltered && customerOrders.isEmpty())}">
                    No orders found
                </c:if>
            </div>
        </div>
    </body>
</html>
