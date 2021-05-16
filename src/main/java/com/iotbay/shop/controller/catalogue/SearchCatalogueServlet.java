/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iotbay.shop.controller.catalogue;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author trees
 */

@WebServlet(
        name = "SearchCatalogueServlet",
        urlPatterns = {"/item/search"})
public class SearchCatalogueServlet extends HttpServlet{

    private ItemDao itemDao = new ItemDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, IOException {
                    System.out.println("we made it to search");
        String searchItem = request.getParameter("searchItem"); 
        List<Item> matchItems = itemDao.getItemsBySearchQuery(searchItem);
        System.out.println(matchItems.size());
                if(matchItems != null && matchItems.size() > 0){
                    request.setAttribute("searchItem", searchItem);
                    request.setAttribute("catalogue", matchItems );
                    System.out.println("got search results");
                }else{
                    request.setAttribute("noSearchResults", true);
                    System.out.println("no search results");
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
