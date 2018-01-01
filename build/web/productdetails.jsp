<%-- 
    Document   : product
    Created on : Nov 3, 2017, 12:27:30 AM
    Author     : prajn
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
 <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <title>${product.productid}</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
        <body>
            <c:import url="header.jsp" />
    <div class="content">
       <h1>${product.name}</h1>
         <p>
         <img src="<c:url value='img/${product.productid}_Cover.jpg' />" alt="Cover Image" />
         </p>
         <h3>Price ${product.price}  $ </h3>
         <p>
          ${product.description}
         </p>
         <form method="post" action="<c:url value='/addtocart?productid=${product.productid}'/>" class="float-left">
            <input type="hidden" name="productid" value="<c:out value='${product.productid}' />" />
            <a href="<c:url value='/addtocart?productid=${product.productid}' />">
            <input type="submit" class="textpimage" value="Add to Cart" /></a>
            
         </form>
    </body>
</html>
