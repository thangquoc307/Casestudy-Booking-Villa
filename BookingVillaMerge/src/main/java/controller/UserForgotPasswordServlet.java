package controller;


import model.Account;
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
    private static int emailCount = 0;
    private static final long TIME_LIMIT = 1 * 60 * 1000;
    private static long lastEmailTime = 0;
    private boolean hasSentEmail = false;
    private static final long CONTENT_EXPIRATION = 1 * 60 * 1000;

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
                HttpSession session = request.getSession();
                String email = request.getParameter("email");
                session.setAttribute("email", email);
                Customer customer = iCustomerService.getCustomerByEmail(email);
                Account account = accountService.getUserNameByEmail(email);
                session.setAttribute("userName", account.getUserName());

                if (session.getAttribute("emailSent") != null) {
                    String attributeValue = "Email đã được gửi trong phiên làm việc hiện tại";
                    String jsonResponse = "{\"attribute\":\"" + attributeValue + "\"}";
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(jsonResponse);
                } else {
                    long currentTime = System.currentTimeMillis();
                    if (customer != null && currentTime - lastEmailTime > TIME_LIMIT) {
                        String content = generateRandomNumbers();
                        session.setAttribute("content", content);
                        sendEmail("bondatfpt@gmail.com", "sfnpcaifbvtrdgbb", email, content);
                        lastEmailTime = System.currentTimeMillis();
                        long contentSentTime = System.currentTimeMillis();
                        session.setAttribute("contentSentTime", contentSentTime);
                        session.setAttribute("emailSent", true);
                        String attributeValue = "Chúng tôi đã gửi một email đến địa chỉ email: " + email;
                        String jsonResponse = "{\"attribute\":\"" + attributeValue + "\"}";
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(jsonResponse);
                    } else {
                        String attributeValue = "Email không tồn tại trong hệ thống trang web hoặc không đúng";
                        String jsonResponse = "{\"attribute\":\"" + attributeValue + "\"}";
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(jsonResponse);
                    }
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
        long confirmContent = System.currentTimeMillis();
        long contentSentTime = (long) session.getAttribute("contentSentTime");
        if (confirmContent - contentSentTime >= CONTENT_EXPIRATION) {
            String content = generateRandomNumbers();
            contentSentTime = System.currentTimeMillis();
            session.setAttribute("content", content);
            session.setAttribute("contentSentTime", contentSentTime);
        }
        String content = (String) session.getAttribute("content");
        String email = (String) session.getAttribute("email");
        String contentConfirm = request.getParameter("randomNumber");
        String password = request.getParameter("password");
        if (content.equals(contentConfirm)) {
            accountService.getPassword(password, email);
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("ranDomNumberError", "Mã xác nhận không đúng");
            request.getRequestDispatcher("forgot-password-user.jsp").forward(request, response);
        }
    }

    private void sendEmail(String senderEmail, String senderPassword, String recipientEmail, String content) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastEmailTime < TIME_LIMIT) {
            return;
        } else if (hasSentEmail) {
            return;
        }

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
            htmlContent += " Mã xác nhận này chỉ có hiệu lực trong vòng 1 phút từ khi gửi đi.</p>";
            htmlContent += "<p>Click vào <a href=\"" + jspLink + "\">đây</a> và nhập 6 số sau để lấy lại mật khẩu:</p>";
            htmlContent += "<p><strong>" + content + "</strong></p>";
            htmlContent += "</body></html>";

            message.setContent(htmlContent, "text/html;charset=UTF-8");
            Transport.send(message);

            lastEmailTime = currentTime;
            emailCount++;
            hasSentEmail = true;

        } catch (MessagingException e) {
            e.printStackTrace();
            hasSentEmail = false;

        }
    }

    private String generateRandomNumbers() {
        int min = 100000;
        int max = 999999;
        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
        return String.valueOf(randomNum);
    }
}
