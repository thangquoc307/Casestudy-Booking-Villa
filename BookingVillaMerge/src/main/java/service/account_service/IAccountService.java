package service.account_service;


import model.Account;

import java.util.List;

public interface IAccountService {
    void save(Account account);
    Account getAccountByUserName(String userName);
    void updatePassword (String password,String userName);
    void getPassword (String password, String email);
    void updateUserName (String userName,int accountCode);
    void deleteAccountAndCustomer (int accountCode);
    Account getAccountByAccountCode(int accountCode);
    List<String> login(String id, String password);
    Account getUserNameByEmail(String email);


}
