package repository.customer_repository;


import model.Customer;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ACCOUNT_BY_IDENTITY_NUMBER = "SELECT * FROM customers\n" +
            "WHERE identity_number = ?";
    private static final String SELECT_ACCOUNT_BY_EMAIL = "SELECT * FROM customers\n" +
            "WHERE email = ?";
    private static final String INSERT_CUSTOMER = "INSERT INTO customers (name, identity_number, birthday, " +
            "gender, phone_number, email, address, account_code) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_CUSTOMER_BY_PHONE_NUMBER = "SELECT * FROM customers\n" +
            "WHERE phone_number = ?;";

    private static final String UPDATE_CUSTOMER = "UPDATE customers\n" +
            "SET name = ?, identity_number = ?, birthday = ?, gender = ?, phone_number = ?, \n" +
            "\t\t\temail = ?, address = ?\n" +
            "WHERE customer_code  = ?;";
    private static final String SELECT_CUSTOMER_BY_CUSTOMER_CODE = "SELECT * FROM customers\n" +
            "WHERE customer_code = ?";
    private static final String SELECT_CUSTOMER_BY_ACCOUNT_CODE = "select*from customers\n" +
            "join accounts on customers.account_code = accounts.account_code\n" +
            "where customers.account_code = ?;";
    @Override
    public Customer getCustomerByIdentityNumber(String identityNumber) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_IDENTITY_NUMBER);
            preparedStatement.setString(1, identityNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getBoolean(10));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getBoolean(10));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getIdentityNumber());
            preparedStatement.setString(3, customer.getDateOfBirth());
            preparedStatement.setBoolean(4, customer.isGender());
            preparedStatement.setString(5, customer.getPhoneNumber());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getAccountCode());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_PHONE_NUMBER);
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getBoolean(10));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updateCustomer(String name, String identityNumber, String birthday, boolean gender,
                               String phoneNumber, String email, String address, int customerCode) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, identityNumber);
            preparedStatement.setString(3, birthday);
            preparedStatement.setBoolean(4, gender);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, address);
            preparedStatement.setInt(8, customerCode);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCustomerByCustomerCode(int customerCode) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_CUSTOMER_CODE);
            preparedStatement.setInt(1, customerCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getBoolean(10));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Customer getCustomerByAccountCode(int accountCode) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ACCOUNT_CODE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getBoolean(10));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
