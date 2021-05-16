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
@WebServlet(name = "AddShipmentServlet", 
        urlPatterns = {"/addshipment"})
public class AddShipmentServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    private ShippingDao shipmentDao = new ShippingDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
                 
         if(user != null){
            String country = request.getParameter("country");
            String address = request.getParameter("address_line_1");
            int postcode = Integer.parseInt(request.getParameter("postcode"));
            String suburb = request.getParameter("suburb");
            String state = request.getParameter("state");
            
            ShipmentDetails shipment_details = new ShipmentDetails();
            shipment_details.setCountry(country);
            shipment_details.setAddress_line_1(address);
            shipment_details.setPostcode(postcode);
            shipment_details.setSuburb(suburb);
            shipment_details.setState(state);
            shipment_details.setUser(user);
            
            shipmentDao.addShipping(shipment_details);
            user.getShipmentDetails().add(shipment_details);
            session.setAttribute("shipment_details", shipment_details);
         }
            request.getRequestDispatcher("/shipmentdetails").include(request, response);
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
