/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.user;

import com.iotbay.shop.dao.UserDao;
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
 * @author hlong
 
 */
@WebServlet(
        name = "UpdateAccountServlet", 
        urlPatterns = {"/UpdateAccountServlet"})
public class UpdateAccountServlet extends HttpServlet {
    
    
    private  UserDao userDao = new UserDao();   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println("cunt");

        HttpSession session = request.getSession();
        String updatedEmail = request.getParameter("email");
        String updatedPassword = request.getParameter("password");
        String updatedFirstName = request.getParameter("first-name");
        String updatedLastName = request.getParameter("last-name");
        User user = userDao.getUserByUserEmail(updatedEmail);

        try {
            if(user != null) {
                session.setAttribute("user", user);
                user.setEmail(updatedEmail);
                user.setPasswordPlaintext(updatedPassword);
                user.setFirstName(updatedFirstName);
                user.setLastName(updatedLastName);
                userDao.updateUser(user);
                session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("editAccount.jsp").include(request, response);
            } else {
                session.setAttribute("updated", "Update was not successful");
                request.getRequestDispatcher("editAccount.jsp").include(request, response);
            }
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcome");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}