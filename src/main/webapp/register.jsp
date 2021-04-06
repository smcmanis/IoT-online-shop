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
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
              crossorigin="anonymous"/>
        <title>Register</title>
    </head>

    <body>
        <div class="signup-wrapper">
            <div class="signup-box">
                <div class="signup-form container">
                    <form method="post" action="welcome.jsp">
                        <h2>Register</h2>
                        <div class="form-group">
                            <input type="text"
                                   placeholder="First Name"
                                   name="first-name"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>
                        <div class="form-group">
                            <input type="text"
                                   placeholder="Last Name"
                                   name="last-name"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>
                        <div class="form-group">
                            <input type="email"
                                   placeholder="Email"
                                   name="email"
                                   class="form-control"
                                   required autofocus>
                            </input>
                        </div>
                        <div class="form-group">
                            <input type="password"
                                   placeholder="Password"
                                   name="password"
                                   class="form-control">
                            </input>
                        </div>
                        <div class="form-group">
                            <input type="password"
                                   placeholder="Confirm Password"
                                   name="confirm-password"
                                   class="form-control">
                            </input>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-block btn-lg">
                                Sign Up Now
                            </button>
                        </div>
                    </form>
                    <div>
                        Have an account?
                        <a href="login.jsp">Sign in</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
