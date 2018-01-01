<%-- 
    Document   : checkout
    Created on : Oct 25, 2017, 1:20:36 AM
    Author     : Prajna
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <title>Checkout</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
        <body>
            <div class="topnav">
            <div class="midtopnava">
            </div>
            </div>

<div class="content">
   
      <h1>Please enter your credit card details</h1>
      <form action="<c:url value='/completePayment'/>" method="post"/>
      <%-- Email  <input type="text" name="email"/><br/><br/>  ---%>
             Credit Card Number  <input type="text" name="creditCardId"/><br/><br/>
            <label for="cctype">Card Type </label>
                 <select name="cctype" id="cctype" class="form-control">
                           <option value="Visa">Visa</option>
                           <option value="MasterCard">MasterCard</option>
                           <option value="Discover">Discover</option>
                           <option value="American Express">American Express</option>
                        </select> <br/><br/>
               
            <label for="expirationMonth">Expiration Date  </label><br/><br/>
                        Expiration Month <select name="expirationMonth" id="expirationMonth">
                           <c:forEach begin="1" end="12" varStatus="i">
                              <option value="${i.index}">${i.index}</option>
                           </c:forEach>
                        </select>
  
                        Expiration Year <select name="expirationYear" id="expirationYear">
                           <c:forEach begin="2017" end="2030" varStatus="i">
                              <option value="${i.index}">${i.index}</option>
                           </c:forEach> 
                        </select><br/><br/>
                    
                  <input type="submit" class="textpimage" value="Submit Order" />
         </form>
      </div>
       
<jsp:include page="/footer.jsp" />
  </body>
</html>




