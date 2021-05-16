package com.iotbay.shop.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private boolean isPrimary;
    
    @ManyToOne()
    @JoinColumn(name="userId")
    private User user;
    
    private String cardNumber;
    
    private String expirationMonth;
    
    private String expirationYear;
    
    private String cardOwner;
    
    private String cardVerificationValue;

    public Integer getId() {
        return id;
    }

    public boolean isIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public String getCardVerificationValue() {
        return cardVerificationValue;
    }

    public void setCardVerificationValue(String cardVerificationValue) {
        this.cardVerificationValue = cardVerificationValue;
    }

    
}
