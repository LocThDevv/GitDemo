/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Cart;
import Models.Customer;
import Models.Items;
import Models.Order;
import Models.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class orderDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public orderDAO() {
        conn = DBConnection.DbConnection.getConnection();
    }

    //addorder
    public void addOrder(Customer c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //addorder
            String sql = "insert into [order] values(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getAccount_id());
            ps.setString(2, date);
            ps.setDouble(3, cart.getTotalPrice());
            ps.setInt(4, c.getCustomer_id());
            ps.executeUpdate();
            //lay id order moi add
            String sql1 = "select top 1 order_id from [Order] order by order_id desc";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rss = ps1.executeQuery();
            //add orderDetails
            if (rss.next()) {
                int oid = rss.getInt("order_id");
                for (Items i : cart.getItems()) {
                    String sql2 = "insert into [orderdetail] values(?,?,?,?)";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setInt(1, oid);
                    ps2.setInt(2, i.getProduct().getProduct_id());
                    ps2.setDouble(3, i.getPrice());
                    ps2.setInt(4, i.getQuantity());
                    ps2.executeUpdate();
                }
            }
            //update soluong san pham
            String sql3 = "update product set stock_quantity = stock_quantity-? where id=?";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            for (Items i : cart.getItems()) {
                ps3.setInt(1, i.getQuantity());
                ps3.setInt(2, i.getProduct().getProduct_id());
                ps3.executeUpdate();
            }
        } catch (Exception e) {

        }
    }

    //getall
    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [order]";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //getbyID
    public List<Order> getOrderByID(int orderID) {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [order] where order_id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//gettop1

    public Order getTop1Order() {
        String sql = "select top 1 * from [order] order by order_id desc";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //doanh thu theo thang
    public List<Order> monthlyRevenue() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT MONTH(order_date) AS month, SUM(order_total) AS revenue\n"
                + "FROM [order]\n"
                + "GROUP BY MONTH(order_date) ORDER BY MONTH(order_date) DESC";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     //Delete Order
    public int DeleteOrder(int id) {
        int kq = 0;
        String sql = "delete from [Order] where order_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
      //get Order
    public int getOrderByAC(int id) {
        rs = null;
        int kq = 0;
        String sql = "select order_id from [order] where account_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                kq = rs.getInt("order_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    public static void main(String[] args) {
        orderDAO or = new orderDAO();
        List<Order>  list = or.monthlyRevenue();
        for (Order o : list) {
            System.out.println(o.getTotalRevenue());
        }
    }

}
