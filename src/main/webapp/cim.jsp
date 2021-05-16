<%-- 
    Document   : cim
    Created on : 6 May 2021, 2:28:47 am
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>  
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/resources/css/style.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" 
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" 
              crossorigin="anonymous">
        <title>Customer Information Management</title>
    </head>
    <body>
        <header class="header">
            <nav class="navbar bg-light navbar-expand-lg navbar-light">
                <a class="navbar-brand d-flex align-items-center " href="/IoTBay/Main">
                    <img src="resources/images/page/logo.png" alt="" class="logo">
                    IOT BAY
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="/IoTBay/itemManagement">Item Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Manage Orders</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/IoTBay/cim">Manage Users</a>
                        </li>

                    </ul>
                </div>
            </nav>
        </header>
        <br>
        <table class="table table-bordered">
            <tr>
                <td style="width:10%"><center>
                <a href="cimadd.jsp" class="btn btn-success">Add new User</a>
                </center>
                </td>
                <td style="width:90%">
                    <form method="post" action="cim">
                        <div class="input-group">
                            <input type="search" name="firstName" class="form-control" placeholder="Search by first name"/>
                            <input type="search" name="lastName" class="form-control" placeholder="Search by last name"/>
                          
                            <label class="input-group-text">Type</label>
                            <select class="custom-select" name="customertype">
                                <option Value="None" selected>Choose...</option>
                                <option value="Individual">Individual</option>
                                <option value="Company">Company</option>
                            </select>
                            <button type="submit" class="btn btn-primary">search</button>
                        </div>
                    </form>
                </td>   
            </tr>
        <br>
        <table class="table table-bordered">
            <thead>
		<tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
		<c:forEach  items="${users}" var="user">
                    <tr>
			<td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.firstName}" /></td>
                            <td><c:out value="${user.lastName}" /></td>
                            <td><c:choose>
                                        <c:when test="${user.active == true}">
                                            Activate
                                        </c:when>    
                                        <c:otherwise>
                                            Decativate
                                        </c:otherwise>
                                    </c:choose></td>
                            <td> <a href="AdminEditServlet?userId=${user.id}" class="btn btn-success">Edit</a>
                                <a href="AdminDeleteServlet?userId=${user.id}" class="btn btn-success">Delete</a>
                                    
                            </td>
                    </tr>
		</c:forEach>
		
            </tbody>
	</table>
    </body>
</html>