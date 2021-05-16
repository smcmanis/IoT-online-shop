
import java.util.*;
import com.iotbay.shop.controller.Validator;
import com.iotbay.shop.model.User;
import com.iotbay.shop.dao.UserDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(
        name = "CustomerManagamentUserServlet",
        urlPatterns = {"/cim"})
public class CustomerManagementServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cim.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        Validator validator = new Validator();
        //show information users
        List<User> users = userDao.getAllUsers();
        session.setAttribute("users", users);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = searchUsers(request);
        request.setAttribute("users", users);
        processRequest(request, response);
    }
    
    private List<User> searchUsers(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String typeAccount = request.getParameter("customertype"); 
        if(typeAccount.equals("None")){
            List<User> users = userDao.getAllCustomers(firstName, lastName);
            return users;
        } else {
            List<User> users = userDao.getAllCustomers(firstName, lastName, typeAccount);
            return users;
        }
        
    }
}