package repository.customer_repository;


import model.Customer;

public interface ICustomerRepository {
    Customer getCustomerByIdentityNumber(String identityNumber);
    Customer getCustomerByEmail (String email);
    void saveCustomer (Customer customer);
    Customer getCustomerByPhoneNumber (String phoneNumber);
    Customer getCustomerByCustomerCode(int customerCode);
    Customer getCustomerByAccountCode(int accountCode);
    void  updateCustomer(String name, String identityNumber, String birthday, boolean gender,
                         String phoneNumber,String email,String address,int customerCode);
}
