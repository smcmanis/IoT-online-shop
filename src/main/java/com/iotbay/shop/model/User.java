package com.iotbay.shop.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    @Column(name = "passwordplaintext")
    private String passwordPlaintext;

    private String passhash;

    private String salt;

    @Column(name = "isActive")
    private boolean active;

    @Column(name = "isAdmin")
    private boolean admin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Address> shippingAddresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<CreditCard> creditCards;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;
    
    public Integer getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordPlaintext() {
        return passwordPlaintext;
    }

    public void setPasswordPlaintext(String passwordPlaintext) {
        this.passwordPlaintext = passwordPlaintext;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Set<Address> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(Set<Address> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    
    
}
