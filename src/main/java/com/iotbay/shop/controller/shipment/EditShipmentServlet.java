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
import javax.servlet.http.HttpSession;

/**
 *
 * @author namlo
 */
@WebServlet(
        name = "EditShipmentServlet",
        urlPatterns = {"/EditShipmentServlet"})
public class EditShipmentServlet extends HttpServlet {

    private ShippingDao shippingDao = new ShippingDao();
    private UserDao userDao = new UserDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Oi m8");
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("user");
        int shipmentDetailsId = -1;
        try {
            shipmentDetailsId = Integer.parseInt(request.getParameter("shipmentDetailsId"));
        } catch (Exception e) {

        }
        String country = request.getParameter("country");
        String address = request.getParameter("address_line_1");
        int postcode = Integer.parseInt(request.getParameter("postcode"));
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");

        try {
            for (ShipmentDetails shipmentDetails : user.getShipmentDetails()) {
                if (shipmentDetails.getShipment_details_id() == shipmentDetailsId) {
                    shipmentDetails.setAddress_line_1(address);
                    shipmentDetails.setCountry(country);
                    shipmentDetails.setPostcode(postcode);
                    shipmentDetails.setState(state);
                    shipmentDetails.setSuburb(suburb);
                    shippingDao.updateShipping(shipmentDetails);
                }
            }
            

//            
//            if(shipmentDetailsToUpdate != null && user != null){
////                 session.setAttribute("shipment_details", shipment_details);
//                 shipmentDetailsToUpdate.setAddress_line_1(address);
//                 shipmentDetailsToUpdate.setCountry(country);
//                 shipmentDetailsToUpdate.setPostcode(postcode);
//                 shipmentDetailsToUpdate.setState(state);
//                 shipmentDetailsToUpdate.setSuburb(suburb);
//                 user.getShipmentDetails().
//                 userDao.updateUser(user);
//                 session.setAttribute("updated", "Update was successful");
            request.getRequestDispatcher("/shipment.jsp").include(request, response);
        }
        catch (Exception e) {
                 session.setAttribute("updated", "Update was not successful");
                 System.out.println("no update");
                 request.getRequestDispatcher("/ShipmentDetailServlet").include(request, response);
            }
    }
//    catch(NullPointerException ex
//
//    
//        ) {
//            System.out.println("hello");
//        System.out.println(ex.getMessage() == null ? "Shipment does not exist" : "Found!");
//    }
//}

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
