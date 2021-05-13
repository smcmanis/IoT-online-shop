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

@WebServlet(
        name = "CancelAccountServlet",
        urlPatterns = {"/CancelAccountServlet"})
public class CancelAccountServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User existUser = userDao.getUserByUserEmail(user.getEmail());
        System.out.println(user.getEmail());

        try {
            if(existUser != null) {
                session.setAttribute("user", existUser);
                userDao.deleteUser(existUser);
                //session.setAttribute("cancel", "Cancelation was successful");
                request.getRequestDispatcher("main.jsp").include(request, response);
            } else {
                //session.setAttribute("cancel", "Cancelation was not successful");
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