package model.booking;

public class Booking {
    private int bookingId;
    private String checkIn;
    private String checkOut;
    private int price;
    private int deposit;
    private String checkInPersonName;
    private String checkInPersonPhoneNumber;
    private int villaId;
    private int customerCode;
    private boolean isPending;
    private boolean isDelete;

    public Booking(String checkInPersonName, String checkInPersonPhoneNumber) {
        this.checkInPersonName = checkInPersonName;
        this.checkInPersonPhoneNumber = checkInPersonPhoneNumber;
    }

    public Booking(int bookingId, String checkIn, String checkOut, int price, int deposit, int villaId) {
        this.bookingId = bookingId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.deposit = deposit;
        this.villaId = villaId;
    }
    public Booking(String checkIn, String checkOut, int price, int deposit,
                   String checkInPersonName, String checkInPersonPhoneNumber, int villaId,
                   int customerCode) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.deposit = deposit;
        this.checkInPersonName = checkInPersonName;
        this.checkInPersonPhoneNumber = checkInPersonPhoneNumber;
        this.villaId = villaId;
        this.customerCode = customerCode;
    }

    public Booking(int bookingId, String checkIn, String checkOut, int price, int deposit,
                   String checkInPersonName, String checkInPersonPhoneNumber, int villaId,
                   int customerCode, boolean isPending, boolean isDelete) {
        this.bookingId = bookingId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.deposit = deposit;
        this.checkInPersonName = checkInPersonName;
        this.checkInPersonPhoneNumber = checkInPersonPhoneNumber;
        this.villaId = villaId;
        this.customerCode = customerCode;
        this.isPending = isPending;
        this.isDelete = isDelete;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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
        isPending = pending;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
