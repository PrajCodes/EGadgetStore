/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.controllerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prajna.business.Product;
import prajna.data.ProductIO;

/**
 *
 * @author prajn
 */
public class ProductDetails extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri=request.getRequestURI();
        String url="/productdetails.jsp";
       
          
            url = "/productdetails.jsp";
            Product product;
            try {
                url = showProduct(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProductDetails.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProductDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
     
       getServletContext().getRequestDispatcher(url).forward(request, response);  
     }


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    private String showProduct(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
       int productid=Integer.parseInt(request.getParameter("productid"));
       Product product=new Product();
       product = ProductIO.selectProduct(productid);
       HttpSession session = request.getSession();
        session.setAttribute("product", product);
       
       return "/productdetails.jsp";
    }

   

}

 
