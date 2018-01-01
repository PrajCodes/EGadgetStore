/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.controllerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prajna.business.Cart;
import prajna.business.User;
import prajna.data.UserIO;

/**
 *
 * @author prajn
 */
public class UserServlet extends HttpServlet {

                    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String requestURI = request.getRequestURI();
        String url = "/cart.jsp";
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("User");
//         if (requestURI.endsWith("/login")) {
//            try {
//                url = UserIO.login(request, response);
//                
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//         }
        getServletContext().getRequestDispatcher(url).forward(request, response); 
//        if (requestURI.endsWith("/logout")) {
//          
//            session.invalidate();  
//         String message = "You are now logged out ";
//         request.setAttribute("message", message);
//     
//      }
        
//       String email=request.getParameter("email");
//        
//    try {
//        user = UserIO.searchByEmail(email);
//    } catch (SQLException ex) {
//        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
//    }
//if (user != null) {
//    session.setAttribute("user", user);
//    try {
//                url = UserIO.processUser(request, response);
//            } catch (SQLException ex) {
//                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//          }
// else {
//            try {
//                // Show error
//                String message = "You need to login in order to continue to checkout";
//                request.setAttribute("message", message);
//                
//                url = UserIO.login(request, response);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
      }


  
@Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
//String uri=request.getRequestURI();
//       if(uri.endsWith("/login")) {
//            String url = "/login.jsp";
       //  getServletContext().getRequestDispatcher(url).forward(request,response);
doPost(request, response);
       }
//       doPost(request, response); 
    }

// public static User createUser(HttpSession session, String firstName,
//           String lastName, String password, String email) {
//
//      User user = (User) session.getAttribute("user");
//      if (user == null) {
//         user = new User();
//      }
//
//      user.setFirstName(firstName);
//      user.setLastName(lastName);
//      user.setPassword(password);
//      user.setEmail(email);
//      return user;
//   }
// 


 
    
//}
  
    
        
   


