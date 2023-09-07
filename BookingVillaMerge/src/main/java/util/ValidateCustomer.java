package util;


import model.Customer;
import service.customer_service.CustomerService;
import service.customer_service.ICustomerService;

public class ValidateCustomer {
    private static ICustomerService iCustomerService = new CustomerService();

    public static boolean validateIdentityNumber(String identityNumber) {
        Customer customer = iCustomerService.getCustomerByIdentityNumber(identityNumber);
        if (customer == null) {
            return true;
        }
        return false;
    }

    public static boolean validateEmail(String email) {
        Customer customer = iCustomerService.getCustomerByEmail(email);
        if (customer == null) {
            return true;
        }
        return false;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Customer customer = iCustomerService.getCustomerByPhoneNumber(phoneNumber);
        if (customer == null) {
            return true;
        }
        return false;
    }

}
