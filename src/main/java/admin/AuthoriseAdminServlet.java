/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.iotbay.shop.model.User;
import com.iotbay.shop.dao.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author simon
 */
@WebServlet(
        name = "AdminLogin",
        urlPatterns = {"/admin"}
)
public class AuthoriseAdminServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            user = userDao.getUserByUserId(user.getId());
            if (user.isAdmin()) {
                request.getRequestDispatcher("/adminHome.jsp").include(request, response);
            }
        } else {
            request.getRequestDispatcher("/adminLogin.jsp").include(request, response);
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
