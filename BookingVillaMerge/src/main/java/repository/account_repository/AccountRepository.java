package repository.account_repository;



import model.Account;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository{
    private static final String SELECT_ACCOUNT = "select * from accounts\n" +
            "join customers on accounts.account_code = customers.account_code\n" +
            "where customers.phone_number = ? and accounts.password_account = ? and accounts.is_delete = 0";
    private static final String SELECT_ACCOUNT_BY_USER_NAME = "SELECT * FROM villa_booking1.accounts\n" +
            "WHERE user_name = ?" ;

    private static final String INSERT_ACCOUNT = "INSERT INTO accounts(user_name,password_account)\n" +
            "VALUES (?,?)";
    private static final String  UPDATE_PASSWORD = "UPDATE accounts\n" + "SET password_account = ?\n" + "WHERE user_name = ?;\n" ;
    private static final String  UPDATE_USER_NAME = "UPDATE accounts\n" + "SET user_name = ?\n" + "WHERE account_code = ?;\n" ;
    private static final String GET_PASSWORD = "call  resetPasswordByIdentityNumberAndPhoneNumber(?,?,?);\n";
    private static final String DELETE_ACCOUNT_AND_CUSTOMER = "call deleteAccountAndCustomer(?)";
    private static final String SELECT_ACCOUNT_BY_ACCOUNT_CODE = "select * from accounts\n" +
            "where account_code = ?";

    private static final String LOGIN = "call check_account(?,?);";
    @Override
    public Account getAccountByPhoneNumberAndPassword (String phoneNumber, String password) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT);
            preparedStatement.setString(1,phoneNumber);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new Account(resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getBoolean(4));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Account getAccountByUserName(String userName) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_USER_NAME);
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new Account(resultSet.getInt(1),
                                    resultSet.getString(2),
                                        resultSet.getString(3),
                                            resultSet.getBoolean(4));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(Account account) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1,account.getUserName());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
        public void updatePassword(String password,String userName) {
            Connection connection = BaseRepository.getConnection();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD);
                preparedStatement.setString(1,password);
                preparedStatement.setString(2,userName);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public void getPassword(String password, String identityNumber, String phoneNumber) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PASSWORD);
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,identityNumber);
            preparedStatement.setString(3,phoneNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserName(String userName,int accountCode) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_NAME);
            preparedStatement.setString(1,userName);
            preparedStatement.setInt(2,accountCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccountAndCustomer(int accountCode) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT_AND_CUSTOMER);
            preparedStatement.setInt(1,accountCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getAccountByAccountCode(int accountCode) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ACCOUNT_CODE);
            preparedStatement.setInt(1,accountCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getBoolean(4));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @Override
    public List<String> login(String id, String password) {
        List<List<String>> accounts = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(LOGIN);
            statement.setString(1, id);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                List<String> account = new ArrayList<>();
                account.add(resultSet.getString(1));
                account.add(resultSet.getString(2));
                account.add(resultSet.getString(3));
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (accounts.size() == 0){
            return new ArrayList<>();
        } else {
            return accounts.get(0);
        }
    }
}
