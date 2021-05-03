package com.iotbay.shop.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "access_logs")
public class AccessLog implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")    
    private User user;
    
    private Timestamp accessTimestamp;

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getAccessTimestamp() {
        return accessTimestamp;
    }

    public void setAccessTimestamp(Timestamp accessTimestamp) {
        this.accessTimestamp = accessTimestamp;
    }
    
    
}
