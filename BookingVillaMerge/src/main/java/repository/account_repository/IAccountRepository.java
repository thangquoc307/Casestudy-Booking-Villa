package repository.account_repository;


import model.Account;

import java.util.List;

public interface IAccountRepository {
    Account getAccountByPhoneNumberAndPassword (String phoneNumber, String password);
    Account getAccountByUserName(String userName);
    void save(Account account);
    void updatePassword (String password,String userName);
    void getPassword (String password, String identityNumber, String phoneNumber);
    void updateUserName (String userName,int accountCode);
    void deleteAccountAndCustomer (int accountCode);
    Account getAccountByAccountCode(int accountCode);
    List<String> login(String id, String password);


}
