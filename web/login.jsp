<%-- 
    Document   : login
    Created on : Nov 8, 2017, 10:11:34 PM
    Author     : prajn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   
    <head>
        <title>Homepage</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
     <script type="text/javascript">
function checkValidation() {
if (document.forms["login"]["email"].value == "" || document.forms["login"]["firstName"].value == "") {
   alert(" FirstName and Email cannot be left blank ");
   return false;
   }
   else{
return true;
   }
}
</script>  
    </head>
        <body>
            <c:import url="header.jsp" />
<div class="content">  
    <c:if test="${user == null}"> 
  <h2>Enter your information to Login and Continue Shopping </h2>
  <form name="login" action="<c:url value='/login'/>" onsubmit="return checkValidation()" method="post"/> 
First Name  <input type="text" name="firstName"/><br/><br/> 
Last Name  <input type="text" name="lastName"/><br/><br/>
Email  <input type="email" name="email"/><br/><br/>  
Password  <input type="password" name="password"/><br/><br/>
  <input type="submit" class="textpimage" value="login"/> 
</form>
    </c:if>
  <c:if test="${user != null}"> 
  <h2>Hi, ${user.firstName}</h2>
  <h2>You are now logged in. You can now continue shopping </h2>
  <a href="<%=request.getContextPath()%>/logout" class="textpimage">Logout</a> 
  <br/>
  <br/>
   <br/>
    <br/>
  <form method="post" action="<c:url value='/displayProducts' />">
                  <input type="submit" class="textpimage" value="Stay logged in and Continue shopping" />
  </form>
  
  </c:if>
    
    
    
    
    
    
    
    
    
    
    
    
</div>

            <c:import url="footer.jsp" />
        </body>
</html>
 
    
 
