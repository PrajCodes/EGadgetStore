package prajna.data;

/**
 *
 * @author prajn
 */
import java.io.IOException;
import java.io.PrintWriter;


import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prajna.business.OrderProducts;
import prajna.business.Product;

//@WebServlet(name = "ProductIO",
//        urlPatterns = {"/selectproduct","/displayproducts"})
public class ProductIO extends HttpServlet {

//    private static List<Product> products; Doesnt seem to work 
    
     public static Product selectProduct(int productid) throws ClassNotFoundException, SQLException{
          
       
             Class.forName("org.sqlite.JDBC");
             
            Connection conn = DriverManager.getConnection("jdbc:sqlite:EstoreDatabase.db");
             PreparedStatement ps=conn.prepareStatement("select productid,description,price,name from PRODUCT WHERE productid="+productid);
             ResultSet rs = ps.executeQuery();
             Product product = new Product();
           while (rs.next()) 
           {
                    productid = rs.getInt("productid");//do null check 
                    String description = rs.getString("description");
                    Double price=rs.getDouble("price");
                    String name = rs.getString("name");
                    product = new Product(productid, description,price,name);

              }
           conn.close();
            return product;
            
     }
   

//    public static List<Product> selectProducts(string type) { //later if i add type of products
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   

    public ProductIO() {
    }
    

     
     
//     public static Product selectProduct(int productid){
//            Product selectedproduct = null;
//         try {
//             Class.forName("org.sqlite.JDBC");
//         } catch (ClassNotFoundException ex) {
//             Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
//         }
//                  
//            Connection conn;
//         try {
//             conn = DriverManager.getConnection("jdbc:sqlite:/db/EstoreDatabase.db");
//             PreparedStatement ps=conn.prepareStatement("select product from PRODUCT where productid=?");
//         } catch (SQLException ex) {
//             Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
//         }
//            
//          
//        
//    return selectedproduct;
//    } 

//    public static Product selectProduct(String productid) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
     public static void insert(Product product) {
      
      
      
   }
    }

      