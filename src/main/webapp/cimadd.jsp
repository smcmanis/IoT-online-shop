<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>  
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/resources/css/style.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" 
              integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" 
              crossorigin="anonymous">
        <title>Add New - Customer Information Management</title>
    </head>
    <body>
        <%@include file="common/navbar.jsp" %>
        <br>
        <a href="cim" class="btn btn-success">Back to CIM</a>
        <div class="container   col-md-5">
		<div class="card">
			<div class="card-body">
				<caption>
                                    <h2>
                                    Add New User
                                    </h2>
                                    <h5> 
                                    <%
                                        if(session.getAttribute("status") != null){
                                            String thestatus=(String)session.getAttribute("status"); 
                                            out.print(thestatus); 
                                            session.removeAttribute("status");
                                        }
                                    %>  
                                    </h5>
				</caption>
                                <form method="post" action="AdminRegisterServlet">
				<fieldset class="form-group">
                                    <label>First Name</label>
                                    <input type="text"
                                    class="form-control"
                                    name="register-first-name" 
                                    placeholder="First Name"
                                    required autofocus>
				</fieldset>
                                <fieldset class="form-group">
                                    <label>Last Name</label>
                                    <input type="text"
                                    class="form-control"
                                    name="register-last-name" 
                                    placeholder="Last Name"
                                    required autofocus>
				</fieldset>
				<fieldset class="form-group">
                                    <label>Email</label>
                                    <input type="email"
                                    placeholder="Email"
                                    name="register-email"
                                    class="form-control"
                                    required autofocus>
				</fieldset>
				<fieldset class="form-group">
                                    <label>Password</label>
                                    <input type="password"
                                    placeholder="Password"
                                    name="register-password"
                                    class="form-control"
                                    required autofocus>
				</fieldset>
                                <input type="submit" class="btn btn-success btn-block btn-lg">
				</form>
			</div>
		</div>
	</div>
    </body>
</html>