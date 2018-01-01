<%-- 
    Document   : laptops
    Created on : Oct 25, 2017, 12:44:33 AM
    Author     : prajn
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <title>${producttype}</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
        <body>
            <c:import url="header.jsp" />
    <div class="content">
       <h3>Special Deals on Black Friday and Cyber Monday !!! </h3> 
    
    <div class="prow">       

  <c:forEach begin="1" end="3" var="item" items="${products}">
          <div class="pcol s4">
                     <a href="<c:url value='/productdetails?productid=${item.productid}' />">
                     <img src="<c:url value='img/${item.productid}_Cover.jpg' />" alt="Product Image" style="width:100%" /> </a>
                     <div class="belowpimage">
                        <div class="textpimage"> ${item.name}
                    
                        </div>
                        </div>
                     </div>
          
 </c:forEach>
       </div>
       
      <div class="prow">       

  <c:forEach begin="7" end="9" var="item" items="${products}">
          <div class="pcol s4">
                     <a href="<c:url value='/productdetails?productid=${item.productid}' />">
                     <img src="<c:url value='img/${item.productid}_Cover.jpg' />" alt="Product Image" style="width:100%" /> </a>
                     <div class="belowpimage">
                        <div class="textpimage"> ${item.name}
                    
                        </div>
                        </div>
                     </div>
 </c:forEach>
 
       </div> 
     
     
  <div class="prow">       

  <c:forEach begin="4" end="6" var="item" items="${products}">
          <div class="pcol s4">
                     <a href="<c:url value='/productdetails?productid=${item.productid}' />">
                     <img src="<c:url value='img/${item.productid}_Cover.jpg' />" alt="Product Image" style="width:100%" /> </a>
                     <div class="belowpimage">
                        <div class="textpimage"> ${item.name}
                    
                        </div>
                        </div>
                     </div>
          
          
 </c:forEach>
 
 </div> 
   <div class="prow">       

  <c:forEach begin="12" end="14" var="item" items="${products}">
          <div class="pcol s4">
                     <a href="<c:url value='/productdetails?productid=${item.productid}' />">
                     <img src="<c:url value='img/${item.productid}_Cover.jpg' />" alt="Product Image" style="width:100%" /> </a>
                     <div class="belowpimage">
                        <div class="textpimage"> ${item.name}
                    
                        </div>
                        </div>
                     </div>
          
          
 </c:forEach>
 
 </div> 
   

<c:import url="footer.jsp" />
    </div>
</body>
</html>



