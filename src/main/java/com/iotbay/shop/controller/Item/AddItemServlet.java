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
import java.math.BigDecimal;

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
@WebServlet(name = "AddItemServlet", urlPatterns = {"/addItem"})
public class AddItemServlet extends HttpServlet {
    private ItemDao itemDao = new ItemDao();
    private UserService userService = new UserService();

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(userService.isUserEmployee(user)){
            String addName = request.getParameter("item_name");
            String addCategory = request.getParameter("category");
            Double addPrice = Double.parseDouble(request.getParameter("price"));
            Integer addQuantity = Integer.parseInt(request.getParameter("quantity"));

            Item item = new Item();
            item.setName(addName);
            item.setCategory(addCategory);
            item.setPrice(new BigDecimal(addPrice));
            item.setQuantity(addQuantity);

            itemDao.addItem(item); 

            session.setAttribute("item", item);
        }else{
            session.setAttribute("noAccess", true);
        }
        request.getRequestDispatcher("itemManagement").include(request, response);
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