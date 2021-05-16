package com.iotbay.shop.controller.admin;

import com.iotbay.shop.model.User;
import com.iotbay.shop.dao.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author simon
 */
@WebServlet(
        name = "AuthoriseAdmin",
        urlPatterns = {"/admin/login"}
)
public class AuthoriseAdminServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userDao.getUserByUserEmail(email);
        if (user != null && user.isAdmin()) {
            if (password.equals(user.getPasswordPlaintext())) {
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/adminHome.jsp").include(request, response);
            }
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
