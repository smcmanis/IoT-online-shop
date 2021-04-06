<%-- 
    Document   : welcome
    Created on : 29/03/2021, 3:51:20 PM
    Author     : trees
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous"/>
        <title>Welcome!</title>
    </head>

    <body>
        <%
            String firstName = request.getParameter("first-name");
            String lastName = request.getParameter("last-name");
            String email = request.getParameter("email");
        %>
        <div class="container"> 
            <div class="center">
                <div class="form" method="post" >
                    <div>
                        <h1 class="mb-3">Welcome <% out.print(firstName); %>!</h1>
                    </div>
                    <div> Name: <% out.print(firstName + " " + lastName); %>!</div>
                    <div> Email: <% out.print(email);%>!</div>

                    <div class="mt-3"> 
                        <a class="btn btn-lg btn-primary btn-block">Go to Account Settings"</a>
                        <a class="btn btn-lg btn-primary btn-block" href="<%=request.getContextPath()%>/main.jsp"> Proceed to store </a>
                    </div>           
                </div>
            </div>
        </div>
    </body>
</html>
