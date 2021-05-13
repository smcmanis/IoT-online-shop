package com.iotbay.shop.controller;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "OrderListServlet",
        urlPatterns = {"/customer/orders"})
public class OrderListServlet extends HttpServlet {

    private OrderDao orderDao = new OrderDao();
    private UserDao userDao = new UserDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            // Redirect if user not logged in
            response.sendRedirect("/IoTBay/main.jsp");
        } else {
            User requestedUser = null;
            try {
                requestedUser = userDao.getUserByUserId(
                        Integer.parseInt(request.getParameter("userId")));
            } catch (NumberFormatException e) {
                System.out.println("Invalid requested userId");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (requestedUser == null) requestedUser = user;
            if (requestedUser != null) {
                if (user.getId().equals(requestedUser.getId())) {
                    request.setAttribute("customer", requestedUser);
                    request.setAttribute("customerOrders", requestedUser.getOrders());
                    request.getRequestDispatcher("/orderList.jsp").forward(request, response);
                    return;
                }
//                else { 
//                    // Check for user/admin priliges
//                    response.sendRedirect("/IoTBay/main.jsp");
//                }
            }

            response.sendRedirect("/IoTBay/main.jsp");
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
