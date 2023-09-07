package service.account_service;


import model.Account;
import repository.account_repository.AccountRepository;
import repository.account_repository.IAccountRepository;

import java.util.List;

public class AccountService implements IAccountService {
    private IAccountRepository iAccountRepository = new AccountRepository();
//    @Override
//    public boolean login(String phoneNumber, String password) {
//        Account account = iAccountRepository.getAccountByPhoneNumberAndPassword(phoneNumber,password);
//        if (account != null){
//            return true;
//        }
//        return false;
//    }
    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }
    @Override
    public Account getAccountByUserName(String userName) {
        return iAccountRepository.getAccountByUserName(userName);
    }

    @Override
    public void updatePassword(String password,String userName) {
        iAccountRepository.updatePassword(password,userName);
    }

    @Override
    public void getPassword(String password, String identityNumber, String phoneNumber) {
        iAccountRepository.getPassword(password,identityNumber,phoneNumber);
    }

    @Override
    public void updateUserName(String userName, int accountCode) {
        iAccountRepository.updateUserName(userName,accountCode);
    }

    @Override
    public void deleteAccountAndCustomer(int accountCode) {
        iAccountRepository.deleteAccountAndCustomer(accountCode);
    }

    @Override
    public Account getAccountByAccountCode(int accountCode) {
        return iAccountRepository.getAccountByAccountCode(accountCode);
    }

    @Override
    public List<String> login(String id, String password) {
        List<String> stringList = iAccountRepository.login(id,password);
        return stringList;
    }
}
