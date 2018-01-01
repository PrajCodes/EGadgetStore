<%-- 
    Document   : index
    Created on : Oct 24, 2017, 10:57:36 AM
    Author     : prajn
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <title>Homepage</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <style>
        .mySlides {display:none;}
        </style>
    </head>
        <body>
            <c:import url="header.jsp" />
<div class="content">
</html>
  <img class="mySlides" src="img\4_Cover.jpg" style="width:70%"; align="center">
  <img class="mySlides" src="img\3_Cover.jpg" style="width:70%"; align="center">
  <img class="mySlides" src="img\5_Cover.jpg" style="width:70%"; align="center">
  <img class="mySlides" src="img\6_Cover.jpg" style="width:70%"; align="center">
  <img class="mySlides" src="img\14_Cover.jpg" style="width:70%"; align="center">
  <img class="mySlides" src="img\8_Cover.jpg" style="width:70%"; align="center">
</div>

            <c:import url="footer.jsp" />


<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
</body>


