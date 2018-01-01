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
import java.util.List;

public class OrderProducts implements Serializable {

    private Product product;
    private int quantity=1;
    private double totalPrice;
    
    public OrderProducts() {
    }

    public void setProduct(Product p) {
        product = p;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        double total = product.getPrice() * quantity;
        return total;
    }
    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }

    public double getTotalPrice() {
      return product.getPrice() * quantity;
      
   } 

    public void setProduct(List<Product> product) {
        throw new UnsupportedOperationException("Not supported yet."); //change this and try if order works 
    }
}