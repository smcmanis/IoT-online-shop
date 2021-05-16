<%-- 
    Document   : shipmentdetails
    Created on : May 16, 2021, 12:50:13 PM
    Author     : namlo
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/resources/css/style.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" 
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" 
              crossorigin="anonymous">
        <title>Shipment Details</title>
    </head>


    <body>
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
