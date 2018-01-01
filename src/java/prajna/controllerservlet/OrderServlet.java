
package prajna.controllerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prajna.business.Cart;
import prajna.business.CreditCard;
import prajna.business.Orders;
import prajna.business.User;
import prajna.data.OrdersIO;
import prajna.data.UserIO;

/**
 *
 * @author prajn
 */
public class OrderServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      String requestURI = request.getRequestURI();
      String url = "/orders.jsp";
      if (requestURI.endsWith("/viewOrders")) {
          try {
             viewOrders(request, response);
          } catch (SQLException ex) {
              Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   doPost( request,  response);
 getServletContext().getRequestDispatcher(url).forward(request, response);
}
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      String requestURI = request.getRequestURI();
      String url = "/orders.jsp";
      if (requestURI.endsWith("/viewOrders")) {
          try {
             viewOrders(request, response);
          } catch (SQLException ex) {
              Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      if (requestURI.endsWith("/completePayment")) {
          try {
              System.out.println("Comes into OrderServlet");
              url = completePayment(request, response);
          } catch (SQLException ex) {
              Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   
      if (requestURI.endsWith("/doneshopping")) {
         url = "/index.jsp";
      }
      
       getServletContext().getRequestDispatcher(url).forward(request, response);
}
   
    /**
     *
     * @param request
     * @param response
     * @return
     */
    public static void viewOrders(HttpServletRequest request,
           HttpServletResponse response) throws SQLException {

      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");
      Cart cart = (Cart) session.getAttribute("cart");

      Orders orders = new Orders();
      System.out.println("Inside View Orders");
     orders.setUser(user);
 orders.setOrderproducts(cart.getProducts());
 System.out.print(orders);
 //orders.setOrderDate(new Date());
////////////////////////////////////////////
//      Orders order = (Orders) session.getAttribute("order");
     // order.setCreditCardId(creditCardId);
 int numberoforders=OrdersIO.selectNoofOrders(user.getEmail());
 System.out.println(numberoforders);
List<Orders> orderlist=new ArrayList<Orders>();
 session.setAttribute("numberoforders",numberoforders);
      for(int i=0;i<numberoforders;i++){
      
    orderlist=OrdersIO.displayOrders(user.getEmail());
      
      System.out.println("Inside View orders");
      }

 //////////////////////////////////////////////////
     session.setAttribute("orderlist", orderlist);

     // return "/orders.jsp";
   }
   
      private String completePayment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException
      {
      // retrieve parametres from the checkout form
      String creditCardId = request.getParameter("creditCardId");
      String cctype = request.getParameter("cctype");
      String expirationMonth = request.getParameter("expirationMonth");
      String expirationYear = request.getParameter("expirationYear");
  System.out.println(" Comes into complete Payment method");
      HttpSession session = request.getSession();
      User user = (User) session.getAttribute("user");
     Cart cart =(Cart) session.getAttribute("cart");
      String userEmail= user.getEmail();
      CreditCard creditCard = new CreditCard();
      creditCard.setCctype(cctype);
      creditCard.setCreditCardId(creditCardId);
      creditCard.setExpirationDate(expirationMonth + "/" + expirationYear);
      System.out.println(cart);
      
      
     OrdersIO.ccInsert(creditCardId,cctype,expirationMonth,expirationYear,userEmail);
    
     Orders order = new Orders();
     order.setUser(user);
     order.setOrderproducts(cart.getProducts());
     LocalDate date =LocalDate.now();
     order.setOrderDate(date);
     order.setCreditCardId(creditCardId);
     order.setEmail(userEmail);
      session.setAttribute("order", order);
                String ccid =order.getCreditCardId();
                String email = order.getEmail();
      OrdersIO.insert(ccid,email);
      int orderid=OrdersIO.selectorderid(order);
//      Orders order = (Orders) session.getAttribute("order");
     // order.setCreditCardId(creditCardId);
      for(int i=0;i<order.getOrderproducts().size();i++){
      OrdersIO.insertOrderProducts( orderid,order.orderproducts.get(i).getProduct().getProductid(),order.orderproducts.get(i).getQuantity());
      System.out.println(order.orderproducts.get(i).getProduct().getProductid());
      }
      session.setAttribute("order", order);
     
     
     
     user.setCreditCard(creditCard);
    
    //  if (UserIO.searchByEmail((user.getEmail()))==user) {
       //  UserIO.update(user);
      //   System.out.println("UserIO Update searchby email inside Orderservlet");
     // } else {
         //UserIO.insert(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
        // UserIO.processUser(request, response);
         
      //  if(userEmail.equals(user.getEmail()))
     //   {
            System.out.println("userEmail.equalsuser.getEmail");
           viewOrders(request,response); 
       // OrdersIO.insert(order);
      //  }
   //   }

      // insert an order to the database and remove all items from user's cart
      
      
      session.setAttribute("cart", null);
      
//      Cookie emailCookie = new Cookie("emailCookie", user.getEmail());
//      emailCookie.setMaxAge(60 * 24 * 365 * 2 * 60);
//      emailCookie.setPath("/");
//      response.addCookie(emailCookie);
     
      return "/orders.jsp";
   }
    
    
    
}
