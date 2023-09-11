package controller;


import util.ValidateCustomer;
import model.Account;
import model.Customer;
import service.MainPageService;
import service.account_service.AccountService;
import service.account_service.IAccountService;
import service.customer_service.CustomerService;
import service.customer_service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "login", value = "/login")
public class UserLoginServlet extends HttpServlet {
    private IAccountService iAccountService = new AccountService();
    private ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "changePassword":
                changePassword(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showInformationUser":
                showInformationUser(request, response);
                break;
            case "back":
                String userName = (String)request.getAttribute("user_name");
                request.setAttribute("user_name",userName);
                MainPageService mainPageService= new MainPageService();
                String dataVillaReload = mainPageService.loadingDataBaseVilla(request,response);
                request.setAttribute("data", dataVillaReload);
                request.setAttribute("role", MainPageController.getRole());
                request.setAttribute("loginfail", 0);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            case "logout":
                HttpSession session = request.getSession();
                session.removeAttribute("customer");
                System.out.println("removed customer");
                session.removeAttribute("account");
                System.out.println("removed account");
                session.removeAttribute("accountCode");
                request.removeAttribute("accountCode");
                System.out.println("removed accountCode");
                session.removeAttribute("accountCode");
                session.removeAttribute("userName");
                session.removeAttribute("identityNumber");
                session.removeAttribute("dateOfBirth");
                session.removeAttribute("gender");
                session.removeAttribute("phoneNumber");
                session.removeAttribute("email");
                session.removeAttribute("address");
                request.removeAttribute("user_name");
                MainPageController.setRole(0);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            request.setAttribute("deleteAccountError", "Không thể xóa tài khoản quản lý!");
            try {
                request.getRequestDispatcher("user-information.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int accountCode = Integer.parseInt(request.getParameter("accountCode"));
        iAccountService.deleteAccountAndCustomer(accountCode);
        try {
            response.sendRedirect("login.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            request.setAttribute("changePassError", "Không thể đổi mật khẩu tài khoản quản lý tại đây!");
            try {
                request.getRequestDispatcher("change-password.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int accountCode = (Integer) session.getAttribute("accountCode");
        Account account = iAccountService.getAccountByAccountCode(accountCode);
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("password");
        if (oldPass.equals(account.getPassword())) {
            iAccountService.updatePassword(newPass, account.getUserName());
            showInformationUser(request, response);
        } else {
            request.setAttribute("oldPasswordError", "Mật khẩu không đúng! Mời nhập lại");
            try {
                request.getRequestDispatcher("change-password.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            request.setAttribute("updateError", "Không thể sửa tài khoản quản lý tại đây!");
            try {
                request.getRequestDispatcher("form-update-user.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String fullName = request.getParameter("fullName");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        boolean genderValue = false;
        if(gender.equals("Nam")){
            genderValue = false;
        }else {
            genderValue = true;
        }
        String address = request.getParameter("address");
        int customerCode = customer.getCustomerCode();
        iCustomerService.updateCustomer(fullName,birthday, genderValue,address, customerCode);

        Customer newCustomer = iCustomerService.getCustomerByCustomerCode(customer.getCustomerCode());
        session.setAttribute("customer", newCustomer);
        showInformationUser(request, response);
    }

    private void showInformationUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            session.setAttribute("accountCode", customer.getAccountCode());
            session.setAttribute("userName", customer.getCustomerName());
            session.setAttribute("identityNumber", customer.getIdentityNumber());
            session.setAttribute("dateOfBirth",customer.getDateOfBirth());
            if(customer.isGender()){
                session.setAttribute("gender", "Nữ");
            }else {
                session.setAttribute("gender", "Nam");
            }
            session.setAttribute("phoneNumber", customer.getPhoneNumber());
            session.setAttribute("email", customer.getEmail());
            session.setAttribute("address", customer.getAddress());
            try {
                request.getRequestDispatcher("user-information.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            session.setAttribute("accountCode", "");
            session.setAttribute("userName", "");
            session.setAttribute("identityNumber", "");
            session.setAttribute("birthday", "");
            session.setAttribute("gender", "");
            session.setAttribute("phoneNumber", "");
            session.setAttribute("email", "");
            session.setAttribute("address", "");
            try {
                request.getRequestDispatcher("user-information.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        MainPageService mainPageService = new MainPageService();
        String userName = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        List<String> accountInfo = iAccountService.login(userName, password);
        String data = mainPageService.loadingDataBaseVilla(request, response);
        request.setAttribute("data", data);

        if (accountInfo.size() == 0) {
            request.setAttribute("message", "Sai tên tài khoản hoặc mật khẩu!");
            try {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("user_name", "");
        } else {
            MainPageController.setAccount(Integer.parseInt(accountInfo.get(2)));
            switch (accountInfo.get(0)) {
                case "customer":
                    MainPageController.setRole(1);
                    break;
                case "customer service":
                    MainPageController.setRole(2);
                    break;
                case "admin":
                    MainPageController.setRole(3);
                    break;
                default:
                    MainPageController.setRole(0);
                    break;
            }
            request.setAttribute("role", MainPageController.getRole());
            session.setAttribute("user_name", accountInfo.get(1));
        }
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Customer customer = iCustomerService.getCustomerByPhoneNumber(userName);
        if (customer != null) {
            session.setAttribute("customer", customer);
            int accountCode = customer.getAccountCode();
            session.setAttribute("accountCode", accountCode);
            Account account = iAccountService.getAccountByAccountCode(accountCode);
            session.setAttribute("account", account);
        }
    }
}
