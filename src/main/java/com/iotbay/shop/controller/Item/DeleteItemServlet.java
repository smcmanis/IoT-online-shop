/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iotbay.shop.controller.Item;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.service.UserService;
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
    name = "DeleteItemServlet",
    urlPatterns={"/deleteItem"}
)
public class DeleteItemServlet extends HttpServlet{
   private UserService userService = new UserService();
   private ItemDao itemDao = new ItemDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(userService.isUserEmployee(user)){
            try {

            Item item = itemDao.getItemByItemId(Integer.parseInt(request.getParameter("itemId"))); 

            if(item != null) {
                itemDao.deleteItem(item);   
            }
        } catch(Exception e) {e.getMessage();}
        }else{
            session.setAttribute("noAccess", true);
        }
        request.getRequestDispatcher("itemManagement").include(request, response);
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
