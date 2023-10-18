/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAOs.productDAO;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoadProductControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String amountP = request.getParameter("exits");
        int amount = Integer.parseInt(amountP);
        productDAO dao = new productDAO();
        
        List<Product> listp = dao.getNext8Product(amount);
        PrintWriter out = response.getWriter();
        for (Product o : listp) {
            out.println(" <div class=\"product col mb-5\">\n"
                    + "                                <div class=\"card h-100\">\n"
                    + "                                    <div class=\"badge bg-dark text-white position-absolute\" style=\"top: 0.5rem; right: 0.5rem\">Sale</div>\n"
                    + "                                    <img class=\"card-img-top\" src=\""+o.getProduct_pic()+"\" alt=\"...\" />\n"
                    + "                                    <div class=\"card-body p-4\">\n"
                    + "                                        <div class=\"text-center\">\n"
                    + "                                            <h5 class=\"fw-bolder\"><a class=\"text-decoration-none text-dark\" href=\"/PRJProject/details/"+o.getProduct_id()+"\">"+o.getProduct_name()+"</a></h5>\n"
                    + "                                            <span class=\"text-muted text-decoration-line-through\">$80.00</span>\n"
                    + "                                            $"+o.getPrice()+"\n"
                    + "                                            <h5 class=\"fw-bolder\">"+o.getProduct_color()+"</h5>\n"
                    + "                                        </div>\n"
                    + "                                    </div>\n"
                    + "                                    <div class=\"card-footer p-4 pt-0 border-top-0 bg-transparent\">\n"
                    + "                                        <div class=\"text-center\"><a class=\"btn btn-outline-dark mt-auto\" href=\"/PRJProject/buy?id="+o.getProduct_id()+"&num=1\">Add to cart</a></div>\n"
                    + "                                    </div>\n"
                    + "                                </div> \n"
                    + "                            </div>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
