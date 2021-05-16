/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.shipment;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author namlo
 */

public class FindShipmentServlet extends HttpServlet {

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
//       HttpSession session = request.getSession();
//       int shipment_id = Integer.parseInt(request.getParameter("shipment_id"));
//       String shipment_date = request.getParameter("shipment_date");
//       ShipmentDBManager manager = (ShipmentDBManager) session.getAttribute("shipmentManager");
//       
//       Shipment1 shipment = null;
//       session.setAttribute ("shipment", null);
//       session.setAttribute("searchErr", null);
//           try {
//               shipment = manager.findShipment(shipment_id,shipment_date);
//               if (shipment != null) {
//                   session.setAttribute("shipment", shipment);
//                   ShipmentDetails1 shipmentDet = manager.findShipmentDetails(shipment.getShipment_details_id());
//                   session.setAttribute("shipmentDet", shipmentDet);
//                   request.getRequestDispatcher("shipment.jsp").include(request, response);
//                   
//               } else {
//                   session.setAttribute("searchErr", "Shipment does not exist in the Database! Please try again.");
//                   request.getRequestDispatcher("shipment.jsp").include(request, response);
//               }
//           } catch (SQLException ex) {
//               Logger.getLogger(FindShipmentServlet.class.getName()).log(Level.SEVERE, null, ex);
//           }
       
   }
}
