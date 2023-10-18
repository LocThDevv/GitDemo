/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.customerDAO;
import DAOs.orderDAO;
import DAOs.orderdetailsDAO;
import DAOs.productDAO;
import Models.Account;
import Models.Cart;
import Models.Customer;
import Models.Order;
import Models.OrderDeltail;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
public class CheckoutControl extends HttpServlet {

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
        Cookie[] cookies = request.getCookies();
        String txt = "";
        if (cookies != null) {
            for (Cookie o : cookies) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        if (txt.equals("")) {
            request.getRequestDispatcher("/showcart").forward(request, response);
            return;
        }
        productDAO dao = new productDAO();
        List<Product> listp = dao.getAllProduct();
        Cart cart = new Cart(txt, listp);
        HttpSession session = request.getSession();
        Account ac = (Account) session.getAttribute("quantri");
        //addcustomer
        String cName = request.getParameter("cname");
        String cEmail = request.getParameter("cemail");
        String cPhone = request.getParameter("cphone");
        String cAddress = request.getParameter("caddress");

        if (ac == null) {
            Customer cus = new Customer(cName, cEmail, cPhone, cAddress, 11);
            customerDAO cusdao = new customerDAO();
            cusdao.AddCustomer(cus);
            Customer cusnew = cusdao.getTop1Customer();
            //addOrder
            orderDAO odao = new orderDAO();
            odao.addOrder(cusnew, cart);
            //get order moi them vao 
            Order OrderNewAdd = odao.getTop1Order();
            orderdetailsDAO daodt = new orderdetailsDAO();

            List<OrderDeltail> oo = daodt.getOrderdetailByOID(OrderNewAdd.getOrder_id());

            List<Product> ListshownameP = new ArrayList<>();
            for (int i = 0; i < oo.size(); i++) {
                Product pp = dao.getProductByPID(oo.get(i).getProduct_id());
                ListshownameP.add(pp);
            }
            String nameP = "";

            for (int i = 0; i < ListshownameP.size(); i++) {
                if (i == 0) {
                    nameP = ListshownameP.get(i).getProduct_name();
                } else {
                    nameP += "<br><b> " + ListshownameP.get(i).getProduct_name()+"</b>";
                }
            }
            Cookie c = new Cookie("cart", "");
            c.setMaxAge(0);
            response.addCookie(c);
            request.getRequestDispatcher("/home").forward(request, response);
            String to = cEmail;
            String subject = "❤️ Cảm ơn bạn đã đặt hàng tại CoffeeMyshoeShop của chúng tôi ❤️";
            String body = "<html><body>"
                    + "<p>Dear <b>" + cusnew.getCustomer_name() + "</b>,</p>"
                    + "<p>❤️ Chúng tôi xin gửi lời cảm ơn chân thành đến bạn vì đã đặt hàng tại cửa hàng của chúng tôi.❤️</p>"
                    + "<p>Mã đơn hàng của bạn là:<b> " + OrderNewAdd.getOrder_id() + "</b></p>"
                    + "<p>Tên Sản Phẩm:<b><br> " + nameP + "</b></p>"
                    + "<p>Tổng giá trị đơn hàng:<b> " + OrderNewAdd.getOrder_total() + "</b>$</p>"
                    + "<p>Đia chỉ giao hàng:<b> " + cusnew.getAddress() + "</b></p>"
                    + "<p>Nếu bạn có bất kỳ câu hỏi hoặc yêu cầu đặc biệt nào, vui lòng liên hệ với chúng tôi. "
                    + "Chúng tôi luôn sẵn lòng hỗ trợ bạn.</p>"
                    + "<p>Xin một lần nữa cảm ơn bạn đã tin tưởng và ủng hộ cửa hàng của chúng tôi.</p>"
                    + "<p>Trân trọng,<br>"
                    + "❤️ Đội ngũ cửa hàng ❤️</p>"
                    + "</body></html>";

            boolean result = sendEmail(to, subject, body);
            request.getRequestDispatcher("/home").forward(request, response);
        } else {
            int ac_id = ac.getAccount_id();
            Customer cus = new Customer(cName, cEmail, cPhone, cAddress, ac_id);
            customerDAO cusdao = new customerDAO();
            cusdao.AddCustomer(cus);
            Customer cusnew = cusdao.getTop1Customer();
            //addOrder
            orderDAO odao = new orderDAO();
            odao.addOrder(cusnew, cart);
            //get order moi them vao 
            Order OrderNewAdd = odao.getTop1Order();
            orderdetailsDAO daodt = new orderdetailsDAO();

            List<OrderDeltail> oo = daodt.getOrderdetailByOID(OrderNewAdd.getOrder_id());

            List<Product> ListshownameP = new ArrayList<>();
            for (int i = 0; i < oo.size(); i++) {
                Product pp = dao.getProductByPID(oo.get(i).getProduct_id());
                ListshownameP.add(pp);
            }
            String nameP = "";

            for (int i = 0; i < ListshownameP.size(); i++) {
                if (i == 0) {
                    nameP = ListshownameP.get(i).getProduct_name();
                } else {
                    nameP += "<br> " + ListshownameP.get(i).getProduct_name();
                }
            }

            Cookie c = new Cookie("cart", "");
            c.setMaxAge(0);
            response.addCookie(c);

            String to = cEmail;
            String subject = "❤️ Cảm ơn bạn đã đặt hàng tại CoffeeMyshoeShop của chúng tôi ❤️";
            String body = "<html><body>"
                    + "<p>Dear <b>" + cusnew.getCustomer_name() + "</b>,</p>"
                    + "<p>❤️ Chúng tôi xin gửi lời cảm ơn chân thành đến bạn vì đã đặt hàng tại cửa hàng của chúng tôi.❤️</p>"
                    + "<p>Mã đơn hàng của bạn là:<b> " + OrderNewAdd.getOrder_id() + "</b></p>"
                    + "<p>Tên Sản Phẩm:<b><br> " + nameP + "</b></p>"
                    + "<p>Tổng giá trị đơn hàng:<b> " + OrderNewAdd.getOrder_total() + "</b>$</p>"
                    + "<p>Đia chỉ giao hàng:<b> " + cusnew.getAddress() + "</b></p>"
                    + "<p>Nếu bạn có bất kỳ câu hỏi hoặc yêu cầu đặc biệt nào, vui lòng liên hệ với chúng tôi. "
                    + "Chúng tôi luôn sẵn lòng hỗ trợ bạn.</p>"
                    + "<p>Xin một lần nữa cảm ơn bạn đã tin tưởng và ủng hộ cửa hàng của chúng tôi.</p>"
                    + "<p>Trân trọng,<br>"
                    + "❤️ Đội ngũ cửa hàng ❤️</p>"
                    + "</body></html>";

            boolean result = sendEmail(to, subject, body);
            request.setAttribute("mesCheck", "Success");
            request.getRequestDispatcher("/Cart.jsp").forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
