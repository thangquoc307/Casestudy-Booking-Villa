package controller;

import model.Employee;
import service.employee.EmployeeService;
import service.employee.IEmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createEmployee":
                showFormCreate(request, response);
                break;
            case "updateEmployee":
                showFormUpdate(request, response);
                break;
            default:
                getAllEmployee(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createEmployee":
                createEmployee(request, response);
                break;
            case "updateEmployee":
                updateEmployee(request, response);
                break;
            case "deleteEmployee":
                deleteEmployee(request, response);
                break;
            default:
                break;
        }
    }

    private void getAllEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list = employeeService.getAllEmployee();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/employee.jsp").forward(req, resp);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create_employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String identity_number = request.getParameter("identity_number");
        String birthday = request.getParameter("birthday");
        int gender = Integer.valueOf(request.getParameter("gender"));
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String user_name = request.getParameter("user_name");
        String password_account = request.getParameter("password_account");
        Employee employee = new Employee(name, identity_number, birthday, gender, phone_number, email, user_name, password_account);
        System.out.println(employee);
        employeeService.createEmployee(employee);

        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employee_code = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findByEmployeeCode(employee_code);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/update_employee.jsp").forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employee_code = Integer.parseInt(request.getParameter("employee_code"));
        String name = request.getParameter("name");
        String identity_number = request.getParameter("identity_number");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String user_name = request.getParameter("user_name");
        String password_account = request.getParameter("password_account");
        Employee employee = new Employee(employee_code,name, identity_number, birthday, gender, phone_number, email, user_name, password_account);
        employeeService.updateEmployee(employee);
        response.sendRedirect("/employee");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int employee_code = Integer.parseInt(request.getParameter("id_delete"));
        employeeService.deleteEmployee(employee_code);
        response.sendRedirect("/employee");
    }
}
