package com.iotbay.shop.controller;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.*;
import com.iotbay.shop.service.*;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


// Create new order
@WebServlet(
        name = "OrderServlet",
        urlPatterns = {"/orders"})
public class OrderServlet extends HttpServlet {

    private OrderDao orderDao;
    private CartService cartService;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        orderDao.getOrders();
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/orders.jsp");
        dispatcher.forward(request, response);
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
