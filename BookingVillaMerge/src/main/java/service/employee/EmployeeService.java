package service.employee;

import model.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository repository = new EmployeeRepository();
    @Override
    public List<Employee> getAllEmployee() {
        return repository.gettAllEmployee();
    }

    @Override
    public void createEmployee(Employee employee) {
        repository.createEmployee(employee);
    }

    @Override
    public Employee findByEmployeeCode(int employee_code) {
        return repository.findByEmployeeCode(employee_code);
    }

    @Override
    public void updateEmployee(Employee employee) {
        repository.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int employee_code) {
        repository.deleteEmployee(employee_code);
    }

}
