<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet"
              href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
        <script src="<c:url value="/resources/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/css/style.css"/>">
        <link rel="stylesheet" 
              href="<c:url value="/resources/css/landingpage.css"/>">
        <title>IoTBay - The Internet of Things store</title>
    </head>

    <body>

        <%@include file="common/navbar.jsp" %>

        <!--<div class="container-xl">-->
            <section>
                <div class="circle"> </div>

                <div class="content">
                    <div class="textBox">
                        <h2>You can buy any Internet of Things devices<br> at the <span class="font-outline">Best Price</span></h2>
                        <p>The Internet of Things store (IoTBay) is a company based in Sydney, Australia.</p>
                        <a href="/IoTBay/catalogue">Start Shopping</a>
                    </div>
                    <div class="imgBox">
                        <img src="resources/images/page/img1.png" class="router">
                    </div>
                </div>
                <ul class="thumb">
                    <li><img src="resources/images/page/thumb1.png"></li>
                    <li><img src="resources/images/page/thumb2.png"></li>
                    <li><img src="resources/images/page/thumb3.png"></li>
                </ul>
                <ul class="sci">
                    <li><a href="#"><img src="resources/images/page/facebook.png"></a></li>
                    <li><a href="#"><img src="resources/images/page/twitter.png"></a></li>
                    <li><a href="#"><img src="resources/images/page/instagram.png"></a></li>
                </ul>
            </section>
        <!--</div>-->

    </body>

</html>


