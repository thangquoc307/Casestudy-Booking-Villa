package repository.customer;

import model.customer.Customer;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_CUSTOMER = "select customer_code, name, identity_number, birthday,gender, phone_number, email, address, user_name " +
            "from customers " +
            "JOIN accounts ON customers.account_code = accounts.account_code and customers.is_delete = 0 ";

    private static final String DELETE = "call delete_customer(?) ";

    @Override
    public List<Customer> getAllCustomer() {
        Connection connection = BaseRepository.getConnection();
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_code = resultSet.getInt("customer_code");
                String name = resultSet.getString("name");
                String identity_number = resultSet.getString("identity_number");
                String birthday = resultSet.getDate("birthday").toLocalDate().format(DateTimeFormatter.ISO_DATE.ofPattern("dd/MM/yyyy"));
                int gender = resultSet.getInt("gender");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String user_name = resultSet.getString("user_name");
                list.add(new Customer(customer_code, name, identity_number, birthday, gender, phone_number, email, address, user_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void deleteCustomer(int customer_code) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, customer_code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
