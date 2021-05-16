/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.admin;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trees
 */
@WebServlet(
        name = "AdminDeleteServlet",
        urlPatterns = {"/AdminDeleteServlet"}
)
public class AdminDeleteServlet extends HttpServlet {

    private UserDao userDao = new UserDao();
    private OrderDao orderDao = new OrderDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer theId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.getUserByUserId(theId);
        List<Order> orders = user.getOrders();
        for (Order order : orders) {
            if (order.getUser().getId() == user.getId()) {
                order.setUser(null);
                orderDao.updateOrder(order);
            }

        }

        userDao.deleteUser(user);
        request.getRequestDispatcher("cim").include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
