package com.iotbay.shop.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryService {
    
    private static EntityManagerFactory emf;
    
    EntityManagerFactoryService() {}
    
//    public static synchronized EntityManagerFactory getInstance() {
//        if (emf == null) {
//            emf = Persistence.createEntityManagerFactory("iotbayPU");
//        }
//
//        return emf;
//    }
//    
    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("iotbayPU");
        }

        return emf;
    }
}
