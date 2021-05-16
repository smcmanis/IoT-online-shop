/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author namlo
 */
@Entity
@Table(name = "shipment_details")

public class ShipmentDetails implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int shipment_details_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    private String country;
    private String address_line_1;
    private int postcode;
    private String suburb;
    private String state;

    public int getShipment_details_id() {
        return shipment_details_id;
    }

    public User getUser() {
        return user;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getState() {
        return state;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
