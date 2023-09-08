package service.booking;

import controller.MainPageController;
import model.Villa;
import model.booking.Booking;
import repository.booking.BookingRepository;
import repository.booking.IBookingRepository;

import java.util.List;

public class BookingService implements IBookingService {
    private IBookingRepository bookingRepository = new BookingRepository();

    @Override
    public Booking findByBookingId(int bookingId) {
        int findByAccountCode = MainPageController.getAccount();
        System.out.println(findByAccountCode);
        return bookingRepository.findByBookingId(bookingId, findByAccountCode);
    }

    @Override
    public List<String> getInformAccount() {
        return bookingRepository.getInformAccount();
    }

    @Override
    public Villa getInformVillaById(int findByVillaId) {
        return bookingRepository.getInformVillaById(findByVillaId);
    }

    @Override
    public String nameAccount(List<String> informAccountList){
        int findByAccountCode = MainPageController.getAccount();
        String[] strings;
        for (String s:informAccountList){
            strings = s.split(",");
            if (Integer.parseInt(strings[0])==findByAccountCode){
                return strings[1];
            }
        }
        return "";
    }

    @Override
    public String phoneNumberAccount(List<String> informAccountList){
        int findByAccountCode = MainPageController.getAccount();
        String[] strings;
        for (String s:informAccountList){
            strings = s.split(",");
            if (Integer.parseInt(strings[0])==findByAccountCode){
                return strings[2];
            }
        }
        return "";
    }

    @Override
    public List<Booking> showListPending() {
        int findByAccountCode = MainPageController.getAccount();
        System.out.println(findByAccountCode);
        return bookingRepository.showListPending(findByAccountCode);
    }

    @Override
    public List<Booking> showListApproved() {
        int findByAccountCode = MainPageController.getAccount();
        System.out.println(findByAccountCode);
        return bookingRepository.showListApproved(findByAccountCode);
    }

    @Override
    public List<Booking> showListDelete() {
        int findByAccountCode = MainPageController.getAccount();
        System.out.println(findByAccountCode);
        return bookingRepository.showListDelete(findByAccountCode);
    }

    @Override
    public void save(Booking booking) {
        System.out.println("toi service");
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
