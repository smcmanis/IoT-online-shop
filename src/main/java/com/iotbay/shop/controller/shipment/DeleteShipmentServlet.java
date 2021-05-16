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
        name = "DeleteShipmentServlet",
        urlPatterns = {"/DeleteShipmentServlet"})
public class DeleteShipmentServlet extends HttpServlet {
    private ShippingDao shippingDao = new ShippingDao();
    private UserDao userDao = new UserDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer shipmentDetailsId = null;
        try {
            shipmentDetailsId = Integer.parseInt(request.getParameter("shipmentDetailsId"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         if (user != null && shipmentDetailsId != null) {
            ShipmentDetails shipmentToRemove = null;
            List<ShipmentDetails> userShipmentDetails = user.getShipmentDetails();
            for (ShipmentDetails userShipmentDetail : userShipmentDetails) {
                if (userShipmentDetail.getShipment_details_id() == shipmentDetailsId) {
                    shipmentToRemove = userShipmentDetail;                    
                }
            }           
            if (shipmentToRemove != null) {
                user.getShipmentDetails().remove(shipmentToRemove);
                userDao.updateUser(user);
            }
            
        }
        request.getRequestDispatcher("/shipmentdetails").forward(request, response);
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
