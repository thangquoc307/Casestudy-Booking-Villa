package model.customer;

import java.util.Date;

public class Customer {
    private int customer_code;
    private String name;
    private String identity_number;
    private String birthday;
    private int gender;
    private String phone_number;
    private String email;
    private String address;
    private String user_name;

    public Customer(int customer_code, String name, String identity_number, String birthday, int gender, String phone_number,
                    String email, String address, String user_name) {
        this.customer_code = customer_code;
        this.name = name;
        this.identity_number = identity_number;
        this.birthday = birthday;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.user_name = user_name;
    }

    public Customer(String name, String identity_number, String birthday, int gender, String phone_number, String email,
                    String address, String user_name) {
        this.name = name;
        this.identity_number = identity_number;
        this.birthday = birthday;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.user_name = user_name;
    }



    public int getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(int customer_code) {
        this.customer_code = customer_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String identity_number) {
        this.identity_number = identity_number;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
