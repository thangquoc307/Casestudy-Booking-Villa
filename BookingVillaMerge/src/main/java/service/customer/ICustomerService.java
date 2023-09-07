package service.customer;

import model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCusomter();

    void deleteCustomer(int customer_code);
}
