<%-- 
    Document   : cart
    Created on : Oct 25, 2017, 1:03:52 AM
    Author     : prajn
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <title>Orders</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
        <body>
       <c:import url="header.jsp" /> 

<div class="content">
<%--  <h1>Your Orders</h1>     
<h1>Thank you for your purchase, <c:out value='${user.firstName}' />!</h1>
<p><b>Current Purchase</b> </p>
<p>Date:</p>


            <p><fmt:formatDate value="${order.orderDate}" type="date" dateStyle="short" /></p>
            <p><strong>Ordered by:</strong></p>
            <p><c:out value='${order.user.firstName} ${order.user.lastName}' /></p>
            <table class="table">
              
               <thead>
                  <tr>
                     <th>Quantity</th>
                     <th>Description</th>
                     <th>Price</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="product" items="${order.orderproducts}">
                     <tr>
                        <td>${product.quantity}</td>
                        <td>${product.product.name}</td>
                        <td>${product.product.price}</td>
                     </tr>
                  </c:forEach>
             </tbody>
            </table>         --%>
                     
 <p><strong>Your Previous Orders will appear below. You can review your previous by entering the Creditcard number </strong></p>         
   
 <table class="table">
               <thead>
                  <tr>
                <th>Credit Card Number  </th>
                     <th>Order Id of the Order</th>
                    <th>View Order </th>
                  </tr>
               </thead>
               <tbody>
                    <c:forEach items="${orderlist}" var="order">
                        <tr> 
                          <%--<td>   ${order.creditCardId}</td>---%>
                          <td> <form name="creditCard" method="post"/>  <input type="text" name="creditCardId"/></form><br/><br/></td>
                           <td>  ${order.orderid}</td>
                           <td><a href="<c:url value='/RetreiveOrder?orderid=${order.orderid}'/>" class="textpimage"</a> View this Order </td>
                         </tr>      
                         </c:forEach>
                         </tbody>
            </table>         
              
                         
                      <%-- ${orderlist.get(i).orderid}
                      ${orderlist.get(i).creditCardId}
                   
                  </c:forEach> ---%>
                     
                     
                  <%--  <tr>
                     <td><strong>Total:</strong></td>
                     <td>&nbsp;</td>
             <td>${orders.orderproducts.getTotal()}</td>
                  </tr>   ---%>
              
         

</div>

<c:import url="footer.jsp" />

</body>
</html>


