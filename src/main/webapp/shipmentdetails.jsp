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
        <title>Shipment Details</title>
    </head>


    <body>
        <%@include file="common/navbar.jsp" %>

        <br>
        <div class="container">
            <h3 class="text-center">Saved Shipments Details</h3>
            <hr>
            <div class="container text-left">

                <a href="add_shipment.jsp" class="btn btn-primary">Add New Shipment Details</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Street Address</th>
                        <th>Suburb</th>
                        <th>Postcode</th>
                        <th>State</th>
                        <th>Country</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${shipmentDetails}" var="shipmentDetails"> 
                        <tr class="align-middle">
                            <td>${shipmentDetails.address_line_1}</td>
                            <td>${shipmentDetails.suburb}</td>
                            <td>${shipmentDetails.postcode}</td>
                            <td>${shipmentDetails.state}</td>
                            <td>${shipmentDetails.country}</td>
                            <td>
                                <a href="/IoTBay/GetEditPageServlet?shipmentDetailsId=${shipmentDetails.shipment_details_id}" class="btn btn-primary">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="DeleteShipmentServlet?shipmentDetailsId=${shipmentDetails.shipment_details_id}" class="btn btn-danger">Delete</a>                     
                            </td>

                        </tr>
                    </c:forEach>
                    <!-- } -->
                </tbody>

            </table>
