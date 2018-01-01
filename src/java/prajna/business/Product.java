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

public class Product implements Serializable {

    public int productid;
    private String description;
    public double price;
    public String name;
    
    public Product() {
     productid=0;
     description="";
     price=0.0;
     name="";
    }
    
    public Product(int productid, String description, double price, String name){
     this.productid = productid;
     this.description = description;
     this.price = price;
     this.name = name;
     
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String type;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    

    public void setProductid(int productid) {
        this.productid = productid;
    }
    
    public String getImageUrl(int productid) {
      return "img/" + productid + "_Cover.jpg";
   }
    /**
     *
     * @return
     */
    public int getProductid() {
        return productid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
