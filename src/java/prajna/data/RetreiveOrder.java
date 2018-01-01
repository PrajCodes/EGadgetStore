/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prajna.business.Orders;
import prajna.business.Product;

/**
 *
 * @author prajn
 */
public class RetreiveOrder extends HttpServlet {
    
@Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       String url = "/vieworder.jsp";
    try {
        
        HttpSession session = request.getSession();
        String creditCardnumber = request.getParameter("creditCardId");
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
        
        
        String sql1 = "SELECT productid FROM ORDERPRODUCTS WHERE orderid ="+"\""+orderid+"\"";
        PreparedStatement updPrep1 = conn.prepareStatement(sql1);
        ResultSet rs1=updPrep1.executeQuery();
        
        int i=0;
        int[] productidarray= new int[10];
        while(rs1.next())
        {
            
            int productid=rs1.getInt("productid");
            productidarray[i]=productid; 
            i=i+1;
        }   
       List<Product> productlist=new ArrayList<Product>();     
          for(int j=0;j<productidarray.length;j++)  
          {
            String sql2 = "SELECT * FROM PRODUCT WHERE productid ="+"\""+productidarray[j]+"\"";  
            PreparedStatement updPrep2 = conn.prepareStatement(sql2);
            ResultSet rs2=updPrep2.executeQuery();
            
            while(rs2.next()){
                
                String name=rs2.getString("name");
                String type=rs2.getString("type");
                Double price=rs2.getDouble("price");
                String description=rs2.getString("description");
                
                System.out.println(name);
                Product product=new Product();
                product.setName(name);
                
                product.setPrice(price);
                product.setDescription(description);
                productlist.add(product);
            }
            System.out.println(productlist);
          }
        session.setAttribute("productlist", productlist);
    
     conn.close(); 
    } catch (SQLException ex) {
        Logger.getLogger(RetreiveOrder.class.getName()).log(Level.SEVERE, null, ex);
    }
          
              
             //To change body of generated methods, choose Tools | Templates.
           
          

   
    
    getServletContext().getRequestDispatcher(url).forward(request, response);
   }
   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
   
   
   
   
   
 }
