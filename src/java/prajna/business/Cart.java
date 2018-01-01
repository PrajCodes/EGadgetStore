/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prajna.business;

/**
 *
 * @author prajn
 */
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cart implements Serializable {

    private ArrayList<OrderProducts> products;
    public Cart() {
        products = new ArrayList<OrderProducts>();
    }

    public ArrayList<OrderProducts> getProducts() {
        return products;
    }

    public int getCount() {
        return products.size();
    }
    
    public double getTotalPrice() {
      double total = 0.0;
      for (OrderProducts i : products) {
       total=total+i.getTotalPrice();  
      }

      return total;
   }
    
    public String getTotalPriceCurrencyFormat() {
      NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
      double totalPrice = getTotalPrice();
      return currencyFormat.format(totalPrice);
   }
    
    public void addProduct(OrderProducts item) {
        int ProductID = item.getProduct().getProductid();
        int quantity = item.getQuantity();
        for (OrderProducts cartItem : products) {
            if ((ProductID)==cartItem.getProduct().getProductid()) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        products.add(item);
    }
    
    public void removeProduct(OrderProducts item) {
        int productid = item.getProduct().getProductid();
        for (int i = 0; i < products.size(); i++) {
            OrderProducts lineItem = products.get(i);

                if (products.get(i).getProduct().getProductid()==productid) {
            products.remove(i);
            return;
            }
        }
        
    }
}
