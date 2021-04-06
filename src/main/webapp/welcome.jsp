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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/loginstyle.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous"/>
        <style>
            table {margin-left:auto}
            table{margin-right: auto}
            .container {
                height: 200px;
                position: relative;
                
              }

            .center {
              margin: 0;
              position: absolute;
              top: 50%;
              left: 50%;
              -ms-transform: translate(-50%, -50%);
              transform: translate(-50%, -50%);
            }
        </style> 
        <title>Welcome</title>
    </head>
    <body>
        <div class="container"> 
            <div class="center">
            <form class="form" method="post">
                <div>
                    <h1 class="mb-3">Welcome Maisie!</h1>
                </div>
                <div class="mt-3"> 
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Go to Account Settings">
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Go to Store">
                </div>           
            </form>
            </div>
        </div>
    </body>
</html>
