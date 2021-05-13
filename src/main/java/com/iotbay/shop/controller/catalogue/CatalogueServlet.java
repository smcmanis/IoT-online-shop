package com.iotbay.shop.controller.catalogue;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;
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
        name = "CatalogueServlet",
        urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

    private ItemDao itemDao = new ItemDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> catalogue = itemDao.getAllItems();
        HttpSession session = request.getSession();
        session.setAttribute("catalogue", catalogue);

        String itemCategory = request.getParameter("itemCategory");
        
        System.out.println(request.getSession().getServletContext());
//        Item item = itemDao.getItemByItemCategory(itemCategory);

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
