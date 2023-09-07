package repository.employee;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> gettAllEmployee();

    void createEmployee(Employee employee);

    Employee findByEmployeeCode(int employee_code);

    void updateEmployee(Employee admin);

    void deleteEmployee(int employee_code);

}
