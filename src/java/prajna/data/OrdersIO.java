/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import prajna.business.Orders;
import prajna.business.User;

/**
 *
 * @author prajn
 */
public class OrdersIO {

    public static void insert(String ccid, String email) throws ClassNotFoundException, SQLException {
      
      Class.forName("org.sqlite.JDBC");
             
            Connection conn = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");

            
//if (orders != null) {
              //  int orderid =orders.getOrderid();
              System.out.println("Inside Orders IO");
                LocalDate date =LocalDate.now();
//                String ccid =orders.getCreditCardId();
//                String email = orders.getEmail();
                String sql = "insert into ORDERS (creditCardId,email) values(?,?)";
                PreparedStatement updPrep = conn.prepareStatement(sql);
                //updPrep.setInt(1, 2);
                //updPrep.setObject(1, date);
                updPrep.setString(1, ccid);
                updPrep.setString(2, email);
                updPrep.executeUpdate();
                System.out.println("Record is inserted into ORDER table!");          
      

  // } 

conn.close();
}
    
    
       public static void insertOrderProducts(int orderid,int productid,int quantity) throws ClassNotFoundException, SQLException {
      
      Class.forName("org.sqlite.JDBC");
             
            Connection conn = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");


                String sql = "insert into ORDERPRODUCTS (orderid,productid,quantity) values(?,?,?)";
                PreparedStatement updPrep = conn.prepareStatement(sql);
                updPrep.setInt(1, orderid);
                updPrep.setInt(2, productid);
               updPrep.setInt(3, quantity);
               updPrep.executeUpdate();
                System.out.println("Record is inserted into ORDERPRODUCTS table!");          
              

  // } 

conn.close();
}
    
    public static void ccInsert(String creditCardId, String cctype, String expirationMonth, String expirationYear, String userEmail ) throws ClassNotFoundException, SQLException {
      
      Class.forName("org.sqlite.JDBC");
   
            Connection conn = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
          
            
//if (creditCardId != null) {
              //  int orderid =orders.getOrderid();
              System.out.println("Inside ccInsert");
                String sql = "insert into CREDITCARD (creditCardId,cctype,expirationMonth,expirationYear,userEmail) values(?,?,?,?,?)";
                PreparedStatement updPrep = conn.prepareStatement(sql);
                updPrep.setString(1, creditCardId);
                updPrep.setString(2, cctype);
                updPrep.setString(3, expirationMonth);
                updPrep.setString(4, expirationYear);
                updPrep.setString(5, userEmail);
                updPrep.executeUpdate();
                System.out.println("Record is inserted into CreditCard table!");          
                

  // }  
conn.close();
    }

    public static int selectorderid(Orders order) throws SQLException {
    
            Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
            String sql = "SELECT * FROM ORDERS WHERE email ="+"\""+order.getEmail()+"\"";
            PreparedStatement updPrep = conn.prepareStatement(sql);
            ResultSet rs=updPrep.executeQuery();
       
            int orderid=rs.getInt("orderid");
           
             //To change body of generated methods, choose Tools | Templates.
        conn.close(); 
    return orderid;
    
    }

    public static int selectNoofOrders(String email) throws SQLException {
        Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
            String sql = "SELECT COUNT(*) AS nooforders FROM ORDERS WHERE email="+"\""+email+"\"";
            PreparedStatement updPrep = conn.prepareStatement(sql);
            ResultSet rs=updPrep.executeQuery();
       
            int nooforders=rs.getInt("nooforders");
           
             //To change body of generated methods, choose Tools | Templates.
        conn.close(); 
    return nooforders;
    }

    public static List<Orders> displayOrders(String email) throws SQLException {
     Connection conn
                    = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
            String sql = "SELECT * FROM ORDERS WHERE email="+"\""+email+"\"";
            PreparedStatement updPrep = conn.prepareStatement(sql);
            ResultSet rs=updPrep.executeQuery();
            List<Orders> orderlist=new ArrayList<Orders>();
            while(rs.next())
            {
            Orders order=new Orders();
            String creditCardId=rs.getString("creditCardId");
            int orderid=rs.getInt("orderid");
            order.setCreditCardId(creditCardId);
            order.setOrderid(orderid);
            order.setEmail(email);
            orderlist.add(order);
            }
             //To change body of generated methods, choose Tools | Templates.
           
        conn.close(); 
        return orderlist;
    }
    
    
    
    
}
