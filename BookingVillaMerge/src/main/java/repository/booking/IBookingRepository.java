package repository.booking;

import model.Villa;
import model.booking.Booking;

import java.util.List;

public interface IBookingRepository {
    Booking findByBookingId(int bookingId, int findByAccountCode);
    List<String> getInformAccount();
    Villa getInformVillaById(int findByVillaId);

    List<Booking> showListPending(int findByAccountCode);

    List<Booking> showListApproved(int findByAccountCode);

    List<Booking> showListDelete(int findByAccountCode);

    void save(Booking booking);

    void update(int bookingIdUpdate, Booking booking);

    void delete(int bookingIdDelete);

}
