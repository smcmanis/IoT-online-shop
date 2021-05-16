package com.iotbay.shop.model;

import java.io.Serializable;
import java.util.List;
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
    
    @Column(name = "address")
    private String address;

    @Column(name = "isActive")
    private boolean active;

    @Column(name = "isAdmin")
    private boolean admin;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ShipmentDetails> shipmentDetails;
    
    private String customerType;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Address> shippingAddresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;

    @OneToMany(mappedBy = "user")
    @OrderBy("orderTimestamp desc")
    private List<Order> orders;
    
    @OneToMany(mappedBy = "user")
    private List<Payment> payments;
       
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

        public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<ShipmentDetails> getShipmentDetails() {
        return shipmentDetails;
    }

    public void setShippingDetails(List<ShipmentDetails> shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }
    
}
