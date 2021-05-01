package com.iotbay.shop.controller;

import com.iotbay.shop.model.User;
import com.iotbay.shop.service.*;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(
        name = "OrderListServlet",
        urlPatterns = {"/customer/orders"})
public class OrderListServlet extends HttpServlet {
    
    private OrderService orderService = new OrderService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        User user = (User) session.getAttribute("user");
        // Should check authentication here
//        if (user == null) {
        if (false) {
            dispatcher = request.getRequestDispatcher("/index.html");
        } else {
            List orders = (List) request.getAttribute("orders");
            if (orders == null) {     
                try {
                    orders = orderService.getOrders();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(OrderListServlet.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            session.setAttribute("orders", orders);
            dispatcher = request.getRequestDispatcher("/orderList.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
