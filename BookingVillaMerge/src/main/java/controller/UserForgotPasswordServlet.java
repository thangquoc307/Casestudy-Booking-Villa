package controller;



import model.Customer;
import service.account_service.AccountService;
import service.account_service.IAccountService;
import service.customer_service.CustomerService;
import service.customer_service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPasswordServlet", value = "/forgot-password")
public class UserForgotPasswordServlet extends HttpServlet {
    private static IAccountService accountService = new AccountService();
    private static ICustomerService iCustomerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String phoneNumber = request.getParameter("phoneNumber");
        String identityNumber = request.getParameter("identityNumber");
        String password = request.getParameter("password");
        Customer customer = iCustomerService.getCustomerByIdentityNumber(identityNumber);
        Customer customer1 = iCustomerService.getCustomerByPhoneNumber(phoneNumber);
        if (customer1 == null){
            request.setAttribute("phoneNumberError","Số điện thoại không tồn tại");
            request.getRequestDispatcher("forgot-password-user.jsp").forward(request,response);
        }
        else if(customer == null){
            request.setAttribute("identityNumberError","Số CMND/CCCD không tồn tại");
            request.getRequestDispatcher("forgot-password-user.jsp").forward(request,response);
        }
        else if (!customer1.equals(customer)) {
            request.setAttribute("phoneNumberError","Số điện thoại và chứng minh nhân dân không thuộc một tài khoản");
            request.getRequestDispatcher("forgot-password-user.jsp").forward(request,response);
        }else if (customer.equals(customer1)) {
            accountService.getPassword(password,identityNumber,phoneNumber);
            response.sendRedirect("login.jsp");
        }
    }
}