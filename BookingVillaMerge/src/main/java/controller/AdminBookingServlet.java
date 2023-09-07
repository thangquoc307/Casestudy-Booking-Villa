package controller;

import model.Booking;
import service.admin_booking.BookingService;
import service.admin_booking.IBookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminBookingServlet", value = "/admin-booking")
public class AdminBookingServlet extends HttpServlet {
    private IBookingService service = new BookingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "getAllBooking":
                getAllBooking(req, resp);
                break;
            default:
                break;
        }
    }

    private void getAllBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Booking> list = service.getAllBooking();
        System.out.println(list);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/booking-admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "updateBooking":
                updateBooking(req, resp);
                break;
            case "deleteBooking":
                deleteBooking(req, resp);
                getAllBooking(req, resp);

                break;
            default:
                break;
        }
    }

    private void updateBooking(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("bookingIdApproved"));
        service.updateBooking(id);
        resp.sendRedirect("/admin-booking?action=getAllBooking");
    }

    private void deleteBooking(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id_delete"));
        service.deleteBooking(id);
//        resp.sendRedirect("/booking");
    }
}
