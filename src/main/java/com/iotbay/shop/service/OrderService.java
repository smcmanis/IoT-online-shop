package com.iotbay.shop.service;

import com.iotbay.shop.dao.*;
import com.iotbay.shop.model.Order;
import java.sql.SQLException;
import java.util.List;


public class OrderService {
    
    private OrderDao orderDao = new OrderDao();
    private CartService cartService = new CartService();
           
    public List<Order> getOrders() throws ClassNotFoundException, SQLException {
        return orderDao.getOrders();
    }
    
   public Order getOrderByOrderId(Integer orderId) throws SQLException {
        return orderDao.getOrderByOrderId(orderId);
   } 
}
