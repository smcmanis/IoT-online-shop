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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/signup.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous"/>
        <title>Login</title>
    </head>
    <body>
        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="post">
                        <h2>Sign In</h2>
                        <div class="form-group">
                            <input class="form-control" type="email" name="email" 
                                   placeholder="Email" required>
                            </input>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="password" name="password" 
                                   placeholder="Password" required>
                            </input>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success btn-block btn-lg" type="submit" >
                                Sign In 
                            </button>
                        </div>
                    </form>
                    <div class="sign-in-actions">
                        <a href="">Forgot Password?</a>
                        <a href="signup.jsp">Sign up</a>
                    </div>
                    <div>
                </div>
            </div>
        </div>
    </body>

</html>
