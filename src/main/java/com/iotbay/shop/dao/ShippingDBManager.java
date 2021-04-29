/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.dao;

import com.iotbay.shop.model.Shipment;
import com.iotbay.shop.model.Shipment_Details;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author namlo
 */
public class ShippingDBManager {
    
    private Statement st;
    
    public ShippingDBManager(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    //shipment manager
    // find shipment by id and datee
    public Shipment findShipment(int id, String date) throws SQLException {
        String fetch = "select * from shipment where shipment_id =" + id + "and shipment_date ='" +  date + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            int shipmentID = rs.getInt(1);
            String shipmentDate = rs.getString(3);
            if(shipmentID == id && shipmentDate.equals(date)){
                String trackingNumber = rs.getString(2);
                String shipmentStatus = rs.getString(4);
                int shipmentDetailsID = rs.getInt(5);
                int orderID = rs.getInt(6);
                Shipment shipment = new Shipment(trackingNumber, shipmentDate, shipmentStatus, shipmentDetailsID, orderID);
                shipment.setShipment_id(id);
                return shipment;
            }
        }
        return null;
    }
    
    //shipment_details manager
    //Fk of shipment that stores shipment_details_id
    public Shipment_Details findShipment_Details(int id) throws SQLException {
        String fetch = "select * from shipment_detalks where shipment_details_id =" + id ;
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            int shipmentDetailsID = rs.getInt(1);
            if(shipmentDetailsID == id){
                String country = rs.getString(2);
                String address_1 = rs.getString(3);
                String address_2 = rs.getString(4);
                int zipcode = rs.getInt(5);
                String suburb = rs.getString(6);
                String state = rs.getString(7);
                Shipment_Details shipmentDetails = new Shipment_Details(country, address_1, address_2, zipcode, suburb, state);
                return shipmentDetails;
            }
        }
        return null;
    }   
    
    //shipment details manager
    //add shipment details 
    public void addShipmentDetails(String country, String address_1, String address_2, int zipcode, String suburb, String state, int userID) throws SQLException {
        st.executeUpdate("INSERT INTO shipment_details (country, address_line_1, address_line_2, postcode, suburb, state, user_id) "
                + "VALUES ('" + country + "', '" + address_1 + "', '" + address_2 + "', '" + zipcode + "', '" + suburb + "', '" + state + "', '" + userID + ")");
    }
    
    //shipment details manager
    //delete shipment detals
    public void deleteShipmentDetails(int shipmentDetailsID) throws SQLException {
        st.executeUpdate("DELETE FROM shipment_details WHERE shipment_details_id = " + shipmentDetailsID);
    }
    
    //shipment details manager
    //update a shipment detail
    public void updateShipmentDetails(int shipmentDetailsID, String country, String address_1, String address_2, int zipcode, String suburb, String state) throws SQLException{
        st.executeUpdate("UPDATE shipment_details SET country = '" + country + "', address_line_1 = " + address_1 + "', address_line_2 = '" + address_2 + "', postcode = '" + zipcode + "', suburb = '" + suburb + "', state = '" + state + "WHERE shipment_details_id = " + shipmentDetailsID);
    }
    
    //shipment details manager
    //read all shipment details from a user
    public ArrayList<Shipment_Details> fectShipmentDetails(int id) throws SQLException {
        String fetch = "SELECT * FROM shipment_details WHERE user_id = " + id;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Shipment_Details> temp = new ArrayList();
        
        while(rs.next()){
            if(id == rs.getInt(8)){
                int shipmentDetailsID = rs.getInt(1);
                String country = rs.getString(2);
                String address_1 = rs.getString(3);
                String address_2 = rs.getString(4);
                int zipcode = rs.getInt(5);
                String suburb = rs.getString(6);
                String state = rs.getString(7);
                Shipment_Details shipmentDetails = new Shipment_Details(country, address_1, address_2, zipcode, suburb, state);
                shipmentDetails.setShipment_details_id(shipmentDetailsID);
                temp.add(shipmentDetails);
            }       
        }
        if(!temp.isEmpty()){
            return temp;
        }
        else {
            return null;
        }
    }
    
    //shipment manager
    //read all shipments from a user
   public ArrayList<Shipment> fectShipment(int id) throws SQLException{
       String fetch = "SELECT shipment_id, tracking_number, shipment_date, shipment_status, shipment_details_id FROM shipment WHERE shipment.shipment_details_id = shipment_details.shipment_details_id AND shipment_details.user_id = " + id;
       ResultSet rs = st.executeQuery(fetch);
       ArrayList<Shipment> temp = new ArrayList();
       
       while(rs.next()){
           int shipment_id = rs.getInt(1);
           String tracking_no = rs.getString(2);
           String shipment_date = rs.getString(3);
           String shipment_status = rs.getString(4);
           int shipment_details_id = rs.getInt(5);
           int order_id = rs.getInt(6);
            Shipment shipment = new Shipment(tracking_no, shipment_date, shipment_status, shipment_details_id, order_id);
            shipment.setShipment_id(shipment_id);
            temp.add(shipment);
       }
       if(!temp.isEmpty()){
            return temp;
        }
        else {
            return null;
        }
   }
}
