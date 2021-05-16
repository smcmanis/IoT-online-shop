/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.shipment;

import com.iotbay.shop.dao.ShippingDao;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.ShipmentDetails;
import com.iotbay.shop.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author namlo
 */
@WebServlet(
        name = "ShipmentDetailServlet",
        urlPatterns = {"/ShipmentDetailServlet"})
public class ShipmentDetailsServlet extends HttpServlet {
    private ShippingDao shippingDao = new ShippingDao();
    private UserDao userDao = new UserDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        User user = (User) session.getAttribute("user");
        
        if (true) {
            String userId = request.getParameter("userId");
            if (userId != null) {
                try {
                    user = userDao.getUserByUserId(Integer.parseInt(userId));
                } catch (NumberFormatException e) {
                    // remove this after testing
                    user = userDao.getUserByUserId(7);
                }
                session.setAttribute("user", user);
            }
        }
        session.setAttribute("user", user);
        
        if (false) {
            dispatcher = request.getRequestDispatcher("/index.jsp");
        } else {
            List<ShipmentDetails> shipmentDetails = user.getShipmentDetails();
            System.out.println(shipmentDetails.size());
            session.setAttribute("shipmentDetails", shipmentDetails);

            dispatcher = request.getRequestDispatcher("shipmentdetails.jsp");
            dispatcher.forward(request, response);
        }
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
