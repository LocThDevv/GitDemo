/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.accountDAO;
import DAOs.categoryDAO;
import DAOs.productDAO;
import Models.Account;
import Models.Cart;
import Models.Category;
import Models.Items;
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
public class SearchControl extends HttpServlet {

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
            out.println("<title>Servlet SearchControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchControl at " + request.getContextPath() + "</h1>");
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
        String path = request.getRequestURI();
        int lastIndex = path.lastIndexOf("/");
        String value = path.substring(lastIndex + 1);
        if (value == null) {
            response.sendRedirect("/PRJProject/home");
        }
        //tao session dua tren cookie
        HttpSession session = request.getSession();
        boolean foundCookie = false;
        if (session.getAttribute("quantri") == null) {
            String us = "";
            Cookie[] cook = request.getCookies();
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
        switch (value) {
            case "white":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("white");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "white");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "black":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("black");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "black");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "yellow":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("yellow");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "yellow");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "blue":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("blue");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "blue");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "red":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("red");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "red");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "brown":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("brown");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "brown");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "pink":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("pink");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "pink");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;

            case "orange":
                 try {
                productDAO dao = new productDAO();
                categoryDAO catedao = new categoryDAO();
                List<Category> listc = catedao.getAllCategory();
                List<Product> list = dao.searchByColor("orange");

                List<Product> listAll = dao.getAllProduct();
                Cookie[] cookies = request.getCookies();
                String txt = "";
                if (cookies != null) {
                    for (Cookie o : cookies) {
                        if (o.getName().equals("cart")) {
                            txt += o.getValue();
                        }
                    }
                }
                Cart cart = new Cart(txt, listAll);
                List<Items> listItem = cart.getItems();
                int n;
                if (listItem != null) {
                    n = listItem.size();
                } else {
                    n = 0;
                }
                request.setAttribute("size", n);
                request.setAttribute("cate", "orange");
                request.setAttribute("listC", listc);
                request.setAttribute("listP", list);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } catch (Exception e) {
            }
            break;
        }
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

        if (request.getParameter("txt") != null) {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String txtSearch = request.getParameter("txt");

            productDAO dao = new productDAO();
            categoryDAO catedao = new categoryDAO();
            List<Product> list = dao.searchByName(txtSearch);
            List<Product> listAll = dao.getAllProduct();
            List<Category> listc = catedao.getAllCategory();

            Cookie[] cookies = request.getCookies();
            String txt = "";
            if (cookies != null) {
                for (Cookie o : cookies) {
                    if (o.getName().equals("cart")) {
                        txt += o.getValue();
                    }
                }
            }
            Cart cart = new Cart(txt, listAll);
            List<Items> listItem = cart.getItems();
            int n;
            if (listItem != null) {
                n = listItem.size();
            } else {
                n = 0;
            }
            
            //tao session dua tren cookie
            HttpSession session = request.getSession();
            boolean foundCookie = false;
            if (session.getAttribute("quantri") == null) {
                String us = "";
                Cookie[] cook = request.getCookies();
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

            request.setAttribute("size", n);
            request.setAttribute("cate", txtSearch);
            request.setAttribute("listP", list);
            request.setAttribute("listC", listc);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            response.sendRedirect("/PRJProject/home");
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
