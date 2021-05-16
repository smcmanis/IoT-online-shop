package com.iotbay.shop.controller.catalogue;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "CatalogueServlet",
        urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

    private ItemDao itemDao = new ItemDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
        
        System.out.println("we made it boys");
        List<Item> catalogue = itemDao.getAllItems();
        HttpSession session = request.getSession();
        String itemCategory = null;

        try{
            itemCategory = request.getParameter("itemCategory");
            System.out.println("got category");
        }catch(Exception e){}

        if(itemCategory != null){
            List<Item> categorisedItems = itemDao.getItemsByItemCategory(itemCategory);
            request.setAttribute("itemCategory", itemCategory);
            request.setAttribute("catalogue", categorisedItems);
            System.out.println("got category");
        }else{
                
                    request.setAttribute("catalogue", catalogue);
                    System.out.println("didnt got category");
            }            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp");
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