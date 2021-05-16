/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.service;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.Payment;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import javax.transaction.Transaction;

/**
 *
 * @author simon
 */
public class PaymentService {

    public Transaction processPayment(Payment payment, Order order, Cart cart, User customer) {
        // validate payment and return JTA transaction
        // UNSUPPORTED
        return null;
    }
    
}
