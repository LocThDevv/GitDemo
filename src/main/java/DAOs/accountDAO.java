/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Account;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class accountDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public accountDAO() {
        conn = DBConnection.DbConnection.getConnection();
    }

//login
    public Account Login(String user, String pass) {
        String sql = "select*from Account where\n"
                + "username = ? and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, getMD5Hash(pass));
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt("account_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin"),
                        rs.getString("fullname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //UpdatePassword
    public int UpdatePassword(String pass, String user) {
        int kq = 0;
        String sql = "update Account set password = ?\n"
                + "where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, getMD5Hash(pass));
            ps.setString(2, user);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //updateAccount
    public int UpdateAccount(String phone, String email, String fullname, int account_id) {
        int kq = 0;
        String sql = "UPDATE Account\n"
                + "SET  phone_number = ?, email = ?, fullname = ?\n"
                + "WHERE account_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, email);
            ps.setString(3, fullname);
            ps.setInt(4, account_id);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //updateAccountByAD
    public int UpdateAccountByAD(Account ac) {
        int kq = 0;
        String sql = "UPDATE Account \n"
                + "SET  username = ?, [password] = ?, phone_number = ?, isAdmin = ?, isSell = ?, email = ?, fullname = ?\n"
                + "WHERE account_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ac.getUsername());
            ps.setString(2, ac.getPassword());
            ps.setString(3, ac.getPhone_number());
            ps.setInt(4, ac.getIsAdmin());
            ps.setInt(5, ac.getIsSell());
            ps.setString(6, ac.getEmail());
            ps.setString(7, ac.getFullname());
            ps.setInt(8, ac.getAccount_id());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //get account by id
    public Account getAccountByAcID(int Ac_id) {
        String sql = "select*from Account where\n"
                + "account_id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Ac_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getInt("account_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin"),
                        rs.getString("fullname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //add account
    public int addAccount(Account ac) {
        int kq = 0;
        String sql = "insert into Account \n"
                + "values(?,?,?,?,0,0,?);";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ac.getUsername());
            ps.setString(2, ac.getPassword());
            ps.setString(3, ac.getPhone_number());
            ps.setString(4, ac.getEmail());
            ps.setString(5, ac.getFullname());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //add account by Admin
    public int addAccountByAdmin(Account ac) {
        int kq = 0;
        String sql = "insert into Account \n"
                + "values(?,?,?,?,?,?,?);";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ac.getUsername());
            ps.setString(2, ac.getPassword());
            ps.setString(3, ac.getPhone_number());
            ps.setString(4, ac.getEmail());
            ps.setInt(5, ac.getIsSell());
            ps.setInt(6, ac.getIsAdmin());
            ps.setString(7, ac.getFullname());
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    //get account by Username
    //get account by id
    public Account getAccountByUS(String us) {
        String sql = "select * from account where username =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, us);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(
                        rs.getInt("account_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin"),
                        rs.getString("fullname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //getAll
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("account_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin"),
                        rs.getString("fullname")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Delete Account
    public int DeleteAccount(int id) {
        int kq = 0;
        String sql = "delete from account where account_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(accountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
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

    public static void main(String[] args) {
        accountDAO dao = new accountDAO();
        Account ac  = new Account(1042, "ttt", "123", "122", "133", 0, 0, "tinh");
        dao.UpdateAccountByAD(ac);
    }
}
