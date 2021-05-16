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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 *
 * @author trees
 */
@WebServlet(name = "UpdateItemServlet", urlPatterns = {"/updateItem"})
public class UpdateItemServlet extends HttpServlet{
    
    private UserService userService = new UserService();
    private ItemDao itemDao = new ItemDao();



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        

        if(userService.isUserEmployee(user)){
            String updateName = request.getParameter("item_name");
            String updateCategory = request.getParameter("category");
            Double updatePrice = Double.parseDouble(request.getParameter("price"));
            Integer updateQuantity = Integer.parseInt(request.getParameter("quantity"));

            Integer itemId = null;
            Item item = null;

            try{
                itemId = Integer.parseInt(request.getParameter("itemId"));
                item = itemDao.getItemByItemId(itemId);
            }catch(Exception e){
                e.getMessage();
            }


                try{
                if(item != null){
                    item.setName(updateName);
                    item.setCategory(updateCategory);
                    item.setPrice(new BigDecimal(updatePrice));
                    item.setQuantity(updateQuantity);
                    itemDao.updateItem(item);

                    request.setAttribute("item", item);
                    request.getRequestDispatcher("itemManagement").include(request, response);
                }
            }catch(Exception e){e.getMessage();}
        }else{
            session.setAttribute("noAccess", true);
        }
        request.getRequestDispatcher("/itemManagement.jsp").include(request, response);
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


