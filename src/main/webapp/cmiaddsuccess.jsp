<%-- 
    Document   : cimaddsuccess
    Created on : 16 May 2021, 12:53:03 pm
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" 
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" 
              crossorigin="anonymous">
        <title>Successfully</title>
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
        <a href="cim" class="btn btn-success">Back to CIM</a>
        <a href="cimadd.jsp" class="btn btn-success">Add new User</a>
        <br>
    <center>Add ${user.firstName} into the system successfully ! </center>
    <div class="container   col-md-5">
        <div class="card">
            <div class="card-body">
                <caption>
                    <h2>
                        Information of User ID #${user.id}
                    </h2>
                </caption>
                <input type='hidden' name='userId' id='numero' value="${user.id}" />

                <fieldset class="form-group">
                    <label>Email</label> 
                    <input type="email"
                           placeholder="Email"
                           name="email"
                           class="form-control-plaintext"
                           value="${user.email}"
                           required autofocus>
                </fieldset>
                <fieldset class="form-group">
                    <label>First name</label>
                    <input type="text"
                           class="form-control-plaintext"
                           name="first-name" 
                           placeholder="First Name"
                           value="${user.firstName}"
                           required autofocus>
                </fieldset>
                <fieldset class="form-group">
                    <label>Last name</label>
                    <input type="text"
                           class="form-control-plaintext"
                           name="last-name" 
                           placeholder="Last Name"
                           value="${user.lastName}"
                           required autofocus>
                </fieldset>
                <fieldset class="form-group">
                    <label>Password</label>
                    <input type="text"
                           placeholder="Password"
                           name="password"
                           class="form-control-plaintext"
                           value="${user.passwordPlaintext}"
                           required autofocus> 
                </fieldset>

                </form>
            </div>
        </div>
    </div>
</body>
</html>