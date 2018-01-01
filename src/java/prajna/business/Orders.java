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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable{

    public static void insert(Orders order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public Orders(){
    
}
    public Orders(int orderid, List<OrderProducts> orderproducts, User user, LocalDate orderDate, boolean processed) {
        this.orderid = orderid;
        this.orderproducts = orderproducts;
        this.user = user;
        this.orderDate = orderDate;
        this.processed = processed;
    }
    private int orderid;
    public List<OrderProducts> orderproducts;
    private String  email;
    private LocalDate orderDate;
    private User user;
    private boolean processed;
    private String creditCardId;

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }
      

    public int getOrderid() {
        return orderid;
    }

    
    public User getUser() {
        return user;
    }
    public Orders(int orderid, List<OrderProducts> orderproducts, String email, LocalDate orderDate, boolean processed) {
        this.orderid = orderid;
        this.orderproducts = orderproducts;
        this.email = email;
        this.orderDate = orderDate;
        this.processed = processed;
        
    }

   
    
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public List<OrderProducts> getOrderproducts() {
        return orderproducts;
    }

    public void setOrderproducts(List<OrderProducts> orderproducts) {
        this.orderproducts = orderproducts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public void getOrderDate(LocalDate date) {
        this.orderDate=LocalDate.now(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setUser(User user) {
        this.user=user; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
  
}
