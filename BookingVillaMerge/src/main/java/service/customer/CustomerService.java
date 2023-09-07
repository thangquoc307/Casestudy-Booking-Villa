package service.customer;

import model.customer.Customer;
import repository.customer.CustomerRepository;
import repository.customer.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository repository = new CustomerRepository();

    @Override
    public List<Customer> getAllCusomter() {
        return repository.getAllCustomer();
    }

    @Override
    public void deleteCustomer(int customer_code) {
        repository.deleteCustomer(customer_code);
    }
}
