<%-- 
    Document   : register
    Created on : Mar 28, 2021, 3:57:06 PM
    Author     : namlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous"/>
        <title>Register Page</title>
    </head>
    <body>
            <div class="text-center">
            <form class="form" method="post">
            <div>
                <h1 class="mb-3">Register</h1>
            </div>
            <div>
                <label for="fname" class="sr-only"></label>
                <input type="text" 
                       placeholder="First Name" 
                       name="fname" 
                       class="form-control"
                       required autofocus>
                </input>
            </div>
            <div>
                <label for="lname" class="sr-only"></label>
                <input type="text" 
                       placeholder="Last Name" 
                       name="lname" 
                       class="form-control"
                       required autofocus>
                </input>
            </div>
            <div>
                <label for="email" class="sr-only"></label>
                <input type="text" 
                       placeholder="Email Address" 
                       name="email" 
                       class="form-control"
                       required autofocus>
                </input>
            </div>
            <div>
                <label for="phone" class="sr-only"></label>
                <input type="text" 
                       placeholder="Phone Number" 
                       name="phone" 
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
                    Already has an account?
                    <a href="login.jsp">Login here</a>
                </div>
            </div>
        </form> 
        </div>
    </body>
</html>
