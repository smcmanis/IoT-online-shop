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
    </head>

    <body>

        <%@include file="common/navbar.jsp" %>


        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="post" action="welcome.jsp">
                        <h2>Find Shipment</h2>                               
                        <div class="form-group">
                            <input type="text"
                                   placeholder="Shipment ID"
                                   name="shipment_id"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>                       
                        <div class="form-group">
                            <input type="date"
                                   placeholder="Date of Shipment"
                                   name="date_of_shipment"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>     
                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-block btn-lg">
                                Search
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>
