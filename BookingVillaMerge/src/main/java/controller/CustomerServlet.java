package controller;

import model.customer.Customer;
import service.customer.CustomerService;
import service.customer.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "getAllCustomer":
                getAllCustomer(req, resp);
                break;
            default:
                break;
        }
    }

    private void getAllCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = customerService.getAllCusomter();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/customer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action1 = req.getParameter("action");
        if (action1 == null) {
            action1 = "";
        }
        switch (action1) {
            case "deleteCustomer":
                deleteCustomer(req, resp);
                getAllCustomer(req, resp);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int account_code = Integer.parseInt(req.getParameter("id_delete"));
        customerService.deleteCustomer(account_code);
//        resp.sendRedirect("/customer");
    }
}
