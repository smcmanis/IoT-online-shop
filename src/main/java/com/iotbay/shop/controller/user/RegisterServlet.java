/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.user;

import com.iotbay.shop.controller.Validator;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String registerEmail = request.getParameter("email");
        String registerPassword = request.getParameter("password");
        String registerFirstName = request.getParameter("first-name");
        String registerLastName = request.getParameter("last-name");
        
        validator.clear(session);
        
        if(!validator.validateEmail(registerEmail)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if(!validator.validatePassword(registerPassword)) {
            session.setAttribute("passErr", "Error: Pass format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
                        try {
                User exist = userDao.getUserByUserEmail(registerEmail);
                if(exist != null) {
                    session.setAttribute("existErr", "User already exists in the database");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    User user = new User();
                    user.setEmail(registerEmail);
                    user.setPasswordPlaintext(registerPassword);
                    user.setFirstName(registerFirstName);
                    user.setLastName(registerLastName);
                    userDao.addUser(user); 
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                }

            } catch(NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcome");
                request.getRequestDispatcher("register.jsp").include(request, response);
            }

        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
