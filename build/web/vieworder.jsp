<%-- 
    Document   : vieworder
    Created on : Nov 26, 2017, 11:28:08 PM
    Author     : prajn
--%>

<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <title>View Order</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
        <body>
       <c:import url="header.jsp" /> 

<div class="content">
  <h1>Your Order</h1>     

  <p>${cc_no_message} </p>

           <%-- <p><fmt:formatDate value="${order.orderDate}" type="date" dateStyle="short" /></p>
            <p><strong>Ordered by:</strong></p>
            <p><c:out value='${email} ' /></p>--%>
           
           <p> Email used for the order :  ${email}</p>  
           <p> CreditCard used for the order :  ${creditCardId}</p> 
           <p> Products Ordered </p> 
           <table class="table">
              
               <thead>
                  <tr>
                     <th>Name</th>
                     <th>Description</th>
                     <th>Price</th>
                    
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="product" items="${productlist}">
                     <tr>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        
                     </tr>
                  </c:forEach>
             </tbody>
            </table>         
                     
</div>

<c:import url="footer.jsp" />

</body>
</html>


