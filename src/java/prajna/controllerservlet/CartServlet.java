package prajna.controllerservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import prajna.data.ProductIO;
import prajna.business.OrderProducts;
import prajna.business.Cart;
import prajna.business.Product;
import prajna.business.User;
import prajna.business.CreditCard;
import prajna.business.Orders;
import prajna.data.ProductIO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prajna.data.OrdersIO;
import prajna.data.UserIO;
import static prajna.data.UserIO.searchByEmail;
//@WebServlet(name = "OrderController", urlPatterns = {"Cart/*"})
@WebServlet(name = "CartServlet", urlPatterns = {"/order/*","/addtocart","/EStore/updateProduct","/EStore/removeProduct"})
public class CartServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
String requestURI = request.getRequestURI();
      String url = "/cart.jsp";
      if (requestURI.endsWith("/loadCart")) {
         url = showCart(request, response);
      }

      getServletContext().getRequestDispatcher(url).forward(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      String requestURI = request.getRequestURI();
      String url = "/cart.jsp";

      
      
       if (requestURI.endsWith("/checkUser")) {
          try {
              url = checkUser(request, response);
          } catch (SQLException ex) {
              Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
       
       
      if (requestURI.endsWith("/addtocart")) {
          try {
              url = addtoCart(request, response);
          } catch (SQLException ex) {
              Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
      
      if (requestURI.endsWith("/updateProduct")) {
          try {
              url = updateProduct(request, response);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      
      
      
//        else if (requestURI.endsWith("/removeProduct")) {
     if (requestURI.endsWith("/removeProduct")) {
       
              
              try {
                  System.out.println(requestURI);
                  url = removeProduct(request, response);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
              } catch (SQLException ex) {
                  Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
              }
         
      } 

     //can make below else statement
   
    
      getServletContext().getRequestDispatcher(url).forward(request, response);
   }

   private String showCart(HttpServletRequest request, HttpServletResponse response) {
      HttpSession session = request.getSession();
      Cart cart = (Cart) session.getAttribute("cart");

      if (cart == null || cart.getCount() <= 0) {
         String emptyMessage = "Your cart is empty";
         request.setAttribute("emptyMessage", emptyMessage);
      }
      else{
          
      }
      return "/cart.jsp";
   }

     
     
      
   private String addtoCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
     
      HttpSession session = request.getSession();
      Cart cart = (Cart) session.getAttribute("cart");
      if (cart == null) {
         cart = new Cart();
      }

      int productid = Integer.parseInt(request.getParameter("productid"));
      Product product = ProductIO.selectProduct(productid);
      if (product != null) {
         OrderProducts orderproducts = new OrderProducts();
         orderproducts.setProduct(product);
         cart.addProduct(orderproducts);
      }
      session.setAttribute("cart", cart);
      return "/cart.jsp";
   }

   
   private String updateProduct(HttpServletRequest request,
           HttpServletResponse response) throws ClassNotFoundException, SQLException {

      HttpSession session = request.getSession();
      Cart cart = (Cart) session.getAttribute("cart");
      int productid = Integer.parseInt(request.getParameter("productid"));
      Product product = ProductIO.selectProduct(productid);

      int quantity;
      try {
         quantity = Integer.parseInt(request.getParameter("quantity"));
         if (quantity <= 0) {
            quantity = 1;
         }
      } catch (NumberFormatException e) {
         quantity = 1;
      }

      if (cart != null && product != null) {
         OrderProducts orderproducts = new OrderProducts();
         orderproducts.setProduct(product);
         orderproducts.setQuantity(quantity);

         if (quantity > 0) {
            cart.addProduct(orderproducts);
         } else {
            cart.removeProduct(orderproducts);
         }
      }

      return "/cart.jsp";
   }


   private String removeProduct(HttpServletRequest request,
           HttpServletResponse response) throws ClassNotFoundException, SQLException {

      HttpSession session = request.getSession();
      Cart cart = (Cart) session.getAttribute("cart");
      System.out.println("Inside remove product ");
     int productid = Integer.parseInt(request.getParameter("productid"));
      
      Product product = ProductIO.selectProduct(productid);

      if (cart != null && product != null) {
         OrderProducts orderproducts = new OrderProducts();
       orderproducts.setProduct(product);
         cart.removeProduct(orderproducts);
      }

      return "/cart.jsp";
   }

 

   private String checkUser(HttpServletRequest request,
           HttpServletResponse response) throws SQLException, ClassNotFoundException {
            HttpSession session = request.getSession();
            User user=(User)session.getAttribute("user");
            String url;
//        Cookie[] cookies = request.getCookies();
//        String email = CookieUtil.getCookieValue(cookies, "emailCookie");
//         System.out.println("emailCookie");
//         System.out.println(email);
          Cart cart = (Cart) session.getAttribute("cart");
        if(user==null){
            //session.setAttribute("userid", session.getId());
            //System.out.println("user id session"+session.getAttribute("userid"));
           url = "/login.jsp";
         } else {
            
            
            System.out.println("inside checkuser else loop ");
            
            user = UserIO.searchByEmail(user.getEmail());
            
            
            
//            HttpSession session = request.getSession();
//      User user = (User) session.getAttribute("user");
//      Cart cart = (Cart) session.getAttribute("cart");

   
     
//      for(int i=0;i<order.getOrderproducts().size();i++){
//      OrdersIO.insertOrderProducts(order.orderproducts.get(i).getProduct().getProductid(),order.orderproducts.get(i).getQuantity());
//      System.out.println(order.orderproducts.get(i).getProduct().getProductid());
//      }
     
              url = "/checkout.jsp";
           }

      return url;
   }
   
   /* 
    * Validates data entered by user into a form
    * @return true if input is valid, false otherwise
    */
//   private String processCreditCard(HttpServletRequest request,
//           HttpServletResponse response)
//           //String creditCardId, String cctype, String expirationMonth, String expirationYear )
//   {
//      HttpSession session = request.getSession();
//      String creditCardId=request.getParameter("creditCardId");
//      String cctype=request.getParameter("cctype");
//      String expirationMonth=request.getParameter("expirationMonth");
//      String expirationYear=request.getParameter("expirationYear");
//      CreditCard cc=new CreditCard();
//      cc.setCreditCardId(creditCardId);
//      cc.setCctype(cctype);
//      cc.setExpirationMonth(expirationMonth);
//      cc.setExpirationMonth(expirationMonth);
//      if(cc.getCreditCardId()!=null || cc.getCctype() !=null || cc.getExpirationMonth() != null ){
//      
//      }
//    return null;
//     
//      
//      
//   }
   

   /*
    * Retrieves a user object from the http session or creates a new one if
    * it does not exist. Afterwards, it fills it with the provided data. 
    */
   
//   private String displayInvoice(HttpServletRequest request,
//           HttpServletResponse response) {
//
//      HttpSession session = request.getSession();
//      User user = (User) session.getAttribute("user");
//      Cart cart = (Cart) session.getAttribute("cart");
//
//      Orders order = new Orders();
//      order.setUser(user);
//      order.setOrderproducts(cart.getProducts());
//      order.setOrderDate(LocalDate.now());
//
//      session.setAttribute("order", order);
//
//      return "/orders.jsp";
//   }

 
}

