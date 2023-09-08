package controller;


import model.Customer;
import service.account_service.AccountService;
import service.account_service.IAccountService;
import service.customer_service.CustomerService;
import service.customer_service.ICustomerService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@WebServlet(name = "ForgotPasswordServlet", value = "/forgot-password")
public class UserForgotPasswordServlet extends HttpServlet {
    private static IAccountService accountService = new AccountService();
    private static ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "sendEmail":
                String content = generateRandomNumbers();
                String email = request.getParameter("email");
                HttpSession session = request.getSession();
                session.setAttribute("content", content);
                session.setAttribute("email",email);
                Customer customer = iCustomerService.getCustomerByEmail(email);
                if (customer != null) {
                    sendEmail("bondatfpt@gmail.com", "sfnpcaifbvtrdgbb", email, content);
                    request.setAttribute("message","Chúng tôi đã gửi một gmail đến địa chỉ " + email);
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else {
                    request.setAttribute("message","Email không tồn tại");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
                break;
            case "showFormGetPassword":
                request.getRequestDispatcher("forgot-password-user.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String content = (String) session.getAttribute("content");
        String email = (String) session.getAttribute("email");
        String contentConfirm = request.getParameter("randomNumber");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        if (content.equals(contentConfirm)){
            accountService.getPassword(password,email);
            response.sendRedirect("login.jsp");
        }else {
            request.setAttribute("ranDomNumberError","Mã xác nhận không đúng");
            request.getRequestDispatcher("forgot-password-user.jsp").forward(request,response);
        }

    }

    private void sendEmail(String senderEmail, String senderPassword, String recipientEmail, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            try {
                message.setSubject(MimeUtility.encodeText("Thư lấy lại mật khẩu", "UTF-8", "B"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            String jspLink = "http://localhost:8080/forgot-password?action=showFormGetPassword";
            String htmlContent = "<html><body>";
            htmlContent += "<h1>Xin chào! Tôi là admin trang web bookingvilla.com</h1>";
            htmlContent += "<p>Đây là một email gửi tự động có nội dung là 6 số ngẫu nhiên để lấy lại mật khẩu.</p>";
            htmlContent += "<p>Click vào <a href=\"" + jspLink + "\">đây</a> và nhập 6 số sau để lấy lại mật khẩu:</p>";
            htmlContent += "<p><strong>" + content + "</strong></p>";
            htmlContent += "</body></html>";

            message.setContent(htmlContent, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String generateRandomNumbers() {
        int min = 100000;
        int max = 999999;
        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
        return String.valueOf(randomNum);
    }
}
