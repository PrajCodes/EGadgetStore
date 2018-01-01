/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.data;

/**
 *
 * @author prajn
 */
import java.util.List;
import prajna.business.Orders;
import prajna.business.Cart;
public class CartIO {
    
    public static void update(Orders orders) {
    }
    
    public static List<Orders> selectInvoices() {
     
      String queryString = "SELECT i FROM Orders i";
      

      List<Orders> orders = null;

      try {
         //orders = queryString.getResultSet();
      } catch (Exception e) {
         System.err.println(e);
      } finally {
        // em.close();
      }

      return orders;
   }

    /**
     *
     * @param Orderid
     * @return
     */
    public static Orders select(int Orderid) {
      
      Orders orders = null;

     
      return orders;
   }
    
}
