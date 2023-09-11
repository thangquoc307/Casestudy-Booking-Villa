package service.customer_service;


import model.Customer;

public interface ICustomerService {
    void saveCustomer (Customer customer);
    Customer getCustomerByPhoneNumber (String phoneNumber);
    Customer getCustomerByIdentityNumber(String identityNumber);
    Customer getCustomerByEmail (String email);
    Customer getCustomerByCustomerCode(int customerCode);
    void  updateCustomer(String name,String birthday, boolean gender
                        ,String address,int customerCode);

}
