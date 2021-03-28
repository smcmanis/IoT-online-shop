<%-- 
    Document   : login
    Created on : 23/03/2021, 12:08:00 AM
    Author     : hlong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/login.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous"/>
        <title>Login</title>
    </head>
    <body>
        <div class="text-center">
            <form class="form" method="post">
            <div>
                <h1 class="mb-3">Login</h1>
            </div>
            <div>
                <label for="email" class="sr-only">Email address</label>
                <input type="email" 
                       placeholder="Enter your email" 
                       name="email" 
                       class="form-control"
                       required autofocus>
                </input>
            </div>
            <div>
                <label for="password" class="sr-only">Password</label>
                <input 
                    type="password" 
                    placeholder="Enter your password" 
                    name="password"
                    class="form-control">
                </input>
            </div>
            <div class="mt-3">
                <button class="btn btn-lg btn-primary btn-block" 
                        type="submit">
                    Sign in
                </button>
            </div>
            <div>
                <div>
                    New customer?
                </div>
            </div>
        </form> 
        </div>
    </body>
</html>
