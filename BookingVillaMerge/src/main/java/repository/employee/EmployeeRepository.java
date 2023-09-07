package repository.employee;

import model.Employee;
import repository.BaseRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class EmployeeRepository implements IEmployeeRepository {

    private static final String SELECT_EMPLOYEE = "SELECT employee_code, name, identity_number, birthday, gender, phone_number, email, user_name " +
            "FROM employees " +
            "JOIN positions p ON employees.position_code = p.position_code " +
            "JOIN accounts ON employees.account_code = accounts.account_code " +
            "WHERE p.position_name = 'customer service' and employees.is_delete = 0 ";

    private static final String INSERT_EMPLOYEE = "call `create_employee`(?, ?, ?, ?, ?, ?,?, ?);";

    private static final String SELECT_BY_EMPLOYEE_CODE = "select employee_code, name, identity_number, birthday, " +
            "gender, phone_number, email, user_name, password_account from Employees JOIN accounts ON " +
            "employees.account_code = accounts.account_code where employee_code =?";

    private static final String UPDATE = "UPDATE employees " +
            "JOIN accounts ON employees.account_code = accounts.account_code " +
            "SET " +
            "    employees.name = ?, " +
            "    employees.identity_number = ?, " +
            "    employees.birthday = ?, " +
            "    employees.gender = ?, " +
            "    employees.phone_number = ?, " +
            "    employees.email = ?, " +
            "    accounts.user_name = ? " +
            " WHERE employees.employee_code = ? ";

    private static final String DELETE = "call delete_employee(?) ";

    @Override
    public List<Employee> gettAllEmployee() {
        Connection connection = BaseRepository.getConnection();
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_code = resultSet.getInt("employee_code");
                String name = resultSet.getString("name");
                String identity_number = resultSet.getString("identity_number");
                String birthday = resultSet.getString("birthday");
                int gender = resultSet.getInt("gender");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String user_name = resultSet.getString("user_name");
                list.add(new Employee(employee_code, name, identity_number, birthday, gender, phone_number, email, user_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
        return list;
    }

    @Override
    public void createEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getUser_name());
            preparedStatement.setString(2, employee.getPassword_account());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getIdentity_number());
            preparedStatement.setString(5, employee.getBirthday());
            preparedStatement.setInt(6, employee.getGender());
            preparedStatement.setString(7, employee.getPhone_number());
            preparedStatement.setString(8, employee.getEmail());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee findByEmployeeCode(int employee_code) {
        Connection connection = BaseRepository.getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_EMPLOYEE_CODE);
            preparedStatement.setInt(1, employee_code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_code");
                String name = resultSet.getString("name");
                String identity_number = resultSet.getString("identity_number");
                String birthday = resultSet.getDate("birthday").toLocalDate().format(DateTimeFormatter.ISO_DATE.ofPattern("dd/MM/yyyy"));
                Integer gender = resultSet.getInt("gender");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String user_name = resultSet.getString("user_name");
                String password_account = resultSet.getString("password_account");
                employee = new Employee(employee_id,name, identity_number, birthday, gender, phone_number, email, user_name, password_account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getIdentity_number());
            preparedStatement.setString(3, employee.getBirthday());
            preparedStatement.setInt(4, employee.getGender());
            preparedStatement.setString(5, employee.getPhone_number());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getUser_name());
            preparedStatement.setInt(8, employee.getEmployee_code());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int employee_code) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, employee_code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

