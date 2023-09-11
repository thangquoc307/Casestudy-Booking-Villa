package repository.admin_booking;

import model.Booking;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {
    private static final String SELECT_BOOKING = "select * from bookings where is_delete =0 " +
            "order by `booking_time` ";
    private static final String UPDATE_BOOKING = "call approved_booking(?) ";
    private static final String DELETE_BOOKING = "call delete_booking(?) ";

    @Override
    public List<Booking> getAllBooking() {
        Connection connection = BaseRepository.getConnection();
        List<Booking> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("booking_id");
                String checkIn = resultSet.getDate("check_in").toLocalDate().format(DateTimeFormatter.ISO_DATE.ofPattern("dd/MM/yyyy"));
                String checkOut = resultSet.getDate("check_out").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String bookingDate = resultSet.getDate("booking_time").toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//                Date checkIn = resultSet.getDate("check_in");
//                Date checkOut = resultSet.getDate("check_out");
                int price = resultSet.getInt("price");
                int deposit = resultSet.getInt("deposit");
                String checkInPersonName = resultSet.getString("check_in_person_name");
                String checkInPersonPhoneNumber = resultSet.getString("check_in_person_phone_number");
                int villaId = resultSet.getInt("villa_id");
                int customerCode = resultSet.getInt("customer_code");
                boolean isPending = resultSet.getBoolean("is_pending");
                list.add(new Booking(id, checkIn, checkOut,bookingDate, price, deposit, checkInPersonName, checkInPersonPhoneNumber,
                        villaId, customerCode, isPending));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updateBooking(int bookingIdApproved) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKING);
            preparedStatement.setInt(1, bookingIdApproved);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBooking(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKING);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
