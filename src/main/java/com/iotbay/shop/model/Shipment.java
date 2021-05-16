
package com.iotbay.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author namlo
 */
@Entity
@Table(name = "shipment")

public class Shipment implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer shipment_id;
    
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "shipment_details_id")
    private ShipmentDetails shipment_details_id;
    
    private String tracking_number;
    
    private String shipment_date;
    
    private String shipment_status;

    public void setShipment_id(Integer shipment_id) {
        this.shipment_id = shipment_id;
    }

    public void setShipment_details_id(ShipmentDetails shipment_details_id) {
        this.shipment_details_id = shipment_details_id;
    }

    public ShipmentDetails getShipment_details_id() {
        return shipment_details_id;
    }

    public Integer getShipment_id() {
        return shipment_id;
    }

    public Order getOrder() {
        return order;
    }

    public User getUser() {
        return user;
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

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setUser(User user) {
        this.user = user;
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
    
}
