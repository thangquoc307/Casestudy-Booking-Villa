package controller;

import model.booking.Booking;
import repository.MainPageRepository;
import service.booking.BookingService;
import service.booking.IBookingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "userServlet", value = "/booking")

public class BookingServlet extends HttpServlet {
    private IBookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormCreateBooking":
                showFormCreateBooking(request, response);
                break;
//            case "showFormUpdate":
//                showFormUpdateBooking(request, response);
//                break;
//            case "showListSort":
//                showListSort(request, response);
            case "showListApproved":
                showListApproved(request, response);
                break;
            case "showListDelete":
                showListDelete(request, response);
                break;
            default:
                showListPending(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createBooking":
                createBooking(request, response);
                break;
            case "updateBooking":
                updateBooking(request, response);
                break;
            case "deleteBooking":
                deleteBooking(request, response);
                break;
        }
    }

    private void showListApproved(HttpServletRequest request, HttpServletResponse response) {
        List<Booking> bookingListApproved = bookingService.showListApproved();
        request.setAttribute("bookingList",bookingListApproved);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/booking-list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showListPending(HttpServletRequest request, HttpServletResponse response) {
        List<Booking> bookingListPending = bookingService.showListPending();
        request.setAttribute("bookingList",bookingListPending);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/booking-list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListDelete(HttpServletRequest request, HttpServletResponse response) {
        List<Booking> bookingListDelete = bookingService.showListDelete();
        request.setAttribute("bookingList",bookingListDelete);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/booking-list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreateBooking(HttpServletRequest request, HttpServletResponse response){
//        int accountId = MainPageController.getAccount();
//        int villaId = Integer.parseInt(request.getParameter("index"));
//        Account account = bookingService.findByIdAccount();
//        Villa villa = bookingService.findByIdVilla();
//        request.setAttribute("account",account);
//        request.setAttribute("villa",villa);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/booking.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createBooking(HttpServletRequest request, HttpServletResponse response){
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        int price = Integer.parseInt(request.getParameter("price"));
        int deposit = Integer.parseInt(request.getParameter("deposit"));
        String checkInName = request.getParameter("checkInName");
        String checkInPhoneNumber = request.getParameter("checkInPhoneNumber");
        int villaId = Integer.parseInt(request.getParameter("villaId"));
        int customerCode = Integer.parseInt(request.getParameter("customerCode"));
        bookingService.save(new Booking(checkIn,checkOut,price,deposit,checkInName,checkInPhoneNumber,
                villaId,customerCode));
        try {
            response.sendRedirect("/booking");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response){
        int bookingIdUpdate = Integer.parseInt(request.getParameter("bookingIdUpdate"));
        String checkInPersonNameUpdate = request.getParameter("checkInPersonNameUpdate");
        String checkInPersonPhoneNumberUpdate = request.getParameter("checkInPersonPhoneNumberUpdate");
        bookingService.update(bookingIdUpdate, new Booking(checkInPersonNameUpdate,checkInPersonPhoneNumberUpdate));
        try {
            response.sendRedirect("/booking");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteBooking(HttpServletRequest request, HttpServletResponse response){
        int bookingIdDelete = Integer.parseInt(request.getParameter("bookingIdDelete"));
        bookingService.delete(bookingIdDelete);
        try {
            response.sendRedirect("/booking");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
