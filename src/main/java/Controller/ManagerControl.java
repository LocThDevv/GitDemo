/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.time.LocalDate;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import DAOs.accountDAO;
import DAOs.categoryDAO;
import DAOs.commentDAO;
import DAOs.customerDAO;
import DAOs.orderDAO;
import DAOs.orderdetailsDAO;
import DAOs.productDAO;
import Models.Account;
import Models.Category;
import Models.Customer;
import Models.Order;
import Models.OrderDeltail;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class ManagerControl extends HttpServlet {

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
//         try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CategoryControl</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CategoryControl at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        //tao session dua tren cookie
        HttpSession session = request.getSession();
        if (session.getAttribute("quantri") == null) {
            String us = "";
            Cookie[] cook = request.getCookies();
            boolean foundCookie = false;
            if (cook != null) {
                for (Cookie c : cook) {
                    if (c.getName().equals("quantri")) {
                        foundCookie = true;
                        us = c.getValue();
                        break;
                    }
                }
                accountDAO acdao = new accountDAO();
                Account ac = acdao.getAccountByUS(us);
                if (ac != null) {
                    if (ac.getIsAdmin() == 1) {
                        session.setAttribute("quantri", ac);
                    } else {
                        response.sendRedirect("/PRJProject/home");
                    }
                }
            }
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

        productDAO dao = new productDAO();
        categoryDAO catedao = new categoryDAO();
        List<Product> listp = dao.getAllProduct();
        List<Category> listc = catedao.getAllCategory();

        request.setAttribute("listP", listp);
        request.setAttribute("listC", listc);
        String path = request.getRequestURI();

        switch (path) {
            case "/PRJProject/manager":
                request.setAttribute("mana", "choose");
                request.getRequestDispatcher("/managerProduct.jsp").forward(request, response);
                break;
            case "/PRJProject/manager/New":
                request.getRequestDispatcher("/themmoi.jsp").forward(request, response);
                break;
            case "/PRJProject/manager/ShowOrder":
                orderDAO ordao = new orderDAO();
                List<Order> orderList = ordao.getAllOrder();
                request.setAttribute("ord", "choose");
                request.setAttribute("listOr", orderList);
                request.getRequestDispatcher("/showOrder.jsp").forward(request, response);
                break;
            case "/PRJProject/manager/Account":
                accountDAO acdao = new accountDAO();
                List<Account> listA = acdao.getAllAccount();
                request.setAttribute("ac", "choose");
                request.setAttribute("listAc", listA);
                request.getRequestDispatcher("/managerAccount.jsp").forward(request, response);
                break;
            case "/PRJProject/manager/Account/NewAccount":
                request.setAttribute("ac", "choose");
                request.getRequestDispatcher("/addAccount.jsp").forward(request, response);
                break;

            case "/PRJProject/manager/monthRevenue":
                orderDAO or = new orderDAO();
                List<Order> listRevenue = or.monthlyRevenue();
                request.setAttribute("mth", "choose");
                request.setAttribute("listRevenue", listRevenue);
                request.getRequestDispatcher("/MonthRevenue.jsp").forward(request, response);
                break;
            case "/PRJProject/manager/top5Customer":
                customerDAO custdao = new customerDAO();
                List<Customer> listTop5cus = custdao.getTop5Customer();
                request.setAttribute("cus", "choose");
                request.setAttribute("listTop5cus", listTop5cus);
                request.getRequestDispatcher("/top5Cus.jsp").forward(request, response);
                break;

        }
        String[] s = path.split("/");
        String action = s[s.length - 2]; // lay sau dau "/"
        String pro_id = URLDecoder.decode(s[s.length - 1], "UTF-8");
        switch (action) {
            case "Edit":
                try {
                int pid = Integer.parseInt(pro_id);
                productDAO pdao = new productDAO();
                Product p = pdao.getProductByPID(pid);
                if (p == null) {
                    response.sendRedirect("/PRJProject/manager");
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("IDProduct", p);
                    request.getRequestDispatcher("/update.jsp").forward(request, response);
                }
            } catch (Exception e) {
            }
            break;

            case "Delete":
                int PID = Integer.parseInt(pro_id);
                productDAO daoDel = new productDAO();
                commentDAO comdao = new commentDAO();
                orderdetailsDAO taildaoo = new orderdetailsDAO();
                comdao.DeleteComment(PID);
                taildaoo.DeleteDetailsByPID(PID);
                daoDel.DeleteProduct(pro_id);
                response.sendRedirect("/PRJProject/manager");
                break;

            case "DeleteAccount":
                try {
                int ac_id = Integer.parseInt(pro_id);
                commentDAO commdao = new commentDAO();
                accountDAO aadao = new accountDAO();
                Account aa = aadao.getAccountByAcID(ac_id);
                commdao.DeleteCommentByUs(aa.getUsername());
                orderdetailsDAO taildao = new orderdetailsDAO();
                orderDAO ordao = new orderDAO();
                int or_id = ordao.getOrderByAC(ac_id);
                taildao.DeleteDetails(or_id);
                ordao.DeleteOrder(or_id);
                accountDAO daoac = new accountDAO();
                daoac.DeleteAccount(ac_id);
                response.sendRedirect("/PRJProject/manager/Account");
            } catch (Exception e) {
            }
            break;

            case "EditAccount":
                try {
                int ac_id = Integer.parseInt(pro_id);
                accountDAO adao = new accountDAO();
                Account ac = adao.getAccountByAcID(ac_id);
                HttpSession session = request.getSession();
                request.setAttribute("ac", "choose");
                session.setAttribute("checkS", ac.getIsSell());
                session.setAttribute("checkA", ac.getIsAdmin());
                session.setAttribute("EditAC", ac);
                request.getRequestDispatcher("/editAccountByAD.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "Info":
                try {
                productDAO daoInfo = new productDAO();
                int pid = Integer.parseInt(pro_id);
                Product pInfo = daoInfo.getProductByPID(pid);
                if (pInfo == null) {
                    response.sendRedirect("/listProduct");
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("InfoProduct", pInfo);
                    request.setAttribute("mana", "choose");
                    request.getRequestDispatcher("/info.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
            }
            break;

            case "Details":
              try {
                int detailID = Integer.parseInt(pro_id);
                productDAO POdao = new productDAO();

                orderdetailsDAO dtdao = new orderdetailsDAO();
                List<OrderDeltail> detailList = dtdao.getOrderdetailByOID(detailID);
                request.setAttribute("listTails", detailList);
                String proName = "";
                List<Product> adao = new ArrayList<>();
                for (int i = 0; i < detailList.size(); i++) {
                    Product ppdao = POdao.getProductByPID(detailList.get(i).getProduct_id());
                    adao.add(ppdao);
                }
                HttpSession session = request.getSession();
                request.setAttribute("ord", "choose");
                session.setAttribute("proID", pro_id);
                request.setAttribute("infoProduct", adao);
                request.getRequestDispatcher("/showOrderDetails.jsp").forward(request, response);
                break;
            } catch (Exception e) {
            }

            case "fileExcel":
              try {
                // tao workbook moi 
                Workbook workbook = new XSSFWorkbook();

                // Tạo một trang tính mới 
                Sheet sheet = workbook.createSheet("Hóa đơn");

                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Họ và Tên");
                headerRow.createCell(1).setCellValue("Tên Sản Phẩm");
                headerRow.createCell(2).setCellValue("Màu Sắc");
                headerRow.createCell(3).setCellValue("Đơn Giá");
                headerRow.createCell(4).setCellValue("Số Lượng");
                headerRow.createCell(5).setCellValue("Tổng");

                int rowCount = 1; // bat dau tu dong thu 2 (sau dong tieu de)
                try {
                    int detailID = Integer.parseInt(pro_id);
                    customerDAO cusdao = new customerDAO();
                    int cusid = cusdao.getCustomerIDByOR(detailID);
                    double total = 0;
                    String cusname = cusdao.getCustomerNameByID(cusid);
                    productDAO POdao = new productDAO();

                    orderdetailsDAO dtdao = new orderdetailsDAO();
                    List<OrderDeltail> detailList = dtdao.getOrderdetailByOID(detailID);
                    request.setAttribute("listTails", detailList);
                    String proName = "";
                    List<Product> adao = new ArrayList<>();
                    for (int i = 0; i < detailList.size(); i++) {
                        Product ppdao = POdao.getProductByPID(detailList.get(i).getProduct_id());
                        adao.add(ppdao);
                    }
                    for (int i = 0; i < detailList.size(); i++) {
                        Row row = sheet.createRow(rowCount++);
                        row.createCell(0).setCellValue(cusname);
                        row.createCell(1).setCellValue(adao.get(i).getProduct_name());
                        row.createCell(2).setCellValue(adao.get(i).getProduct_color());
                        row.createCell(3).setCellValue(adao.get(i).getPrice());
                        row.createCell(4).setCellValue(detailList.get(i).getQuantity());
                        double totalPrice = adao.get(i).getPrice() * detailList.get(i).getQuantity();
                        total += totalPrice;
                    }
                    Row totalRow = sheet.createRow(rowCount++);
                    Cell totalCell = totalRow.createCell(5);
                    totalCell.setCellValue(total);
                    // ghi file
                    try {
                        LocalDate curdate = LocalDate.now();
                        String date = curdate.toString();
                        String filePath = "C:\\Users\\Admin\\Documents\\HoaDonWebBanGiay\\" + date + "_" + detailID + "hoadon.xlsx";
                        FileOutputStream fileOut = new FileOutputStream(filePath);
                        workbook.write(fileOut);
                        fileOut.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("proID", pro_id);
                    request.setAttribute("infoProduct", adao);
                    request.setAttribute("messAdd", "Xuất dữ liệu sang File Excel Thành Công");
                    request.setAttribute("ord", "choose");
                    request.getRequestDispatcher("/showOrderDetails.jsp").forward(request, response);
                } catch (Exception e) {
                }
            } catch (Exception e) {
            }

        }

//        request.getRequestDispatcher("/managerProduct.jsp").forward(request, response);
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
        if (request.getParameter("btnSubmit") != null && request.getParameter("btnSubmit").equals("Add")) {
            try {
                String product_name = request.getParameter("pro_name");
                int stock_quantity = Integer.parseInt(request.getParameter("pro_quan"));
                int price = Integer.parseInt(request.getParameter("pro_price"));
                Part part = request.getPart("pro_pic");
                String fileName = part.getSubmittedFileName();
                if (!(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".webp"))) {
                    productDAO dao = new productDAO();
                    categoryDAO catedao = new categoryDAO();
                    List<Product> listp = dao.getAllProduct();
                    List<Category> listc = catedao.getAllCategory();

                    request.setAttribute("listP", listp);
                    request.setAttribute("listC", listc);
                    String path = request.getRequestURI();
                    request.setAttribute("mes", "Vui lòng chọn file có đuôi .jpg, png hoặc webp");
                    request.getRequestDispatcher("/managerProduct.jsp").forward(request, response);
                    return;
                }
                String uploadPath = "D:\\PRJ301\\PRJProject\\PRJProject\\src\\main\\webapp\\" + "images";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                String filePath = uploadPath + "/" + fileName;
                part.write(filePath);
                String product_pic = "/PRJProject/images" + "/" + fileName;
                String des = request.getParameter("pro_des");
                String product_color = request.getParameter("pro_color");
                int category_id = Integer.parseInt(request.getParameter("category"));
                productDAO dao = new productDAO();
                Product p = new Product(product_name, product_pic, product_color, price, stock_quantity, des, category_id);
                int kq = dao.AddNewProduct(p);
                if (kq != 0) {
                    response.sendRedirect("/PRJProject/manager");
                } else {
                    response.sendRedirect("/PRJProject/manager/New");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //update
        if (request.getParameter("btnSubmit") != null && request.getParameter("btnSubmit").equals("Update")) {
            try {
                HttpSession session = request.getSession();
                Product pid = (Product) session.getAttribute("IDProduct");
                String product_name = request.getParameter("pro_name");
                int stock_quantity = Integer.parseInt(request.getParameter("pro_quan"));
                int price = Integer.parseInt(request.getParameter("pro_price"));
                Part part = request.getPart("pro_pic");
                String fileName = part.getSubmittedFileName();
                if (!(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".webp"))) {
                    productDAO dao = new productDAO();
                    categoryDAO catedao = new categoryDAO();
                    List<Product> listp = dao.getAllProduct();
                    List<Category> listc = catedao.getAllCategory();

                    request.setAttribute("listP", listp);
                    request.setAttribute("listC", listc);
                    String path = request.getRequestURI();
                    request.setAttribute("mes", "Vui lòng chọn file có đuôi .jpg, png hoặc webp");
                    try {
                        productDAO pdao = new productDAO();
                        Product p = pdao.getProductByPID(pid.getProduct_id());
                        if (p == null) {
                            response.sendRedirect("/PRJProject/manager");
                        } else {
                            session.setAttribute("IDProduct", p);
                            request.getRequestDispatcher("/update.jsp").forward(request, response);
                        }
                    } catch (Exception e) {
                    }
                    request.getRequestDispatcher("/update.jsp").forward(request, response);
                    return;
                }
                String uploadPath = "D:\\PRJ301\\PRJProject\\PRJProject\\src\\main\\webapp\\" + "images";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                String filePath = uploadPath + "/" + fileName;
                part.write(filePath);
                String product_pic = "/PRJProject/images" + "/" + fileName;
                String des = request.getParameter("pro_des");
                String product_color = request.getParameter("pro_color");
                int category_id = Integer.parseInt(request.getParameter("category"));
                productDAO dao = new productDAO();

                Product p = new Product(pid.getProduct_id(), product_name, product_pic, product_color, price, stock_quantity, des, category_id);
                int kq = dao.UpdateProduct(p);
                if (kq != 0) {
                    response.sendRedirect("/PRJProject/manager");
                } else {
                    response.sendRedirect("/PRJProject/manager/edit/" + pid.getProduct_id());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (request.getParameter("btnSubmit") != null && request.getParameter("btnSubmit").equals("addAdmin")) {
            try {
                int kq = 0;
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                String re_pass = request.getParameter("re_pass");
                String email = request.getParameter("email");
                String check = request.getParameter("check");
                int partCheck = Integer.parseInt(check);
                String phone = request.getParameter("phone");
                String fullname = request.getParameter("fullname");
                int checkname = 0;
                accountDAO acdao = new accountDAO();
                List<Account> list = acdao.getAllAccount();
                for (Account o : list) {
                    if (o.getUsername().equals(user)) {
                        checkname = 1;
                    }
                }
                if (checkname == 1) {
                    request.setAttribute("messCPF", "Tên đăng nhập đã tồn tại");
                    request.setAttribute("ac", "choose");
                    request.getRequestDispatcher("addAccount.jsp").forward(request, response);
                }
                if (re_pass.equals(pass)) {

                    if (partCheck == 1) {
                        Account ac = new Account(user, getMD5Hash(pass), phone, email, 0, 1, fullname);
                        accountDAO dao = new accountDAO();
                        kq = dao.addAccountByAdmin(ac);
                    } else {
                        if (partCheck == 0) {
                            Account ac = new Account(user, getMD5Hash(pass), phone, email, 1, 0, fullname);
                            accountDAO dao = new accountDAO();
                            kq = dao.addAccountByAdmin(ac);
                        }
                    }

                    if (kq != 0) {
                        request.setAttribute("messAdd", "Xin chúc mừng! bạn đã cập nhật tài khoản thành công.");
                        response.sendRedirect("/PRJProject/manager/Account");
                    } else {
                        request.setAttribute("messCPF", "Đăng ký tài khoản thất bại");
                        request.setAttribute("ac", "choose");
                        request.getRequestDispatcher("addAccount.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("messCPF", "Nhập lại! Mật khẩu không đúng.");
                    request.setAttribute("ac", "choose");
                    request.getRequestDispatcher("addAccount.jsp").forward(request, response);
                }
            } catch (Exception e) {
            }
        }
        //updateByAD
        if (request.getParameter("btnSubmit") != null && request.getParameter("btnSubmit").equals("editAccountByAD")) {
            try {
                int kq = 0;
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                String re_pass = request.getParameter("re_pass");
                String email = request.getParameter("email");
                String check = request.getParameter("check");
                int partCheck = Integer.parseInt(check);
                String phone = request.getParameter("phone");
                String fullname = request.getParameter("fullname");
                int checkname = 0;
                HttpSession session = request.getSession();
                Account ad = (Account) session.getAttribute("EditAC");
                accountDAO acdao = new accountDAO();
                List<Account> list = acdao.getAllAccount();
                for (Account o : list) {
                    if (o.getUsername().equals(user)) {
                        checkname = 1;
                    }
                }
                if (user.equals(ad.getUsername())) {
                    checkname = 0;
                }
                if (checkname == 1) {
                    request.setAttribute("messCPF", "Tên đăng nhập đã tồn tại");
                    request.setAttribute("ac", "choose");
                    request.getRequestDispatcher("editAccountByAD.jsp").forward(request, response);
                }
                if (re_pass.equals(pass)) {

                    if (partCheck == 1) {
                        Account ac = new Account(ad.getAccount_id(), user, getMD5Hash(pass), phone, email, 0, 1, fullname);
                        accountDAO dao = new accountDAO();
                        kq = dao.UpdateAccountByAD(ac);
                    } else {
                        if (partCheck == 0) {
                            Account ac = new Account(ad.getAccount_id(), user, getMD5Hash(pass), phone, email, 1, 0, fullname);
                            accountDAO dao = new accountDAO();
                            kq = dao.UpdateAccountByAD(ac);
                        }
                    }

                    if (kq != 0) {
                        request.setAttribute("messAdd", "Xin chúc mừng! bạn đã cập nhật tài khoản thành công.");
                        response.sendRedirect("/PRJProject/manager/Account");
                    } else {
                        request.setAttribute("messCPF", "Cập nhật tài khoản thất bại");
                        request.setAttribute("ac", "choose");
                        request.getRequestDispatcher("editAccountByAD.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("messCPF", "Nhập lại! Mật khẩu không đúng.");
                    request.setAttribute("ac", "choose");
                    request.getRequestDispatcher("editAccountByAD.jsp").forward(request, response);
                }
            } catch (Exception e) {
            }
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
