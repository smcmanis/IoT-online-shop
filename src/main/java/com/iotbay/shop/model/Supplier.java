package com.iotbay.shop.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
        
@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "suppliername")
    private String supplierName;
    
    private String company;
    
    private String email;
    
    @OneToMany(mappedBy="supplier", fetch = FetchType.LAZY)
    private Set<Item> items;

    public Integer getId() {
        return id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    
}
