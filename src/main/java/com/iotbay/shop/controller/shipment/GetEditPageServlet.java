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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author simon
 */
@WebServlet(
        name = "GetEditPageServlet",
        urlPatterns = {"/GetEditPageServlet"})
public class GetEditPageServlet extends HttpServlet {

    private ShippingDao shippingDao = new ShippingDao();
    private UserDao userDao = new UserDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = (User) request.getSession().getAttribute("user");
        int shipmentDetailsId = -1;
        try {
            shipmentDetailsId = Integer.parseInt(request.getParameter("shipmentDetailsId"));
        }catch (Exception e) {
            System.out.println("hello");
        } 
        
        ShipmentDetails shipmentDetails = shippingDao.getShippingDetailsByShippingDetailsId(shipmentDetailsId);
        request.setAttribute("shipmenDetails", shipmentDetails);
        
        request.getRequestDispatcher("/edit_shipment_details.jsp").forward(request, response);
    }
    
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
