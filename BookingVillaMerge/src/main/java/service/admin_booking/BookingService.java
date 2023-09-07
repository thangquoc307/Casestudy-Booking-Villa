package service.admin_booking;

import model.Booking;
import repository.admin_booking.BookingRepository;
import repository.admin_booking.IBookingRepository;


import java.util.List;

public class BookingService implements IBookingService {
    private IBookingRepository repository = new BookingRepository();
    @Override
    public List<Booking> getAllBooking() {
        return repository.getAllBooking();
    }

    @Override
    public void updateBooking(int bookingIdApproved) {
        repository.updateBooking(bookingIdApproved);
    }

    @Override
    public void deleteBooking(int id) {
        repository.deleteBooking(id);
    }
}
