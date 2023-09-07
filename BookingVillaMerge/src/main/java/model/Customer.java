package model;

import java.util.Objects;

public class Customer {
    private int customerCode;
    private String customerName;
    private String identityNumber;
    private String dateOfBirth;
    private boolean isGender;
    private String phoneNumber;
    private String email;
    private String address;
    private int accountCode;
    private boolean isDelete = false;

    public Customer() {}

    public Customer(String customerName, String identityNumber, String dateOfBirth, boolean isGender,
                    String phoneNumber, String email, String address, int accountCode, boolean isDelete) {
        this.customerName = customerName;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
        this.isGender = isGender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.accountCode = accountCode;
        this.isDelete = isDelete;
    }

    public Customer(int customerCode, String customerName, String identityNumber, String dateOfBirth, boolean isGender,
                    String phoneNumber, String email, String address, int accountCode, boolean isDelete) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
        this.isGender = isGender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.accountCode = accountCode;
        this.isDelete = isDelete;
    }

    public Customer(String customerName, String identityNumber, String dateOfBirth, boolean isGender, String phoneNumber, String email, String address, int accountCode) {
        this.customerName = customerName;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
        this.isGender = isGender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.accountCode = accountCode;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return isGender;
    }

    public void setGender(boolean gender) {
        isGender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(int accountCode) {
        this.accountCode = accountCode;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerCode == customer.customerCode && isGender == customer.isGender && accountCode == customer.accountCode && isDelete == customer.isDelete && Objects.equals(customerName, customer.customerName) && Objects.equals(identityNumber, customer.identityNumber) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(email, customer.email) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerCode, customerName, identityNumber, dateOfBirth, isGender, phoneNumber, email, address, accountCode, isDelete);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode=" + customerCode +
                ", customerName='" + customerName + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", isGender=" + isGender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
