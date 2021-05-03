package com.iotbay.shop.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String address;
    
    private String city;
    
    private String postcode;
    
    private String region;
    
    private String country;
    
    @Column(name = "isPrimary")
    private boolean primary;
    
    @OneToOne
    @JoinColumn(name="userId")
    private User user;
    

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public boolean isPrimary() {
        return primary;
    }
    
    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
    
}
