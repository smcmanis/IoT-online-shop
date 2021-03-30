<%-- 
    Document   : signup
    Created on : 27 Mar 2021, 1:01:42 pm
    Author     : simon
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
        <title>Register</title>
    </head>
    <body>
        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="post">
                        <h2>Sign Up</h2>
                        <div class="form-group">
                            <input class="form-control" type="text" name="first-name" 
                                   placeholder="First Name" required>
                            </input>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="text" name="last-name" 
                                   placeholder="Last Name" required>
                            </input>
                        </div>
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
                            <input class="form-control" type="password" name="confirm-password" 
                                   placeholder="Confirm Password" required>
                            </input>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success btn-block btn-lg" type="submit" >
                                Sign Up 
                            </button>
                        </div>
                    </form>
                    <div>
                        Already have an account? <a href="login.jsp">Sign in</a>
                    </div>
                    <div>
                </div>
            </div>
        </div>
    </body>
</html>
