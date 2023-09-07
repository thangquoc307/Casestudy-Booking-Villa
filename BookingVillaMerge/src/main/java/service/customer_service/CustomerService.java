package service.customer_service;


import model.Customer;
import repository.customer_repository.CustomerRepository;
import repository.customer_repository.ICustomerRepository;

public class CustomerService implements ICustomerService{
    private ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public void saveCustomer(Customer customer) {
        iCustomerRepository.saveCustomer(customer);
    }

    @Override
    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        return iCustomerRepository.getCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public Customer getCustomerByIdentityNumber(String identityNumber) {
        return iCustomerRepository.getCustomerByIdentityNumber(identityNumber);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public Customer getCustomerByCustomerCode(int customerCode) {
        return iCustomerRepository.getCustomerByCustomerCode(customerCode);
    }

    @Override
    public void updateCustomer(String name, String identityNumber, String birthday, boolean gender,
                               String phoneNumber, String email, String address, int customerCode) {
        iCustomerRepository.updateCustomer(name,identityNumber,birthday,gender,phoneNumber,
                email,address,customerCode);
    }
}
