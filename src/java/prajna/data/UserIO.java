/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.data;

import java.io.*;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import prajna.data.*;
import prajna.business.*;
import prajna.controllerservlet.CartServlet;
import prajna.controllerservlet.UserServlet;

/**
 *
 * @author prajn
 */

public class UserIO extends HttpServlet{

     @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String url = "/login.jsp";
        HttpSession session = request.getSession();
          
         if (requestURI.endsWith("/login")) { 
       try {
            Class.forName("org.sqlite.JDBC");

            Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
       
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    if (email != null) {

                String sql = "insert into USER (firstName,lastName,email,password) values(?,?,?,?)";
                PreparedStatement updPrep = conn.prepareStatement(sql);
                updPrep.setString(1, firstName);
                updPrep.setString(2, lastName);
                updPrep.setString(3, email);
                updPrep.setString(4, password);
                updPrep.executeUpdate();
                System.out.println("Record is inserted into DBUSER table!");
                User user=new User(firstName,lastName,email,password);
            session.setAttribute("user",user);
            
            }
            
   
        } catch (Exception e) {
            log("got an error:", e);

        } finally {
            out.close();
        }
        url = "/login.jsp";
     }
         
         if (requestURI.endsWith("/logout")) {
          
         session.invalidate();  
         url="/login.jsp";
      }
         
      
         
       getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
   @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.print("Coming into doPost");
        doPost(request, response);
    }

    


    
    public static String processUser(HttpServletRequest request,
           HttpServletResponse response) throws SQLException, ClassNotFoundException {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute("user");

      // validate data
      String url;
      if (user.getEmail() == null) {
      url="/login";
      }
     else if ((user.getEmail()!=null) && (user.getPassword()!=null))
      {
//         if (user==searchByEmail(user.getEmail())) {
//           UserIO.update(user);
//           url = "/checkout.jsp";
//         } else {
          System.out.println("Inside process user");
          
          //  UserIO.insert(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
            url = "/checkout.jsp";
       //  }
        
      } else {
         String message = "FirstName,password or Email cannot be left blank or "
                 + "the information provided is not valid, ";
         request.setAttribute("message", message);
         url = "/login.jsp";
      }

      session.setAttribute("user", user);
      return url;
   }

    
    
    public static User searchByEmail(String email) throws SQLException {
       
      User user = new User();
       Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
       String sql = "SELECT * FROM USER WHERE email ="+"\""+email+"\"";
                PreparedStatement updPrep = conn.prepareStatement(sql);
                ResultSet rs=updPrep.executeQuery();
                
               if (!rs.next()) {    
                        System.out.println("No user with this email is present"); 
                                        
                        } 
                else{
                    String userfirstName = rs.getString("firstName");
                String userlastName = rs.getString("lastName");
                String useremail = rs.getString("email");
                String userpassword = rs.getString("password");
                
                        user.setEmail(email);
                        user.setFirstName(userfirstName);
                        user.setLastName(userlastName);
                        user.setPassword(userpassword);
                }
                 conn.close();
                 return user;
   }

   /**
    * @param user The user to be inserted into a database
    */
   public static void insert(String firstName, String lastName, String email,String password) throws SQLException, ClassNotFoundException {
try{
    
 Class.forName("org.sqlite.JDBC");
       Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
      // String sql = "insert into USER (firstName,lastName,email,password) values("+user.getFirstName();","+user.getLastName();","+user.getemail();","+user.getPassword();)";
                         
    
    if (email != null) {
              
                String sql = "insert into USER (firstName,lastName,email,password) values(?,?,?,?)";
                PreparedStatement updPrep = conn.prepareStatement(sql);
//                updPrep.setString(1, firstName);
//                updPrep.setString(2, lastName);
//                updPrep.setString(3, email);
//                updPrep.setString(4, password);
                updPrep.executeUpdate();
                System.out.println("Record is inserted into USER table!");          
      
    }
   
   conn.close();
   }
 catch(Exception e) {
     System.out.println(e);
 }
finally {
            out.close();
            
        }
   }
   
 
   
   /**
    * Checks if user with specified email exists within the database
    * 
    * @param email The email address to be checked
    * @return True if a user with given email exists, false otherwise
     * @throws java.sql.SQLException
    */
//   public static boolean emailExists(String email) throws SQLException {
//      return searchByEmail(email) != null;
//   }



}


 

    
    
//    @Override
//      protected void doPost(HttpServletRequest request, HttpServletResponse response)
//           throws ServletException, IOException {
//       try {
//            Class.forName("org.sqlite.JDBC");
//
//            Connection conn
//                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
//       
//    String firstName = request.getParameter("firstName");
//    String lastName = request.getParameter("lastName");
//    String email = request.getParameter("email");
//    String password = request.getParameter("password");
//    if (email != null) {
//               Statement upd = conn.createStatement();
//               upd.executeUpdate(
//                  "INSERT INTO PRODUCT (name, price) VALUES ('"+
//                           product+"', "+price+")");
//               upd.close();
//                String sql = "insert into USER (firstName,lastName,email,password) values(?,?,?,?)";
//                PreparedStatement updPrep = conn.prepareStatement(sql);
//                updPrep.setString(1, firstName);
//                updPrep.setString(2, lastName);
//                updPrep.setString(3, email);
//                updPrep.setString(4, password);
//                updPrep.executeUpdate();
//                System.out.println("Record is inserted into DBUSER table!");
//
//            }
//            
//   
//        } catch (Exception e) {
//            log("got an error:", e);
//
//        } finally {
//            out.close();
//        }
//       String url = "/login.jsp";
//       getServletContext().getRequestDispatcher(url).forward(request, response);
//    }
//    
//   @Override
//    protected void doGet(HttpServletRequest request,
//            HttpServletResponse response)
//            throws ServletException, IOException {
//
//        doPost(request, response);
//    }
//    
//    
//    
//   public static boolean emailExists(String email) {
//       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//   }
//
//    public static void update(User user) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//   public static void insert(User user) {
//       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
//}
