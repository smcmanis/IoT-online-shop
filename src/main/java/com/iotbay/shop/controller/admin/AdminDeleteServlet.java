/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iotbay.shop.controller.admin;

import com.iotbay.shop.dao.UserDao;
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
 * @author trees
 */

@WebServlet(
    name = "AdminDeleteServlet",
    urlPatterns={"/AdminDeleteServlet"}
)
public class AdminDeleteServlet extends HttpServlet{

   private UserDao userDao = new UserDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Integer theId = Integer.parseInt(request.getParameter("userId"));
            User user = userDao.getUserByUserId(theId); 

            if(user != null) {
                userDao.deleteUser(user);
                
                request.getRequestDispatcher("cim").include(request, response);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage() == null ? "Item does not exist" : "Welcome");
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