<%@page import="com.iotbay.shop.model.ShipmentDetails"%>
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
        <title>Edit Shipment Details</title>

    </head>
    <body>
        <%@include file="common/navbar.jsp" %>

        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="post" action="/IoTBay/EditShipmentServlet">
                        <input style="display:none;" name="shipmentDetailsId" value="${shipmenDetails.shipment_details_id}"/>
                        <h2>Edit Shipment Details</h2>                               
                        <div class="form-group">
                            <input type="text"
                                   placeholder="Country"
                                   name="country"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>       
                        <div class="form-group">
                            <input type="text"
                                   placeholder="Street Address"
                                   name="address_line_1"
                                   
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div> 
                        <div class="form-group">
                            <input type="text"
                                   placeholder="Postcode"
                                   name="postcode"
                                    
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div> 
                        <div class="form-group">
                            <input type="text"
                                   placeholder="Suburb"
                                   name="suburb"
                                   
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div> 
                        <div class="form-group">
                            <input type="text"
                                   placeholder="State"
                                   name="state"
                                   
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>    
                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-block btn-lg">
                                Update
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>
