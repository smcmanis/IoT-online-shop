/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.order;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "CustomerOrderSearchServlet",
        urlPatterns = {"/customer/order/search"})
public class CustomerOrderSearchServlet extends HttpServlet {

    private OrderDao orderDao = new OrderDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQeury = request.getParameter("searchOrderId");
        User user = (User) request.getSession().getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("/IoTBay/login.jsp");
        } else {
            try {
                Integer orderId = Integer.parseInt(searchQeury);
                Order order = orderDao.getOrderByOrderId(orderId);
                if (order != null && order.getUser().getId().equals(user.getId())){
                    System.out.println(order.getId());
                    request.setAttribute("order", order);
                    request.setAttribute("customer", user);
                    request.getRequestDispatcher("/order.jsp").forward(request, response);
                } else {
                    request.setAttribute("noSearchResults", true);
                    request.getRequestDispatcher("/customer/order/list").forward(request, response);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                response.sendRedirect("/IoTBay/main.jsp");
            }
            // can't be bothered to figiure this part out
            
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
