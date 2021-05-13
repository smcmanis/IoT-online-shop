 package com.iotbay.shop.controller.user;

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
 * @author hlong
 */
@WebServlet(
        name = "EditAccountServlet",
        urlPatterns = {"/editAccount"})
public class EditAccountServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        User user = userDao.getUserByUserEmail(email);

        try {
            if(user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("editAccount.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the database");
                request.getRequestDispatcher("editAccount.jsp").include(request, response);
            }
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist" : "Welcome");
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