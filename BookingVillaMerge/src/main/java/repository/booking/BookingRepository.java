package repository.booking;

import model.Villa;
import model.booking.Booking;
import repository.BaseRepository;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {
    private static String SELECT_PENDING = "call show_list_pending(?)";
    private static String SELECT_APPROVED = "call show_list_approved(?)";
    private static String SELECT_DELETE = "call show_list_delete(?)";
    private static String ADD_BOOKING = "call add_booking(?,?,?,?,?,?,?,?)";
    private static String UPDATE_BOOKING = "call update_booking(?,?,?)";
    private static String DELETE_BOOKING = "call delete_booking(?)";
    private static String GET_INFORM_ACCOUNT = "call get_inform_account()";
    private static String GET_INFORM_VILLA = "call get_inform_villa_by_id(?)";

    @Override
    public Booking findByBookingId(int bookingId, int findByAccountCode) {
        for (Booking booking : showListPending(findByAccountCode)) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public List<String> getInformAccount() {
        List<String> informAccountList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_INFORM_ACCOUNT);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String accountCode = resultSet.getString("account_code");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String inform = accountCode + "," + name + "," + phoneNumber;
                informAccountList.add(inform);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return informAccountList;
    }

    @Override
    public Villa getInformVillaById(int findByVillaId) {
        Connection connection = BaseRepository.getConnection();
        Villa villa = null;
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_INFORM_VILLA);
            callableStatement.setInt(1,findByVillaId);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String map = resultSet.getString("image_map");
                int price = resultSet.getInt("price");
                int level = resultSet.getInt("level");
                double area = resultSet.getDouble("area");
                double width = resultSet.getDouble("width");
                double deep = resultSet.getDouble("deep");
                int bedroom = resultSet.getInt("bedroom");
                int kitchen = resultSet.getInt("kitchen_room");
                int living = resultSet.getInt("living_room");
                int toilet = resultSet.getInt("toilet");
                int relax = resultSet.getInt("relax_room");
                int gym = resultSet.getInt("gym_room");
                int garage = resultSet.getInt("garage");
                int capacity = resultSet.getInt("capacity");
                villa = new Villa (findByVillaId,map,price,level,area,width,deep,bedroom,kitchen,living,toilet,relax,gym,
                        garage,capacity);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return villa;
    }


    @Override
    public List<Booking> showListPending(int findByAccountCode) {
        List<Booking> bookingListPending = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_PENDING);
            callableStatement.setInt(1, findByAccountCode);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int bookingId = resultSet.getInt("booking_id");
                String checkIn = resultSet.getDate("check_in").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String checkOut = resultSet.getDate("check_out").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int price = resultSet.getInt("price");
                int deposit = resultSet.getInt("deposit");
                String checkInPersonName = resultSet.getString("check_in_person_name");
                String checkInPersonPhoneNumber = resultSet.getString("check_in_person_phone_number");
                int villaId = resultSet.getInt("villa_id");
                int customerCode = resultSet.getInt("customer_code");
                boolean isPending = resultSet.getBoolean("is_pending");
                boolean isDelete = resultSet.getBoolean("is_delete");
                bookingListPending.add(new Booking(bookingId, checkIn, checkOut, price, deposit,
                        checkInPersonName, checkInPersonPhoneNumber, villaId, customerCode, isPending, isDelete));
//                bookingListPending.add(new Booking(bookingId, checkIn, checkOut, price, deposit, villaId));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingListPending;
    }

    @Override
    public List<Booking> showListApproved(int findByAccountCode) {
        List<Booking> bookingListApproved = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_APPROVED);
            callableStatement.setInt(1, findByAccountCode);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int bookingId = resultSet.getInt("booking_id");
                String checkIn = resultSet.getDate("check_in").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String checkOut = resultSet.getDate("check_out").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int price = resultSet.getInt("price");
                int deposit = resultSet.getInt("deposit");
                String checkInPersonName = resultSet.getString("check_in_person_name");
                String checkInPersonPhoneNumber = resultSet.getString("check_in_person_phone_number");
                int villaId = resultSet.getInt("villa_id");
                int customerCode = resultSet.getInt("customer_code");
                boolean isPending = resultSet.getBoolean("is_pending");
                boolean isDelete = resultSet.getBoolean("is_delete");
                bookingListApproved.add(new Booking(bookingId, checkIn, checkOut, price, deposit,
                        checkInPersonName, checkInPersonPhoneNumber, villaId, customerCode, isPending, isDelete));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingListApproved;
    }

    @Override
    public List<Booking> showListDelete(int findByAccountCode) {
        List<Booking> bookingListDelete = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_DELETE);
            callableStatement.setInt(1, findByAccountCode);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int bookingId = resultSet.getInt("booking_id");
                String checkIn = resultSet.getDate("check_in").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String checkOut = resultSet.getDate("check_out").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int price = resultSet.getInt("price");
                int deposit = resultSet.getInt("deposit");
                String checkInPersonName = resultSet.getString("check_in_person_name");
                String checkInPersonPhoneNumber = resultSet.getString("check_in_person_phone_number");
                int villaId = resultSet.getInt("villa_id");
                int customerCode = resultSet.getInt("customer_code");
                boolean isPending = resultSet.getBoolean("is_pending");
                boolean isDelete = resultSet.getBoolean("is_delete");
                bookingListDelete.add(new Booking(bookingId, checkIn, checkOut, price, deposit,
                        checkInPersonName, checkInPersonPhoneNumber, villaId, customerCode, isPending, isDelete));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingListDelete;
    }

    @Override
    public void save(Booking booking) {
        Connection connection = BaseRepository.getConnection();
        System.out.println("toi repo");
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_BOOKING);
            callableStatement.setDate(1, Date.valueOf(LocalDate.parse(booking.getCheckIn(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
            callableStatement.setDate(2, Date.valueOf(LocalDate.parse(booking.getCheckOut(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
            callableStatement.setInt(3, booking.getPrice());
            callableStatement.setInt(4, booking.getDeposit());
            callableStatement.setString(5, booking.getCheckInPersonName());
            callableStatement.setString(6, booking.getCheckInPersonPhoneNumber());
            callableStatement.setInt(7, booking.getVillaId());
            callableStatement.setInt(8, booking.getCustomerCode());
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int bookingIdUpdate, Booking booking) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_BOOKING);
            callableStatement.setInt(1, bookingIdUpdate);
            callableStatement.setString(2, booking.getCheckInPersonName());
            callableStatement.setString(3, booking.getCheckInPersonPhoneNumber());
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int bookingIdDelete) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_BOOKING);
            callableStatement.setInt(1, bookingIdDelete);
            callableStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
