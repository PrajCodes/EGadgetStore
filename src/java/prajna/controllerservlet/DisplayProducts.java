/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.controllerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import prajna.business.Product;
import prajna.business.User;
import prajna.data.ProductIO;
import prajna.data.UserIO;

/**
 *
 * @author prajn
 */
//@WebServlet(name = "DisplayProducts", urlPatterns = {"/displayProducts", "/displayProducts/product*"})
public class DisplayProducts extends HttpServlet{
//     @Override
//      protected void doGet(HttpServletRequest request, HttpServletResponse response)
//           throws ServletException, IOException {
//          
//         try {
//              
//            
//            Connection conn
//                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
//            
//            
//            
//          
////           
////           
//            String name = "select name from product where productid=1";
//            PreparedStatement ps = conn.prepareStatement(name);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//            prodname=rs.getString("name");
//            }
   // HttpSession session= request.getSession();
//       // ? is a seperator
//       String prodname=request.getParameter("prodname"); 
//       session.setAttribute("name", prodname); 
//       session.setAttribute("producttype", producttype); 
//       String url = "/laptops.jsp";
//       getServletContext().getRequestDispatcher(url).forward(request,response);
//       conn.close();
//       }
//       catch (SQLException ex) {
//             Logger.getLogger(DisplayProducts.class.getName()).log(Level.SEVERE, null, ex);
//         }
//
//         finally {
//            out.close();
//        }
//       
//
//      }  
//
//  
//      @Override
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response)
//            throws ServletException, IOException {
//
//        doGet(request, response);
//    }   
//
//                    
//}



 @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
    String uri=request.getRequestURI();
     if (uri.endsWith("/Index"))
                {
                    System.out.println("Going inside if");
                 String url = "/index.jsp";  
                  getServletContext().getRequestDispatcher(url).forward(request, response);
                }
    else{
        System.out.println("Going inside else");
    String url="/products.jsp";
                
        try {
            System.out.println("Going inside try");
             url = "/products.jsp";
            List<Product> products; 
            url = displayProducts(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayProducts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     System.out.println(uri);   
      getServletContext().getRequestDispatcher(url).forward(request, response);
   }
   }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

      doGet( request,response);

//      getServletContext().getRequestDispatcher(url).forward(request, response);
   }

 
   private String displayProducts(HttpServletRequest request,
           HttpServletResponse response) throws ClassNotFoundException, SQLException {
           List<Product> products =new ArrayList<>() ;
           int total_products=10;
        for(int i=1;i<=total_products;i++)
            {
                Product product = ProductIO.selectProduct(i);  
                products.add(product);
                }

      HttpSession session = request.getSession();
      session.setAttribute("products", products);
      //session.setAttribute("imageUrl",products.getImageUrl((products.getProductid())));
      return "/products.jsp";
   }

   

//   private String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//
//      HttpSession session = request.getSession();
//      User user = (User) session.getAttribute("user");
//
//      if (user == null) {
//         Cookie[] cookies = request.getCookies();
//         String email = CookieUtil.getCookieValue(cookies, "emailCookie");
//
//         if (email == null) {
//            return "/login.jsp";
//         } else {
//            user = UserIO.searchByEmail(email);
//         }
//
//         // if user with given email does not exist, redirect to registration
//         if (user == null) {
//            return "/login.jsp";
//         }
//         session.setAttribute("user", user);
//      }
//      Product product = (Product) session.getAttribute("product");
//      return "/login.jsp";
//   }

  
   /* 
    * Validates data entered by user into a form
    * @return true if input is valid, false otherwise
    */
//   private boolean isValid(String firstName, String lastName, String email) {
//      boolean valid = true;
//
//      if (firstName == null || firstName.isEmpty()) {
//         valid = false;
//      } else if (lastName == null || lastName.isEmpty()) {
//         valid = false;
//      } else {
//         // validate email address
////         try {
////            InternetAddress emailAddress = new InternetAddress(email);
////            emailAddress.validate();
////         } catch (AddressException e) {
////            valid = false;
////         }
//     }
//
//      return valid;
//   }
}
