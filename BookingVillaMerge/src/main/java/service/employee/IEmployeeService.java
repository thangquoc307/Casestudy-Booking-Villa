package service.employee;

import model.Employee;
import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();

    void createEmployee(Employee admin);

    Employee findByEmployeeCode(int employee_code);

    void updateEmployee(Employee admin);

    void deleteEmployee(int employee_code);

//    List<Admin> getAllCustomer();
//    void deleteCustomer(int account_code);

}
