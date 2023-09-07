package service.booking;

import controller.MainPageController;
import model.booking.Booking;
import repository.booking.BookingRepository;
import repository.booking.IBookingRepository;

import java.util.List;

public class BookingService implements IBookingService {
    private IBookingRepository bookingRepository = new BookingRepository();

    @Override
    public Booking findByBookingId(int bookingId) {
        int findByAccountCode = MainPageController.getAccount();
        System.out.println("find");
        System.out.println(findByAccountCode);
        return bookingRepository.findByBookingId(bookingId, findByAccountCode);
    }

    @Override
    public List<Booking> showListPending() {
        int findByAccountCode = MainPageController.getAccount();
        System.out.println("pend");
        System.out.println(findByAccountCode);
        return bookingRepository.showListPending(findByAccountCode);
    }

    @Override
    public List<Booking> showListApproved() {
        int findByAccountCode = MainPageController.getAccount();
        System.out.println("appp");
        System.out.println(findByAccountCode);
        return bookingRepository.showListApproved(findByAccountCode);
    }

    @Override
    public List<Booking> showListDelete() {
        System.out.println("de");
        int findByAccountCode = MainPageController.getAccount();
        System.out.println(findByAccountCode);
        return bookingRepository.showListDelete(findByAccountCode);
    }

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void update(int bookingIdUpdate, Booking booking) {
        bookingRepository.update(bookingIdUpdate, booking);
    }

    @Override
    public void delete(int bookingIdDelete) {
        bookingRepository.delete(bookingIdDelete);
    }
}
