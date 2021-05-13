package com.iotbay.shop.controller.Item;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "ItemServlet",
        urlPatterns = {"/item"})
public class ItemServlet extends HttpServlet {

    private ItemDao itemDao = new ItemDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer itemId = Integer.parseInt(request.getParameter("itemId"));
        Item item = itemDao.getItemByItemId(itemId);

        request.setAttribute("item", item);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/item.jsp");
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
