package com.iotbay.shop.controller.user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.UserService;
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
        name = "LoginServlet",
        urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserDao();
    private UserService userService = new UserService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        String password = request.getParameter("password");
        User user = userDao.getUserByUserEmail(email);
        System.out.println(user == null);
        try {
            if(user != null && user.isActive()) {
                if(password.equals(user.getPasswordPlaintext())) {
                    boolean isEmployee = userService.isUserEmployee(user);
   
                    session.setAttribute("isEmployee", isEmployee);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                } else {
                    session.setAttribute("passErr", "Error: Password format incorrect");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            } else if (user != null) {
                session.setAttribute("inActiveErr", "Error: User account is deactivated");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the database");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcome");
        } 
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
