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

public class CreditCard implements Serializable {
   private String creditCardId;
   private String cctype;
   private String expirationMonth;
   private String expirationYear;
   private  String userEmail;
   private String expirationDate;
 public CreditCard() {}
  public CreditCard(String creditCardId, String cctype, String expirationMonth, String expirationYear, String userEmail ) {
      this.creditCardId = creditCardId;
      this.cctype = cctype;
      this.expirationMonth = expirationMonth;
      this.expirationYear = expirationYear;
      this.userEmail = userEmail;
  } 
   public String getCreditCardId() {
      return creditCardId;
   }

   public String getCctype() {
      return cctype;
   }

   public String getExpirationMonth() {
      return expirationMonth;
   }
   
   public String getExpirationYear() {
      return expirationYear;
   }

    /**
     *
     * @param creditCardId
     */
    public void setCreditCardId(String creditCardId) {
      this.creditCardId = creditCardId;
   }

   public void setCctype(String cctype) {
      this.cctype = cctype;
   }

   public void setExpirationMonth(String expirationMonth) {
      this.expirationMonth = expirationMonth;
   }
   
   public void setExpirationYear(String expirationYear) {
      this.expirationYear = expirationYear;
   }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public boolean isEmpty() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setExpirationDate(String string) {
     this.expirationDate = expirationDate;//To change body of generated methods, choose Tools | Templates.
    }
   
}

