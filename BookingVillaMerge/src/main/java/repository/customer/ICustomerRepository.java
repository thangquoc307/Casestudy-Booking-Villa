package repository.customer;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomer();

    void deleteCustomer(int customer_code);
}
