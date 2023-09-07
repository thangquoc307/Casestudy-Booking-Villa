package model;

public class Employee {
    private int employee_code;
    private String name;
    private String identity_number;
    private String birthday;
    private int gender;
    private String phone_number;
    private String email;
    private String user_name;

    private String password_account;

    public String getPassword_account() {
        return password_account;
    }

    public void setPassword_account(String password_account) {
        this.password_account = password_account;
    }
//    public Admin(String account_code, String user_name, String password_account) {
//        this.account_code = account_code;
//        this.user_name = user_name;

//        this.password_account = password_account;
//    }

    //    public Admin(String user_name, String password_account) {
//        this.user_name = user_name;
//        this.password_account = password_account;
//    }
//

    public Employee(String name, String identity_number, String birthday, int gender, String phone_number, String email,
                    String user_name) {
        this.name = name;
        this.identity_number = identity_number;
        this.birthday = birthday;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.user_name = user_name;
//        this.password_account = password_account;
    }

    public Employee(int employee_code, String name, String identity_number, String birthday, int gender, String phone_number, String email, String user_name) {
        this.employee_code = employee_code;
        this.name = name;
        this.identity_number = identity_number;
        this.birthday = birthday;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.user_name = user_name;
    }

    public Employee(String name, String identity_number, String birthday, int gender, String phone_number,
                    String email, String user_name, String password_account) {
        this.name = name;
        this.identity_number = identity_number;
        this.birthday = birthday;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.user_name = user_name;
        this.password_account = password_account;

    }

    public Employee(int employee_code, String name, String identity_number, String birthday, int gender, String phone_number, String email, String user_name, String password_account) {
        this.employee_code = employee_code;
        this.name = name;
        this.identity_number = identity_number;
        this.birthday = birthday;
        this.gender = gender;
        this.phone_number = phone_number;
        this.email = email;
        this.user_name = user_name;
        this.password_account = password_account;
    }

    public int getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(int employee_code) {
        this.employee_code = employee_code;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAccount_code() {
        return user_name;
    }

    public void setAccount_code(String account_code) {
        this.user_name = account_code;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employee_code=" + employee_code +
                ", name='" + name + '\'' +
                ", identity_number='" + identity_number + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
