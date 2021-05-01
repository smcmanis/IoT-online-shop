/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.CartService;
import com.iotbay.shop.service.OrderService;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "OrderServlet",
        urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

    private OrderService orderService = new OrderService();
    private CartService cartService = new CartService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        Integer orderId = Integer.parseInt(request.getParameter("orderId"));
        try {
            // Would normally need to check user has permission
            Order order = orderService.getOrderByOrderId(orderId);
            request.setAttribute("order", order);
        } catch (SQLException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispatcher = request.getRequestDispatcher("/order.jsp");
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
