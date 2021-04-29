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
public class Shipment implements Serializable {
    private int shipment_id; //PK
    private String tracking_number;
    private String shipment_date;
    private String shipment_status;
    private int shipment_details_id; //FK
    private int order_id; //FK    

    public Shipment(String tracking_number, String shipment_date, String shipment_status, int shipment_details_id, int order_id) {
        this.tracking_number = tracking_number;
        this.shipment_date = shipment_date;
        this.shipment_status = shipment_status;
        this.shipment_details_id = shipment_details_id;
        this.order_id = order_id;
    }

    public int getShipment_id() {
        return shipment_id;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public String getShipment_date() {
        return shipment_date;
    }

    public String getShipment_status() {
        return shipment_status;
    }

    public int getShipment_details_id() {
        return shipment_details_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setShipment_id(int shipment_id) {
        this.shipment_id = shipment_id;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public void setShipment_date(String shipment_date) {
        this.shipment_date = shipment_date;
    }

    public void setShipment_status(String shipment_status) {
        this.shipment_status = shipment_status;
    }

    public void setShipment_details_id(int shipment_details_id) {
        this.shipment_details_id = shipment_details_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }  
}
