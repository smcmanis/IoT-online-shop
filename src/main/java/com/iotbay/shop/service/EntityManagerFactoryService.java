package com.iotbay.shop.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class EntityManagerFactoryService {
    
    @PersistenceUnit
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("iotbayPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
