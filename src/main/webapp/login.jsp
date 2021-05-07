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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous"/>
        <title>Login</title>
    </head>

    <body>
        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form class="form" method="post" action="login">
                        <h2>Sign In</h2>
                        <div class="form-group">
                            <input type="email" 
                                   class="form-control" 
                                   name="email" 
                                   placeholder="Email" 
                                   required>
                            </input>
                        </div>
                        <div class="form-group">
                            <input type="password"
                                   class="form-control"  
                                   name="password" 
                                   placeholder="Password"
                                   required>
                            </input>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-block btn-lg">
                                Sign In 
                            </button>
                        </div>
                    </form>
                    <div class="sign-in-actions">
                        <a href="">Forgot Password?</a>
                        <a href="register.jsp">Sign up</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
