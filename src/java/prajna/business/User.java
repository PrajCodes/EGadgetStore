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
import prajna.business.CreditCard;

public class User implements Serializable {
    private int userid;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    //private CreditCard creditCard;

    /**
     *
     */
    public User() {
      userid = 0;
      firstName = "";
      lastName = "";
      password = "";
      email = "";
      
    }
    
    public User(String firstName, String lastName, String email, String password){
     this.firstName = firstName;
     this.lastName = lastName;
     this.email = email;
     this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     CreditCard creditCard;
    public CreditCard getCreditCard() {
      return creditCard;
 }
    
  public void setCreditCard(CreditCard creditCard) {
     this.creditCard = creditCard;
 }
  }


