/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.model;

import java.io.Serializable;

/**
 *
 * @author namlo
 */
public class Shipment_Details implements Serializable {
    private int shipment_details_id;
    private String country;
    private String address_line_1;
    private String address_line_2;
    private int postcode;
    private String suburb;
    private String state;   
    
    public Shipment_Details(String country, String address_line_1, String address_line_2, int postcode, String suburb, String state){
        this.country = country;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.postcode = postcode;
        this.suburb = suburb;
        this.state = state;
    }

    public int getShipment_details_id() {
        return shipment_details_id;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
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

    public void setShipment_details_id(int shipment_details_id) {
        this.shipment_details_id = shipment_details_id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
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
