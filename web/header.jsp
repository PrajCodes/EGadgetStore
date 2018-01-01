<%-- 
    Document   : header
    Created on : Nov 2, 2017, 10:36:48 PM
    Author     : prajn
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Menu Bar</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <div class="topnav">
            <div class="midtopnava">
            <a href="<%=request.getContextPath()%>/Index">Home</a>
            <a href="<%=request.getContextPath()%>/displayProducts">All Gadgets</a>
            <a href="<%=request.getContextPath()%>/login">Login</a>
            <a href="<%=request.getContextPath()%>/loadCart"> Cart</a>

          
            </div>
            </div>
    </body>
</html>


<!--            The URL Pattern which is mentioned in servlet and webxml has to be put after context path  here -->
            <!--<a href="laptops.jsp">Laptops</a>-->