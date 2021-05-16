/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.admin;

import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "AdminEditServlet",
        urlPatterns = {"/AdminEditServlet"})
public class AdminEditServlet extends HttpServlet {
    
    private UserDao userDao = new UserDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cimedit.jsp");
        dispatcher.forward(request, response);
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.getUserByUserId(userId);
        request.setAttribute("user", user);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Update user details
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.getUserByUserId(userId);
        String updatedEmail = request.getParameter("email");
        String updatedPassword = request.getParameter("password");
        String updatedFirstName = request.getParameter("first-name");
        String updatedLastName = request.getParameter("last-name");
        String updateStatus = request.getParameter("customerstatus");
        // Validation
        
        user.setEmail(updatedEmail);
        user.setPasswordPlaintext(updatedPassword);
        user.setFirstName(updatedFirstName);
        user.setLastName(updatedLastName);
        if(updateStatus.equals("Active")){
            user.setActive(true);
        } 
        if(updateStatus.equals("Deactive")){
            user.setActive(false);
        }
        userDao.updateUser(user);
        request.setAttribute("user", user);
        request.getRequestDispatcher("cimedit.jsp").include(request, response);
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}