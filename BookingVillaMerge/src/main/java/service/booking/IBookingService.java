package service.booking;

import model.Villa;
import model.booking.Booking;

import java.util.List;

public interface IBookingService {
    Booking findByBookingId(int bookingId);
    List<String> getInformAccount();
    Villa getInformVillaById(int findByVillaId);
    String nameAccount(List<String> informAccountList);
    String phoneNumberAccount(List<String> informAccountList);

    List<Booking> showListPending();

    List<Booking> showListApproved();

    List<Booking> showListDelete();

    void save(Booking booking);

    void update(int bookingIdUpdate, Booking booking);

    void delete(int bookingIdDelete);
}
