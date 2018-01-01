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
        <title>Cart</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
        <body>
       <c:import url="header.jsp" /> 

<div class="content">
  <h1>Your Cart</h1>
 <c:choose>
      <c:when test="${emptyMessage != null}">
         <h3>${emptyMessage}</h3>
         <form method="post" action="<c:url value='/displayProducts' />">
                  <input type="submit" class="textpimage" value="Continue shopping" />
         </form>
      </c:when>
      <c:otherwise>
         <p>To change the quantity for an item,enter the new
                  quantity and click on the Update button.
               </p>
               <p>
                  To remove an item,click on the remove button.
               </p>
              
        
   
                  <table class="table">
                     <thead>
                        <tr>
                            <th>Gadget Purchased</th>
                            <th>Price (USD) </th>
                            <th>Quantity</th>
                            <th>Amount (USD) </th>
                            <th>&nbsp;</th>
                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach var="product" items="${cart.products}">
                           <tr>
                              <td>${product.product.name}</td>
                              <td>${product.product.price}</td>
                              <td>
                                 <form method="post" action="<c:url value='/updateProduct'/>">
                                    <input type="hidden" name="productid" value="<c:out value='${product.product.productid}' />" />
                                    <input type="text" name="quantity" value="<c:out value='${product.quantity}' />" />
                                    <input type="submit" class="textpimage" value="Update" />
                                 </form>
                              </td>
                              <td>${product.totalPrice}</td>
                              <td>
                                 <form method="post" action="<c:url value='/removeProduct'/>">
                                    <input type="hidden" name="productid" value="<c:out value='${product.product.productid}' />" />
                                    <input type="submit" class="textpimage" value="Remove" />
                                 </form>
                              </td>
                           </tr>
                        </c:forEach>
                        <tr>
                           <td><strong>Total:</strong></td>
                           <td>&nbsp;</td>
                           <td>&nbsp;</td>
                           <td>${cart.totalPrice}</td>
                           <td>&nbsp;</td>
                        </tr>     
                     </tbody>
                  </table>
                           <p><br/></p>
                           <p><br/></p>
               <form method="post" action="<c:url value='/displayProducts' />">
                  <input type="submit" class="textpimage" value="Continue shopping" />
               </form>
                <!--<a href="<c:url value='/displayProducts' />" class="textpimage" > Continue shopping</a>-->
                
                            <p><br/></p>
                           <p><br/></p>
                           
               <form method="post" action="<c:url value='/checkUser'/>">
                  <input type="submit" class="textpimage" value="Checkout" />
               </form>
               </div>
      </c:otherwise>
   </c:choose>

</div>

<c:import url="footer.jsp" />

</body>
</html>


