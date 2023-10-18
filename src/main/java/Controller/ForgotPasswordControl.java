/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.accountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class ForgotPasswordControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ForgotPasswordControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPasswordControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("forgotpass.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("user");
        String email = request.getParameter("email");
        int kq = 0;
        String pass = ramdomPassWord();

        String to = email;
        String subject = "New Password";
        String body = "<html><body>"
                + "<p>Dear " + username + " ,</p>"
                + "<p>Chúng tôi đã nhận được yêu cầu đặt lại mật khẩu cho tài khoản của bạn trên MyShoesShop. "
                + "<p>Mật khẩu mới của bạn là: " + pass + "</p>"
                + "<p>Trân trọng,<br>"
                + "Đội ngũ cửa hàng</p>"
                + "</body></html>";
        boolean result = sendEmail(to, subject, body);

        if (result) {
            accountDAO dao = new accountDAO();
            request.setAttribute("mess", "Vui lòng kiểm tra Email và đăng nhập lại");
            kq = dao.UpdatePassword(pass, username);
            if (kq != 0) {
                request.getRequestDispatcher("forgotpass.jsp").forward(request, response);
            } else {
                response.sendRedirect("forgotpass.jsp");
            }
        } else {
            response.sendRedirect("forgotpass.jsp");
        }
    }

    private String ramdomPassWord() {
        Random rd = new Random();
        String c = "12356";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int rdIndex = rd.nextInt(c.length());
            char rdChar = c.charAt(rdIndex);
            sb.append(rdChar);
        }
        return sb.toString();
    }

    private boolean sendEmail(String to, String subject, String body) {
        // Cấu hình các thông tin cần thiết để gửi email
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "coffeemyshoeshop@gmail.com";
        String password = "mqwpkeufndccivhn";
        final String finalUsername = username;
        final String finalPassword = password;

        // Thiết lập các thuộc tính cho kết nối SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Tạo đối tượng Authenticator để xác thực người dùng
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(finalUsername, finalPassword);
            }
        };

        // Tạo phiên gửi email
        Session s = Session.getInstance(props, authenticator);

        try {
            // Tạo đối tượng MimeMessage
            MimeMessage message = new MimeMessage(s);

            // Đặt thông tin người gửi và người nhận
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Đặt tiêu đề và nội dung email
            message.setSubject(subject, "UTF-8");
            message.setContent(body, "text/html; charset=UTF-8");

            // Gửi email
            Transport.send(message);

            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
       private String getMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
