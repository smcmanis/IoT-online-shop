package com.iotbay.shop.controller.catalogue;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.service.UserService;
import com.iotbay.shop.model.User;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "ItemManagementServlet",
        urlPatterns = {"/itemManagement"})

public class ItemManagementServlet extends HttpServlet {
    private UserService userService = new UserService();
    private ItemDao itemDao = new ItemDao();
    

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(userService.isUserEmployee(user)){
            List<Item> itemList = itemDao.getAllItems();
        
            request.setAttribute("itemList", itemList);
        }else{
            session.setAttribute("noAccess", true);
        }
        


        RequestDispatcher dispatcher = request.getRequestDispatcher("/itemManagement.jsp");
        dispatcher.forward(request, response);
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