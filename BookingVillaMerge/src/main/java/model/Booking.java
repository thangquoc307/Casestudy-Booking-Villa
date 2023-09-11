package model;

import java.util.Date;

public class Booking {
    private int id;
    private String checkIn;




    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    private String checkOut;
    private String bookingDate;
    private int price;
    private int deposit;
    private String checkInPersonName;
    private String checkInPersonPhoneNumber;
    private int villaId;
    private int customerCode;
    private boolean isPending;
    private boolean isDelete;
    private String pending;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", price=" + price +
                ", deposit=" + deposit +
                ", checkInPersonName='" + checkInPersonName + '\'' +
                ", checkInPersonPhoneNumber='" + checkInPersonPhoneNumber + '\'' +
                ", villaId=" + villaId +
                ", customerCode=" + customerCode +
                ", isPending=" + isPending +
                ", isDelete=" + isDelete +
                '}';
    }

    public Booking(int id, String checkIn, String checkOut, String bookingDate, int price, int deposit, String checkInPersonName, String checkInPersonPhoneNumber, int villaId, int customerCode, boolean isPending, boolean isDelete, String pending) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = bookingDate;
        this.price = price;
        this.deposit = deposit;
        this.checkInPersonName = checkInPersonName;
        this.checkInPersonPhoneNumber = checkInPersonPhoneNumber;
        this.villaId = villaId;
        this.customerCode = customerCode;
        this.isPending = isPending;
        this.isDelete = isDelete;
        this.pending = pending;
    }

    public Booking(int id, String checkIn, String checkOut, String bookingDate, int price, int deposit, String checkInPersonName,
                   String checkInPersonPhoneNumber, int villaId, int customerCode, boolean isPending) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = bookingDate;
        this.price = price;
        this.deposit = deposit;
        this.checkInPersonName = (checkInPersonName == null) ? "" : checkInPersonName;
        this.checkInPersonPhoneNumber = (checkInPersonPhoneNumber == null) ? "" : checkInPersonPhoneNumber;
        this.villaId = villaId;
        this.customerCode = customerCode;
        this.isPending = isPending;
        if (isPending) {
            pending = "Đã duyệt";
        } else {
            pending = "Chưa duyệt";
        }
    }

    public Booking(String checkIn, String checkOut, String bookingDate, int price, int deposit, int villaId) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = bookingDate;
        this.price = price;
        this.deposit = deposit;
        this.villaId = villaId;
    }

    public Booking(String checkIn, String checkOut, String bookingDate, int price, int deposit,
                   String checkInPersonName, String checkInPersonPhoneNumber, int villaId,
                   int customerCode, boolean isPending, boolean isDelete) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = bookingDate;
        this.price = price;
        this.deposit = deposit;
        this.checkInPersonName = checkInPersonName;
        this.checkInPersonPhoneNumber = checkInPersonPhoneNumber;
        this.villaId = villaId;
        this.customerCode = customerCode;
        this.isPending = isPending;
        this.isDelete = isDelete;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Booking(int id, String checkIn, String checkOut, String bookingDate, int price, int deposit,
                   String checkInPersonName, String checkInPersonPhoneNumber, int villaId,
                   int customerCode, boolean isPending, boolean isDelete) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = bookingDate;
        this.price = price;
        this.deposit = deposit;
        this.checkInPersonName = checkInPersonName;
        this.checkInPersonPhoneNumber = checkInPersonPhoneNumber;
        this.villaId = villaId;
        this.customerCode = customerCode;
        this.isPending = isPending;
        this.isDelete = isDelete;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getCheckInPersonName() {
        return checkInPersonName;
    }

    public void setCheckInPersonName(String checkInPersonName) {
        this.checkInPersonName = checkInPersonName;
    }

    public String getCheckInPersonPhoneNumber() {
        return checkInPersonPhoneNumber;
    }

    public void setCheckInPersonPhoneNumber(String checkInPersonPhoneNumber) {
        this.checkInPersonPhoneNumber = checkInPersonPhoneNumber;
    }

    public int getVillaId() {
        return villaId;
    }

    public void setVillaId(int villaId) {
        this.villaId = villaId;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isDelete = pending;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}








