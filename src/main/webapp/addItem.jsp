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
        <title>Add Item</title>
    </head>
    <body>
        <%@include file="common/navbar.jsp" %>
        
        <main>
            <div class="signup-wrapper">
                <div class="signup-box">
                    <div class="signup-form container">
                        <form action="addItem" method="post">
                            <h2>New Device</h2>
                            <div class="form-group">
                                <label for="item_name"> Device Name: </label>
                                <input type="text" 
                                       id="item_name" 
                                       name="item_name"
                                       class="form-control"
                                       required autofocus>                               

                            </div>
                            <div class="form-group">
                                <label for="category"> Device Category: </label>
                                <select id="category" 
                                        name="category" 
                                        class="form-control"
                                        required autofocus>
                                    <option value="" disabled selected hidden>Please Choose...</option>
                                    <option value="Adapters">Adapters</option>
                                    <option value="Communications">Communications</option>
                                    <option value="Controllers">Controllers</option>
                                    <option value="Converters">Converters</option>
                                    <option value="Raspberry Pi">Raspberry Pi</option>
                                    <option value="Sensors">Sensors</option>
                                    
                                    
                                    
                                </select>  
                            </div>
                            <div class="form-group">
                                <label for="price">Device Price: $</label>
                                <input type="number" 
                                       min="0.01" 
                                       step="0.01" 
                                       id="price" 
                                       name="price"
                                       class="form-control"
                                       required autofocus>

                            </div>
                            <div class="form-group">
                                <label for="quantity">Device Quantity:</label>
                                <input type="number" 
                                       min="0" 
                                       step="1" 
                                       id="quantity" 
                                       name="quantity"
                                       class="form-control"
                                       required autofocus>

                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block btn-lg">
                                    Add Device 
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>  
        </main>
    </body>
</html> 
