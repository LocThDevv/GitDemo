/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.accountDAO;
import DAOs.categoryDAO;
import DAOs.orderDAO;
import DAOs.productDAO;
import Models.Account;
import Models.Cart;
import Models.Category;
import Models.Items;
import Models.Order;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HomeControl extends HttpServlet {

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
        String path = request.getRequestURI();

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
                    session.setAttribute("quantri", ac);
                }
            }
        }

        switch (path) {
            case "/PRJProject/InfoAccount":
                request.getRequestDispatcher("/infoAccount.jsp").forward(request, response);
                break;
        }

        productDAO dao = new productDAO();
        categoryDAO catedao = new categoryDAO();
        //truyen du lieu san pham,san pham moi nhat,category
        List<Product> list4p = dao.get4NewProduct();
        List<Product> listp = dao.pagingProduct(1);
        List<Category> listc = catedao.getAllCategory();
        //phan trang dua tren tong san pham
        int count = dao.countTotalProduct();
        int endPage = count / 8;
        if (count % 8 != 0) {
            endPage++;
        }
        //them items vao cookie
        Cookie[] cookies = request.getCookies();
        String txt = "";
        if (cookies != null) {
            for (Cookie o : cookies) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        Cart cart = new Cart(txt, listp);
        List<Items> listItem = cart.getItems();
        int n;
        if (listItem != null) {
            n = listItem.size();
        } else {
            n = 0;
        }

        request.setAttribute("size", n);
        request.setAttribute("DLoad", count);
        request.setAttribute("endP", endPage);
        request.setAttribute("listC", listc);
        request.setAttribute("list4P", list4p);
        request.setAttribute("listP", listp);
        request.getRequestDispatcher("/home.jsp").forward(request, response);

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
