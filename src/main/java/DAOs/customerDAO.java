/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Customer;
import Models.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class customerDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public customerDAO() {
        conn = DBConnection.DbConnection.getConnection();
    }

    public int AddCustomer(Customer c) {
        int kq = 0;
        String sql = "insert into [customer] values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCustomer_name());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhone_number());
            ps.setString(4, c.getAddress());
            ps.setInt(5, c.getAccount_id());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //lay id cus moi them vao
    public Customer getTop1Customer() {
        String sql = "select top 1 * from [customer] order by customer_id desc";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //getProductbyID
    public Customer getcustomerByPID(int cID) {
        String sql = "select*from customer where customer_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //lay ra top 5 khach hang co so lan mua va order_toal cao nhat
    //lay id cus moi them vao
    public List<Customer> getTop5Customer() {
        List<Customer> list = new ArrayList<>();
        String sql = "select a.fullname, o.account_id, count(o.account_id) as [so_lan_mua], SUM (order_total) AS [tong_gia_tri_don_hang] \n"
                + "from [Order] o\n"
                + "join Account a on a.account_id = o.account_id\n"
                + "group by a.fullname, o.account_id\n"
                + "order by [so_lan_mua] desc";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getCustomerIDByOR(int orderid) {
        int customerId = 0;
        rs = null;
        String sql = "select customer_id from [Order] where order_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderid);
            rs = ps.executeQuery();
            if (rs.next()) {
                customerId = rs.getInt("customer_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerId;
    }

    public String getCustomerNameByID(int cusid) {
        String customer_name = "";
        String sql = "select Customer_name from Customer where customer_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cusid);
            rs = ps.executeQuery();
            if (rs.next()) {
                customer_name = rs.getString("customer_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_name;
    }

    public static void main(String[] args) throws SQLException {
        customerDAO dao = new customerDAO();
        String cusid = dao.getCustomerNameByID(20);
        System.out.println(cusid);
    }
}

