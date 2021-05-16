<%@page import="com.iotbay.shop.model.Shipment1"%>
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
        <title>Find Shipment</title>
        <% String searchErr = (String)session.getAttribute("searchErr");
           Shipment1 shipment = (Shipment1) session.getAttribute("shipment");
           String dateErr = (String) session.getAttribute("dateErr");
        %>
    </head>

    <body>

        <%@include file="common/navbar.jsp" %>


        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="post" action="FindShipmentServlet">
                        <h2>Find Shipment</h2>                               
                        <div class="form-group">
                            <input type="text"
                                   placeholder="Shipment ID"
                                   name="shipment_id"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>     
                        <br>
                        <div class="form-group">
                            <input type="date"
                                   placeholder="Date of Shipment"
                                   name="shipment_date"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>     
                        <br>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block btn-lg">
                                Search
                            </button>
                        </div>
                    </form> 
                </div>
            </div>           
        </div>  
                <jsp:include page="/ConnServlet" flush="true"/>
            <% if (shipment != null) { %>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Shipment ID </th>
                            <th>Tracking Number </th>
                            <th>Shipment Status </th>
                            <th>Shipment Date </th>
                            <th>Shipment Address </th>
                            <th>Order ID </th>
                        </tr>
                    </thead>
                    <br>
                    <tbody>
                        <tr class="align-middle">
                            <td>${shipment.shipment_id} </td>
                            <td>${shipment.tracking_number} </td>
                            <td> ${shipment.shipment_status}</td>
                            <td> ${shipment.shipment_date} </td>
                            <td> ${shipmentDet.address_line_1}, ${shipmentDet.suburb}, ${shipmentDet.postcode}, ${shipmentDet.state} </td>
                            <td> ${shipment.order_id} </td>
                        </tr>
                    </tbody>
            </table>
            <%  } else {} %>
    </body>

</html>
