package com.iotbay.shop.controller;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;

import java.io.IOException;
import java.util.List;
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

    private OrderDao orderDao = new OrderDao();
    private UserDao userDao = new UserDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
//        User user = (User) session.getAttribute("user");
//
//        // Should check authentication here
////        if (user == null) {
//        if (true) {
//            String userId = request.getParameter("userId");
//            if (userId != null) {
//                try {
//                    user = userDao.getUserByUserId(Integer.parseInt(userId));
//                } catch (NumberFormatException e) {
//                    // remove this after testing
//                    user = userDao.getUserByUserId(7);
//                }
//                session.setAttribute("user", user);
//            }
//
//        }
        User user = userDao.getUserByUserId(4);
        session.setAttribute("user", user);

        // If unauthorized: redirect
        if (false) {
            dispatcher = request.getRequestDispatcher("/index.html");
        } else {
            List<Order> orders = user.getOrders();
            System.out.println(orders.size());
            session.setAttribute("userOrders", orders);

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
